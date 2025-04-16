package iti.Misk.controller.controllers;

import java.io.IOException;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.model.dtos.PerfumeDto;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Entity;

@WebServlet("/ProductDetails")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // get the product id info from query :
        String idParam = req.getParameter("id");
        EntityManager em = (EntityManager) req.getAttribute("em");
        // Product

        if (idParam != null) {
            int id = Integer.parseInt(idParam);

            PerfumeDto perfumeDetails = PerfumeServicesImpl.getPerfumeServices().getPerfumeById(id, em);
            if (perfumeDetails != null) {
                System.out.println("Getting perfume details for id: " + id);
                System.out.println("Result: " + perfumeDetails);
                req.setAttribute("pro", perfumeDetails);
                req.getRequestDispatcher("productDetails.jsp").forward(req, resp);
            } else {
                System.out.println("Not found from Product details servlet...");
                req.getRequestDispatcher("accessdenied2.jsp").forward(req,resp);
                // Not found ...
            }
        } else {
            System.out.println("error from Product details servlet...");
            // error ...
        }

    }
}
