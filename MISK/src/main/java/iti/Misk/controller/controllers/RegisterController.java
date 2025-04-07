package iti.Misk.controller.controllers;

import java.io.IOException;

import iti.Misk.model.dtos.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerController")
public class RegisterController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = new UserDto(
            request.getParameter("name"),
            request.getParameter("phoneNumber"),
            request.getParameter("email"),
            request.getParameter("birthday"),
            request.getParameter("job"),
            request.getParameter("creditCardLimit"),
            request.getParameter("interests"),
            request.getParameter("password")
        );

        System.out.println(user);

        //send dto to server 

        resp.sendRedirect("login.jsp");
        
    }

}
