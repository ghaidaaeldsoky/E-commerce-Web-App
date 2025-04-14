package iti.Misk.controller.controllers;


import iti.Misk.model.dtos.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/productDetailsServlet")
public class productDetailsServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //knowing the product id from the request I will get the product from DB
//        Product product=new Product(1,"majestic men","this is the description","130 EGP","img/category/oud.jpg",7,"koria","30 mm","men",15,1.0);
//        req.setAttribute("pro",product);
//        req.getRequestDispatcher("productDetails.jsp").forward(req,resp);
//    }
}
