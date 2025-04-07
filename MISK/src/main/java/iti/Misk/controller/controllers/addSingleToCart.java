package iti.Misk.controller.controllers;


import iti.Misk.model.dtos.Userxsss;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addSingleToCart")
public class addSingleToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


      //Usersss current =(Usersss) req.getSession(false).getAttribute("user");
        Userxsss current = new Userxsss();
        current.setAdmin(false);

      if(current==null) {

            resp.sendRedirect("login.html");

      }
      else if(current!=null && !current.isAdmin()) {

          String productid=req.getParameter("proId");
          String quantity=req.getParameter("quantity");

//          Map<Integer,Integer> cartitems=(Map<Integer,Integer>)req.getSession(false).getAttribute("cart");
//
//            if(cartitems!=null) {
//                if(cartitems.containsKey(Integer.parseInt(productid))) {
//                    int oldquantity=cartitems.get(Integer.parseInt(productid));
//                    cartitems.put(Integer.parseInt(productid),oldquantity+Integer.parseInt(quantity));
//                    req.getSession(false).setAttribute("cart",cartitems);
//
//
//                }
//                else
//                cartitems.put(Integer.parseInt(productid),Integer.parseInt(quantity));
//                req.getSession(false).setAttribute("cart",cartitems);
//            }
//            else {
//                cartitems.put(Integer.parseInt(productid),Integer.parseInt(quantity));
//            }
//
//          //to check that the product data arrived correctly
//          try (FileWriter fileWriter = new FileWriter("cart.txt", true)) {
//              fileWriter.write("Product ID: " + productid + ", Quantity: " + quantity + "\n");
//          }

          //adding record to database in carttable
          resp.sendRedirect("home");
      }


    }
}
