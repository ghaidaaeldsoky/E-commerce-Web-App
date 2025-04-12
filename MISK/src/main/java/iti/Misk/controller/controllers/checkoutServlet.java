package iti.Misk.controller.controllers;


import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/checkoutServlet")
public class checkoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //some DB work
        ArrayList<Address> addresses=new ArrayList<>();
        Address address1 =new Address(1,"ksa","gada","125",20l);
        Address address2 =new Address(2,"oman","gada","125",10l);
        Address address3 =new Address(300,"qatar","gada","125",10l);
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

//        List<Product> l=(List<Product>) req.getSession(false).getAttribute("cartItems");
//        FileWriter fw=new FileWriter("whyyyyyyyyyyyyyy.txt");
//        for(Product p:l){
//            fw.write(p.toString());
//        }



        req.getSession(true).setAttribute("adr",addresses);
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkingOut.jsp");
       dispatcher.forward(req, resp);


    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
