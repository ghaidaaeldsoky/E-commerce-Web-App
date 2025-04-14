package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import iti.Misk.model.dtos.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();

        // get User from session

        UserDto currentUser = new UserDto("ghaidaaeldsoky", "01092690533", "ghaidaa@gmail.com", "23-9-2345","Software" ,"2000" , "", "pass123");


        Gson gson = new Gson();
        String userJson = gson.toJson(currentUser);

        out.print(userJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch(action) {
            case "updateAccount":
            System.out.println("Update Account successfully");
                // update in database..
                break;
            case "updatePassword" :
            System.out.println("Update Password successfully");
                break;
            case "updateCredit" :
            System.out.println("Update Credit limit successfully");
                break;
            case "addAddress":
            System.out.println("Add Address successfully");
                break;
            case "deleteAddress" :
            System.out.println("delete Address successfully");
                break;

        }
    }
}
