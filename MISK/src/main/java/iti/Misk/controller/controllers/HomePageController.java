package iti.Misk.controller.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.model.dtos.PerfumeDto;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Entity;


@WebServlet("/homePage")
public class HomePageController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EntityManager em = (EntityManager) req.getAttribute("em");
        List<PerfumeDto> perfumesPage = PerfumeServicesImpl.getPerfumeServices().getFilteredPerfumes(
                null, null, 0, 800.0, 1, em
        );

        for(PerfumeDto p : perfumesPage) {
            System.out.println("-------");
            System.out.println(p.getName());
            System.out.println(p.getBrand());
            System.out.println(p.getId());
        }

        perfumesPage = perfumesPage.stream().limit(6).collect(Collectors.toList());

        req.setAttribute("perfumesPage", perfumesPage);

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
