package iti.Misk.controller.controllers;

import iti.Misk.controller.repositories.impls.AddressRepoEmployee;
import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.User;
import iti.Misk.model.newentity.Useraddress;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ValidateOrder")
public class ValidateOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager em=(EntityManager) req.getAttribute("em");
        int userId=(int) req.getSession(false).getAttribute("userId");
        String  addressIDstring= req.getParameter("addID");
        int addressID= Integer.parseInt(addressIDstring);
       // int userID=1;
        User current=new UserRepoImpl().findUserById(userId,em);
        Useraddress useraddress=new AddressRepoEmployee().getAddressbyAddressID(addressID,em);
        BigDecimal creditLimit=current.getCreditLimit();
        List<Shoppingcart> shoppingcartList=new ShoppingCartRepoImpl().getUserShoppingCart(userId,em);
        List<String> shortageProductNames=new ArrayList<>();
        BigDecimal totalOrderPrice = new BigDecimal("0.00");

        for(Shoppingcart shoppingCartItem:shoppingcartList){

            BigDecimal quantity = BigDecimal.valueOf(shoppingCartItem.getQuantity());
            BigDecimal price= shoppingCartItem.getProduct().getPrice();
            BigDecimal totalPrice = price.multiply(quantity);
            totalOrderPrice = totalOrderPrice.add(totalPrice);

            if(shoppingCartItem.getProduct().getQuantity() < shoppingCartItem.getQuantity()){
                shortageProductNames.add(shoppingCartItem.getProduct().getName());
            }

        }

       totalOrderPrice= totalOrderPrice.add(new BigDecimal("50.00")); //shipping cost

        Boolean quantityAvailable= shortageProductNames.size()==0;
        Boolean priceAvailable = totalOrderPrice.compareTo(creditLimit) <= 0;

        if(quantityAvailable && priceAvailable) {

            req.setAttribute("add", useraddress);
            req.setAttribute("orderItems", shoppingcartList);
            req.setAttribute("orderPrice", totalOrderPrice);
            //forward to confirm order
            req.getRequestDispatcher("/ConfirmOrderServlet").forward(req, resp);
        }
        else {
           if(priceAvailable==true && quantityAvailable==false) {

               StringBuilder sb= new StringBuilder();
               if(shortageProductNames.size()>0){
                   for(String productName:shortageProductNames){
                       sb.append(productName).append(", ");
                   }
               }

              String message="the following products are not available in the required quantities:"+" "+sb.toString();
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);


           } else if (priceAvailable==false && quantityAvailable==true) {

               String message="Your order price exceeds your credit limit";
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);
           }
           else if (priceAvailable==false && quantityAvailable==false) {

               StringBuilder sb= new StringBuilder();
               if(shortageProductNames.size()>0){
                   for(String productName:shortageProductNames){
                       sb.append(productName).append(", ");
                   }
               }

               String message="Your order price exceeds your credit limit and the following products are not available in the required quantities:"+" "+sb.toString();
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);

           }
        }



    }
}
