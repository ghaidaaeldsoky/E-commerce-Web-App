package iti.Misk.controller.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.model.dtos.Product;
import iti.Misk.model.dtos.ProductsDto;
import iti.Misk.utils.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/AddProductsToCart")
public class AddProductsToCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

try {
    BufferedReader reader = req.getReader();
    StringBuilder jsonInput = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
        jsonInput.append(line);
    }

    Gson gson = new Gson();
    Type productListType = new TypeToken<List<ProductsDto>>() {
    }.getType();
    List<ProductsDto> cartItems = gson.fromJson(jsonInput.toString(), productListType);


    EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

    //int id= ((Integer) req.getSession(false).getAttribute("id"));
    new ShoppingCartRepoImpl().clearUserShoppingCart(1, em);
    if(cartItems != null || !cartItems.isEmpty()) {
        new ShoppingCartRepoImpl().addListToCart(1, cartItems, em);
    }


    //adding to the db cart table
    HttpSession session = req.getSession(true);
    //to check that the product data arrived correctly
//    try (FileWriter fw = new FileWriter("xyz.txt", true)) {
//
//        fw.write("session" + session);
//        for (ProductsDto product : cartItems) {
//            fw.write(product.toString() + "\n");
//        }
//        fw.close();
//    }


    session.setAttribute("cartItems", cartItems);
    resp.setStatus(HttpServletResponse.SC_OK);
    resp.getWriter().write("Cart updated successfully.");
    //       req.setAttribute("cartItems", cartItems);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkoutServlet");
//        dispatcher.forward(req, resp);
//
}
catch (Exception e) {
    e.printStackTrace();
    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error: " + e.getMessage());
}
    }
}
