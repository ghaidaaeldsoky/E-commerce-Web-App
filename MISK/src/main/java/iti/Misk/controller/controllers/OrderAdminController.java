package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iti.Misk.controller.repositories.impls.OrderRepoImpl;
import iti.Misk.model.dtos.OrderDto;
import iti.Misk.model.newentity.Order;
import iti.Misk.utils.EntityManagerFactorySingleton;
import iti.Misk.utils.mappers.OrderMapper;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.persistence.EntityManager;
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

     EntityManager em=   EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

     OrderRepoImpl orderRepoImpl = new OrderRepoImpl();

        List<Order> orders =  orderRepoImpl.getAllOrders(em);


        List<OrderDto> dtos= new ArrayList<>();

        for(Order  order: orders)
        {
            dtos.add(OrderMapper.mapToOrderDto(order));

        }

        
      

        return dtos;
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
