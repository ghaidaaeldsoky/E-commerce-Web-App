package iti.Misk.controller.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ValidateOrder")
public class ValidateOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            //get current user from session
            //get products id & qtys from shopping cart table in DB
            //check for the quantity availability using products table
            //check for credit limit availability
            //total order price is going to be calculated from db +shipping fees

        List<Integer>available_quantities=List.of(2, 5, 8);
        List<Integer>ordered_quantities=List.of(2, 3, 1);
        double available_limit=2000;
        String numericPart = req.getParameter("totalvalue").replaceAll("[^0-9.]", "").trim();
        double price = Double.parseDouble(numericPart);
        double totalOrderPrice=price;

        boolean quantityAvailable=true;
        boolean orderPriceAvailable=true;
        List<Integer> notAvailableproductIds=new ArrayList<>();
        String message="";

        for(int i=0;i<ordered_quantities.size();i++){
            if(available_quantities.get(i)<ordered_quantities.get(i)) {
               quantityAvailable=false;
                notAvailableproductIds.add(i);
            }
        }
        if(totalOrderPrice>available_limit) {
            orderPriceAvailable=false;
        }

        if(quantityAvailable&&orderPriceAvailable) {
            req.getRequestDispatcher("/ConfirmOrderServlet").forward(req, resp);
        }
        else {
           if(orderPriceAvailable==true && quantityAvailable==false) {

               message="the following products are not available in the required quantities: ";
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);


           } else if (orderPriceAvailable==false && quantityAvailable==true) {

               message="Your order price exceeds your credit limit";
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);
           }
           else if (orderPriceAvailable==false && quantityAvailable==false) {

                message="Your order price exceeds your credit limit and the following products are not available in the required quantities: ";
               req.setAttribute("errorMessage",message);
               req.getRequestDispatcher("/OrderIssueServlet").forward(req, resp);

           }
        }



    }
}
