package iti.Misk.controller.controllers;

import java.io.IOException;

import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.services.impls.UserServiceImpl;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.User;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatePassword")
public class UpdatePasswordController extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int UserId = (int) req.getSession(false).getAttribute("userId");
        EntityManager em = (EntityManager) req.getAttribute("em");
        
        System.out.println("Update Password successfully");
        String newPassword = req.getParameter("newPassword");
        String currentPassword = req.getParameter("currentPassword");

        User myUser = new UserRepoImpl().findUserById(UserId, em);
        // UserDto userDto = new UserServiceImpl().findUserById(UserId, em);

        System.out.println("Real password: " + myUser.getPassword());
        System.out.println("New Passweod: " + newPassword);
        System.out.println("Current Password field: " + currentPassword);

        if (myUser == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("User not found");
            return;
        }

        if (!myUser.getPassword().equals(currentPassword)) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Current password is incorrect");
            return;
        }

        if (myUser.getPassword().equals(newPassword)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Your new password is the same as the old one");
            return;
        }

        myUser.setPassword(newPassword);
        new UserRepoImpl().updateUser(UserId, myUser, em);
        
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Password updated successfully");
    }

}
