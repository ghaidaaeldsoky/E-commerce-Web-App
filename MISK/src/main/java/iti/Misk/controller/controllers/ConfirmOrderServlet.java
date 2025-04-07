package iti.Misk.controller.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String selectedAddressId = req.getParameter("addID");

        //must be calculated here from DB
        String totalOrderPrice=req.getParameter("totalvalue");

        try(FileWriter fw=new FileWriter("order.txt",true)) {
            fw.write("selectedAddressId: " + selectedAddressId + "\n");
            fw.write("totalOrderPrice: " + totalOrderPrice + "\n");
        }



        //first we will insert a row in the (order)table:
        //order id autoincrement
        //user id from session
       // totalOrderPrice
        //current time
        //selectedAddressId

        //second we will insert a row in the (orderitems)table:
        //get the order id from (order)table using the ordertime &user id
        //from user id we can get product ids & quantities from shopping cart table from DB


        req.getRequestDispatcher("confirmation.jsp").forward(req,resp);
    }

}
