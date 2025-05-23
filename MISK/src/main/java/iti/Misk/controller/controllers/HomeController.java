package iti.Misk.controller.controllers;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
// import iti.Misk.utils.Perfumes;
import iti.Misk.utils.enums.Pages;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get the perfumes from Context
        ServletContext context = getServletContext();
        // Perfumes myPerfumes = (Perfumes) context.getAttribute("perfumes");

        EntityManager em = (EntityManager) req.getAttribute("em");
        PerfumeServicesImpl.getPerfumeServices();
        // get the parameters from user 
        String genderParam = req.getParameter("gender");
        String searchQuery = req.getParameter("search");

        Gender gender = null;
        if (searchQuery != null && searchQuery.trim().isEmpty()) {
            searchQuery = null;
        }

        if (genderParam != null && !genderParam.isEmpty() && !genderParam.equalsIgnoreCase("all")) {
            try {
                gender = Gender.valueOf(genderParam);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal gender");
            }
        }

        // get and set the maximum price from db
        String minPriceParam = req.getParameter("minPrice");
        String maxPriceParam = req.getParameter("maxPrice");

        double actualMinPrice = 0.0;
        double actualMaxPrice = PerfumeServicesImpl.getPerfumeServices().getMaxPrice(em);

        double minPrice = 0;
        double maxPrice = PerfumeServicesImpl.getPerfumeServices().getMaxPrice(em);

        try {
            if (minPriceParam != null && !minPriceParam.isEmpty()) {
                minPrice = Double.parseDouble(minPriceParam);
            }
            if (maxPriceParam != null && !maxPriceParam.isEmpty()) {
                maxPrice = Double.parseDouble(maxPriceParam);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid price parameters");
        }

        // Current Page
        String pageParam = req.getParameter("page");
        int pageNumber = 1;

        try {
            pageNumber = Integer.parseInt(pageParam);
            if (pageNumber < 1)
                pageNumber = 1;
        } catch (Exception e) {
            pageNumber = 1;
        }

       
        // // Pagination
        // List<PerfumeDto> perfumesPage = myPerfumes.getPerfumes(pageNumber);
        List<PerfumeDto> perfumesPage = PerfumeServicesImpl.getPerfumeServices().getFilteredPerfumes(
                searchQuery, gender, minPrice, maxPrice, pageNumber, em
        );
        int totalPages = PerfumeServicesImpl.getPerfumeServices().getTotalPages(em, searchQuery, gender, minPrice, maxPrice);

        req.setAttribute("actualMinPrice", actualMinPrice);
        req.setAttribute("actualMaxPrice", actualMaxPrice);

        req.setAttribute("perfumesPage", perfumesPage);
        req.setAttribute("currentPage", pageNumber);
        req.setAttribute("noOfPages", totalPages);

        req.setAttribute("selectedMinPrice", minPrice);
        req.setAttribute("selectedMaxPrice", maxPrice);

        req.setAttribute("searchQuery", searchQuery);

        System.out.println("Page Number: " + pageNumber);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Perfumes in Page: " + perfumesPage.size());

        System.out.println("Received Gender: " + genderParam);
        System.out.println("Converted Gender: " + gender);
        // Pages.HOME.forward(req, resp);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
