package iti.Misk.controller.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/toastmessage")
public class ToastMessegeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("alertMessage");
        String type = req.getParameter("alertType");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String jsonResponse = "{\"alertMessage\": \"" + message + "\", \"alertType\": \"" + type + "\"}";
        resp.getWriter().write(jsonResponse);

    }
}
