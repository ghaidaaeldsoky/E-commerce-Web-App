package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import iti.Misk.model.dtos.ProductsDto;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loadProducts")
public class ProductAdminController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<ProductsDto> products = fetchAllProducts();

        
        String jsonResponse = convertToJson(products);

        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        
        PrintWriter out = resp.getWriter();
        out.write(jsonResponse);
        out.flush();
    }

    private String convertToJson(List<ProductsDto> products) {
        JsonArrayBuilder productArray = Json.createArrayBuilder();

        for (ProductsDto productDto : products) {
            productArray.add(Json.createObjectBuilder()
                    .add("productId", productDto.getProductId())
                    .add("photo", productDto.getPhoto())
                    .add("name", productDto.getName())
                    .add("description", productDto.getDescription())
                    .add("price", productDto.getPrice())
                    .add("quantity", productDto.getQuantity())
                    .add("brand", productDto.getBrand())
                    .add("size", productDto.getSize())
                    .add("gender", productDto.getGender()));
        }

        JsonArray jsonArray = productArray.build();

        return jsonArray.toString();
    }

    private List<ProductsDto> fetchAllProducts() {
        
        List<ProductsDto> products = new ArrayList<>();

        // Sample product data
        products.add(new ProductsDto(1, "OIP.jpg", "Miss Dior", "Perfume Christian ",120, 100, "BrandA", 50, "Female"));
        products.add(new ProductsDto(2, "OIP.jpg", "Miss Dior", "Perfume Christian ",80, 200, "BrandB", 30, "Male"));
        products.add(new ProductsDto(3, "OIP.jpg", "Miss Dior","Perfume Christian ", 150, 150, "BrandC", 30, "Female"));

        return products;
    }
}
