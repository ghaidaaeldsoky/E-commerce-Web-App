package iti.Misk.controller.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/loadOrders")
public class OrderAdminController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    
        JsonArrayBuilder ordersArray = Json.createArrayBuilder();
    
        ordersArray.add(Json.createObjectBuilder()
                .add("user", "Sama Mohamed")
                .add("totalAmount", "$120")
                .add("address", "Cairo, Egypt")
                .add("orderDate", "2025-03-29")
                .add("products", Json.createArrayBuilder()
                        .add("Protein Bar")
                        .add("Omega-3 Capsules")
                )
        );
    
        ordersArray.add(Json.createObjectBuilder()
                .add("user", "Ali Mohamed")
                .add("totalAmount", "$80")
                .add("address", "Giza, Egypt")
                .add("orderDate", "2025-03-28")
                .add("products", Json.createArrayBuilder()
                        .add("Vitamin D")
                        .add("Multivitamin")
                )
        );
    
        ordersArray.add(Json.createObjectBuilder()
                .add("user", "Laila Hussein")
                .add("totalAmount", "$150")
                .add("address", "Alexandria, Egypt")
                .add("orderDate", "2025-03-27")
                .add("products", Json.createArrayBuilder()
                        .add("Protein Shake")
                        .add("Fish Oil")
                )
        );
    
        // Build the JsonArray and convert it to a String
        JsonArray jsonArray = ordersArray.build();
        String jsonResponse = jsonArray.toString();
    
        PrintWriter out = resp.getWriter();
        out.write(jsonResponse);
        out.flush();
    }
    

}
