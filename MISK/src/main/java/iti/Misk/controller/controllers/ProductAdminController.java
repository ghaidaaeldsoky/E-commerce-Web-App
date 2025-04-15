package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.controller.services.interfaces.PerfumeServices;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.dtos.ProductsDto;
import iti.Misk.model.enums.Gender;
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
        
        List<PerfumeDto> products = fetchAllProducts();

        
        String jsonResponse = convertToJson(products);

        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        
        PrintWriter out = resp.getWriter();
        out.write(jsonResponse);
        out.flush();
    }

    private String convertToJson(List<PerfumeDto> products) {
        JsonArrayBuilder productArray = Json.createArrayBuilder();

        for (PerfumeDto productDto : products) {
            productArray.add(Json.createObjectBuilder()
                    .add("productId", productDto.getId())
                    .add("photo", productDto.getPhoto())
                    .add("name", productDto.getName())
                    .add("description", productDto.getDescription())
                    .add("price", productDto.getPrice())
                    .add("quantity", productDto.getQuantity())
                    .add("brand", productDto.getBrand())
                    .add("size", productDto.getSize())
                    .add("gender", productDto.getGender().name()));

                  
   

 
        }

        JsonArray jsonArray = productArray.build();

        return jsonArray.toString();
    }

    private List<PerfumeDto> fetchAllProducts() {

        PerfumeServices perfume = PerfumeServicesImpl.getPerfumeServices();
        
       perfume.getAllPerfumes();

      

        return  perfume.getAllPerfumes();
    }
}
