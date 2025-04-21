package iti.Misk.controller.controllers;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LogoutController")
public class LogoutController  extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
	
		HttpSession session=request.getSession(false);

		if(session != null)
		{
			System.out.println("invalidate session");
			session.invalidate();
		}

		response.sendRedirect("login.jsp");
    }
}
