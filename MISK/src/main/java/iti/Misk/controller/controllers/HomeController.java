package iti.Misk.controller.controllers;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
import iti.Misk.utils.Perfumes;
import iti.Misk.utils.enums.Pages;
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
        ServletContext context = getServletContext();
        Perfumes myPerfumes = (Perfumes) context.getAttribute("perfumes");
        String genderParam = req.getParameter("gender");
        Gender gender = null;
        double actualMinPrice = myPerfumes.getMinPrice();
        double actualMaxPrice = myPerfumes.getMaxPrice();
        req.setAttribute("minPrice", actualMinPrice);
        req.setAttribute("maxPrice", actualMaxPrice);

        if (genderParam != null && !genderParam.isEmpty() && !genderParam.equalsIgnoreCase("all")) {
            try {
                gender = Gender.valueOf(genderParam);
            } catch (IllegalArgumentException e) {
                System.out.println("Illegal gender");
            }
        }

        for (PerfumeDto p : myPerfumes.getPerfumes(1)) {
            System.out.println("Perfume = " + p.getName());
        }

        // All Perfumes As Gson Object to Front end
        // List<PerfumeDto> perfumeList = myPerfumes.getPerfumes(1);

        // Gson gson = new Gson();
        // String allPerfumesJson = gson.toJson(perfumeList);
        // req.setAttribute("allPerfumesJson", allPerfumesJson);

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
        List<PerfumeDto> perfumesPage = myPerfumes.getFilteredPerfumes(null, gender, 0, Double.MAX_VALUE, pageNumber);
        ;

        int totalPages = myPerfumes.getNoOfPages();

        req.setAttribute("perfumesPage", perfumesPage);
        req.setAttribute("currentPage", pageNumber);
        req.setAttribute("noOfPages", totalPages);

        System.out.println("Page Number: " + pageNumber);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Perfumes in Page: " + perfumesPage.size());

        System.out.println("Received Gender: " + genderParam);
        System.out.println("Converted Gender: " + gender);
        // Pages.HOME.forward(req, resp);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
