package iti.Misk.controller.controllers;

import iti.Misk.model.dtos.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shoppingCartServlet")
public class shoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //fetched from DB
        List<Product> l=new ArrayList<>();
        Product product=new Product(1,"majestic men","this is the description","130 EGP","img/cart/cart1.png",7,"koria","30 mm","men",15,1.0);
        Product product2=new Product(200," men silver scent","this is the description","130 EGP","img/cart/cart2.png",5,"koria","30 mm","men",16,1.0);
        Product product3=new Product(300,"one man show","this is the description","130 EGP","img/category/oud.jpg",9,"koria","30 mm","men",17,1.0);
        l.add(product);
        l.add(product2);
        l.add(product3);
        req.setAttribute("prol",l);
        req.getRequestDispatcher("shoppingCart.jsp").forward(req,resp);
    }

}
