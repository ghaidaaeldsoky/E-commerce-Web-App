package iti.Misk.controller.controllers;

import iti.Misk.controller.repositories.impls.*;
import iti.Misk.model.newentity.*;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager em = (EntityManager)req.getAttribute("em");
        int UserId = (int) req.getSession(false).getAttribute("userId");
        // int UserId = 1; // For testing purposes, replace with actual user ID retrieval logic
        User currentUser = new UserRepoImpl().findUserById(1,em);
        Useraddress useraddress = (Useraddress) req.getAttribute("add");
        List<Shoppingcart> shoppingcartList = (List<Shoppingcart>) req.getAttribute("orderItems");
        BigDecimal totalOrderPrice = (BigDecimal) req.getAttribute("orderPrice");


                    //placing a row in orders table and order items table

        Order order = new Order();
        order.setUser(currentUser);
        order.setUseraddress(useraddress);
        order.setTotalAmount(totalOrderPrice);
        order.setOrderDate(Timestamp.valueOf(java.time.LocalDateTime.now()));
        int orderID= new OrderRepoImpl().addNewOrder(order, em);

        if(orderID!=-1){
            Order order1=new OrderRepoImpl().getOrder(em, orderID);
            new OrderItemsRepoImpl().addListOrderItem(order1, shoppingcartList, em);
            Set<Orderitems> set=new OrderItemsRepoImpl().getOrderItemsByOrderId(orderID, em);
            new OrderRepoImpl().setOrderItemsList(orderID, set, em);
        }

                        //clear shopping cart

        new ShoppingCartRepoImpl().clearUserShoppingCart(UserId, em);

                        //counter related part
       Set<Integer> ids = (Set<Integer>) req.getSession().getAttribute("productIds");
       ids.clear();
       req.getSession().setAttribute("productIds", ids);

                        //reduce credit limit
        BigDecimal newLimit = (currentUser.getCreditLimit().subtract(totalOrderPrice));
        new UserRepoImpl().updateCreditLimit(UserId,newLimit , em);


                        //reduce inventory
        for (Shoppingcart item : shoppingcartList) {
            Product product = item.getProduct();
            int newQuantity = product.getQuantity()-item.getQuantity();
            product.setQuantity(newQuantity);
            new ProductRepoImpl().updateProduct(product, em);
        }

        req.getRequestDispatcher("confirmation.jsp").forward(req,resp);
    }
















//        String selectedAddressId = req.getParameter("addID");
//
//        //must be calculated here from DB
//        String totalOrderPrice=req.getParameter("totalvalue");
//
//        try(FileWriter fw=new FileWriter("order.txt",true)) {
//            fw.write("selectedAddressId: " + selectedAddressId + "\n");
//            fw.write("totalOrderPrice: " + totalOrderPrice + "\n");
//        }



        //first we will insert a row in the (order)table:
        //order id autoincrement
        //user id from session
       // totalOrderPrice
        //current time
        //selectedAddressId

        //second we will insert a row in the (orderitems)table:
        //get the order id from (order)table using the ordertime &user id
        //from user id we can get product ids & quantities from shopping cart table from DB




}
