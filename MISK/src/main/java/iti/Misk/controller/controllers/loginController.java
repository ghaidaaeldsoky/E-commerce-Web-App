package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginController")
public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String type = req.getParameter("type");

        if(type.equals("email"))
        {
             checkIfEmailIsTrue(req,resp);

            
        }
        else if(type.equals("password"))
        {
            checkIfPasswordIsTrue(req,resp);
        }
        else 
        {
                //resp.sendRedirect("Users.jsp");

                logInUser(req,resp);


        }
        
    }

    private void logInUser(HttpServletRequest req, HttpServletResponse resp) {
        
        
        HttpSession session = req.getSession(true);


        String email = req.getParameter("email");


        boolean isAdmin =isAdmin(email);

       

        session.setAttribute("isAdmin", isAdmin(email));
        session.setAttribute("userId", 1);

       

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("redirect", true);


        String redirectUrl ;

        if(isAdmin)
        redirectUrl = "Users.jsp";

        else
        redirectUrl = "index.jsp";

        jsonObject.addProperty("redirectUrl", redirectUrl);


       String response = jsonObject.toString();
       try {
    
        PrintWriter out = resp.getWriter();
        out.write(response);
        out.flush();
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    }

    private boolean isAdmin(String email) {
            return true ;
    }

    private void checkIfEmailIsTrue(HttpServletRequest req, HttpServletResponse resp) {

        String email = req.getParameter("email");

        boolean valid = isValidEmail(email);

        resp.setContentType("application/json");

        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("valid", valid);

        String response = jsonResponse.toString();
        try {
            
            PrintWriter out = resp.getWriter();
            out.write(response);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }

    private boolean isValidPassword(String email) {
        
        return email.equals("test1234");
    }
    private void checkIfPasswordIsTrue(HttpServletRequest req, HttpServletResponse resp) {

        String email = req.getParameter("email");

        boolean valid = isValidEmail(email);

        String password = req.getParameter("password");

        boolean validPassword = isValidPassword(password);

        resp.setContentType("application/json");

        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("valid", valid&&validPassword);
      
        String response = jsonResponse.toString();
        try {
            
            PrintWriter out = resp.getWriter();
            out.write(response);
            out.flush();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }

    private boolean isValidEmail(String email) {
        
        return email.equals("sama230341@gmail.com");
    }
}
