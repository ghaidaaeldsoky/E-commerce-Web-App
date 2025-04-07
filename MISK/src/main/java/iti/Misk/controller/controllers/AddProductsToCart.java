package iti.Misk.controller.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import iti.Misk.model.dtos.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/AddProductsToCart")
public class AddProductsToCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        BufferedReader reader = req.getReader();
        StringBuilder jsonInput = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonInput.append(line);
        }

        Gson gson = new Gson();
        Type productListType = new TypeToken<List<Product>>() {}.getType();
        List<Product> cartItems = gson.fromJson(jsonInput.toString(), productListType);

        //to check that the product data arrived correctly
        try (FileWriter fw = new FileWriter("cartitems.txt", true)) {
           for(Product product : cartItems) {
                fw.write(product.toString() + "\n");
            }
        }

        //adding to the db cart table

        req.getSession(true).setAttribute("cartItems", cartItems);
 //       req.setAttribute("cartItems", cartItems);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkoutServlet");
//        dispatcher.forward(req, resp);
//


    }
}
