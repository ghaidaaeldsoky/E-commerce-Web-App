package iti.Misk.controller.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.controller.services.interfaces.PerfumeServices;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.dtos.ProductsDto;
import iti.Misk.model.enums.Gender;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/productSettings")
public class ProductSettingsController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
           if(req.getParameter("productId")=="")
            {
                CreateNewProduct(req);
            }
            else{
                updateProduct(req);
            }

      
        

    }
    private void updateProduct(HttpServletRequest req) {
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("multipart/")) {
            try {
                String imgPath;
                String oldImgPath = req.getParameter("productUrl");
    
                if (oldImgPath != null && !oldImgPath.trim().isEmpty()) {
                    imgPath = oldImgPath;
                    System.out.println("Old Image Path: " + oldImgPath);
                } else {
                    imgPath = savePhotoOnTheServer(req.getPart("productImage"));
                }
    
                String productId = req.getParameter("productId");
                String productName = req.getParameter("productName");
                String productPrice = req.getParameter("productPrice");
                String productQuantity = req.getParameter("productQuantity");
                String brand = req.getParameter("brand");
                String size = req.getParameter("size");
                String gender = req.getParameter("gender");
                String description = req.getParameter("description");
    
                double price = parseInteger(productPrice, 0);
                int quantity = parseInteger(productQuantity, 0);
                int productSize = parseInteger(size, 0);
                int id = parseInteger(productId, 0); 
    
                    Gender genderEnum = Gender.valueOf(gender.toUpperCase());

                    PerfumeDto productDto = new PerfumeDto(
                        id, productName, description, price, quantity, imgPath, brand, size, genderEnum
                    );
        
                    PerfumeServices perfume = PerfumeServicesImpl.getPerfumeServices();
                perfume.addPerfume(productDto);
    
            } catch (IOException | ServletException e) {
                // Log or print the error
                System.err.println("Error occurred while updating product: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Helper method to safely parse integers and avoid NumberFormatException
     */
    private int parseInteger(String value, int defaultValue) {
        try {
            if (value != null && !value.trim().isEmpty()) {
                return Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer value: " + value);
        }
        return defaultValue;
    }

        private void CreateNewProduct(HttpServletRequest req) {
        
                if(req.getContentType() != null && req.getContentType().toLowerCase().startsWith("multipart/"))
                    {try {
                     String imgPath =   savePhotoOnTheServer(req.getPart("productImage"));

                   
                     String productName = req.getParameter("productName");
                     String productPrice = req.getParameter("productPrice");
                     String productQuantity = req.getParameter("productQuantity");
                     String brand = req.getParameter("brand");
                     String size = req.getParameter("size");
                     String gender = req.getParameter("gender");
                     String description = req.getParameter("description");

                     ProductsDto productDto = new ProductsDto(imgPath, productName, description,Integer.parseInt(productPrice), Integer.parseInt(productQuantity),  brand,  Integer.parseInt(size),  gender);

                     System.out.println(productDto);
                    
                    } catch (IOException | ServletException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }}

    }
        private String savePhotoOnTheServer( Part imgPart) {
            
            String imgName = imgPart.getSubmittedFileName();

            System.out.println("hello we are here");
            String pathdir = getServletContext().getRealPath("/")+"productsPhotos";

            File uploadDir = new File(pathdir);
            
            if(!uploadDir.exists())
            {
                uploadDir.mkdirs();
            }

            String  uploadImgPath = pathdir +File.separator + imgName;

            try {
                imgPart.write(uploadImgPath);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return uploadImgPath;

        }
        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
            String productId =req.getParameter("productId");

            if(productId  != null)
            {
            System.out.println(" delete the product with id "+ productId) ;

            int prodId= Integer.parseInt(productId);

            boolean deleted = deleteProductFromDataBase(prodId);

            if(deleted)
            {
                resp.setStatus(HttpServletResponse.SC_OK);
            }
            else{
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

            }

            else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

            
        }
        private boolean deleteProductFromDataBase(int prodId) {
           
     return PerfumeServicesImpl.getPerfumeServices().deletePerfume(prodId);
        }
}
