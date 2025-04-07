package iti.Misk.controller.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/CartCounter")
public class CartCounterServlet extends HttpServlet {



    //for increasing the counter
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Integer> ids = (Set<Integer>) req.getSession().getAttribute("productIds");
        Integer id = Integer.parseInt(req.getParameter("productId"));
        ids.add(id);
        req.getSession().setAttribute("productIds", ids);
        resp.getWriter().write(ids.size() );

    }



    //for decreasing the counter
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Integer> ids = (Set<Integer>) req.getSession().getAttribute("productIds");
        Integer id = Integer.parseInt(req.getParameter("productId"));
        ids.remove(id);
        req.getSession().setAttribute("productIds", ids);
        resp.getWriter().write(ids.size() );

    }
}
