package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iti.Misk.model.dtos.OrderDto;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loadOrders")
public class OrderAdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<OrderDto> orders = fetchAllOrders();

        String jsonResponse = convertToJson(orders);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.write(jsonResponse);
        out.flush();
    }

    private List<OrderDto> fetchAllOrders() {
        List<OrderDto> orders = new ArrayList<>();

        
        orders.add(new OrderDto("Sama Mohamed", 120, "Cairo, Egypt", "2025-03-29",
                Arrays.asList("Protein Bar", "Omega-3 Capsules")));

        orders.add(new OrderDto("Ali Mohamed", 80, "Giza, Egypt", "2025-03-28",
                Arrays.asList("Vitamin D", "Multivitamin")));

        orders.add(new OrderDto("Laila Hussein", 150, "Alexandria, Egypt", "2025-03-27",
                Arrays.asList("Protein Shake", "Fish Oil")));

        return orders;
    }

    private String convertToJson(List<OrderDto> orders) {
        JsonArrayBuilder ordersArray = Json.createArrayBuilder();

        for (OrderDto order : orders) {
            JsonArrayBuilder productsArray = Json.createArrayBuilder();
            for (String product : order.getProducts()) {
                productsArray.add(product);
            }

            JsonObjectBuilder orderObject = Json.createObjectBuilder()
                    .add("user", order.getUser())
                    .add("totalAmount", order.getTotalAmount())
                    .add("address", order.getAddress())
                    .add("orderDate", order.getOrderDate())
                    .add("products", productsArray);

            ordersArray.add(orderObject);
        }

        JsonArray jsonArray = ordersArray.build();
        return jsonArray.toString();
    }
}
