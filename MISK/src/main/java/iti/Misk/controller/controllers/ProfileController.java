package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import iti.Misk.controller.repositories.impls.AddressRepoEmployee;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.services.impls.AddressServiceImp;
import iti.Misk.controller.services.impls.UserServiceImpl;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.Useraddress;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.Entity;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();

        // get User from session
        int UserId = (int) req.getSession(false).getAttribute("userId");
        EntityManager em = (EntityManager) req.getAttribute("em");

        // Get the user Object From db
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserDto currentUser = userServiceImpl.findUserById(UserId, em);
        Set<Address> userAddresses = userServiceImpl.getAddress(UserId, em);
        currentUser.setAddresses(userAddresses);
        Gson gson = new Gson();
        String userJson = gson.toJson(currentUser);

        out.print(userJson);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        int UserId = (int) req.getSession(false).getAttribute("userId");
        EntityManager em = (EntityManager) req.getAttribute("em");

        switch (action) {
            case "updateAccount":
                System.out.println("Update Account successfully");
                String username = req.getParameter("firstName");
                String email = req.getParameter("email");
                String phone = req.getParameter("phone");
                boolean emailExists = new UserServiceImpl().checkEmailAvailability(email, em);
                if(emailExists) {
                    resp.setContentType("application/json");
                    resp.getWriter().write("{\"emailExists\": true}");
                }else {
                    UserDto newUserDto = new UserDto();
                newUserDto.setEmail(email);
                newUserDto.setPhoneNumber(phone);
                newUserDto.setUserName(username);
                // update in database..
                new UserServiceImpl().updateUser(UserId, newUserDto, em);
                resp.setContentType("application/json");
                resp.getWriter().write("{\"emailExists\": false}");
                }
                
                break;

            case "updatePassword":
                System.out.println("Update Password successfully");
                String newPassword = req.getParameter("newPassword");
                UserDto newUserDto1 = new UserDto();
                newUserDto1.setPassword(newPassword);
                new UserServiceImpl().updateUser(UserId, newUserDto1, em);
                break;

            case "updateCredit":
                System.out.println("Update Credit limit successfully");
                String newCredit = req.getParameter("creditLimit");
                new UserRepoImpl().updateCreditLimit(UserId, new BigDecimal(newCredit), em);
                // Not working:..
                // UserDto newUserDto2 = new UserDto();
                // newUserDto2.setCreditLimit(newCredit);
                // new UserServiceImpl().updateUser(UserId, newUserDto2, em);
                break;

            case "addAddress":
                System.out.println("Add Address successfully");

                Useraddress newAddress = new Useraddress();
                newAddress.setState(req.getParameter("state"));
                newAddress.setCity(req.getParameter("city"));
                newAddress.setStreet(req.getParameter("street"));
                newAddress.setDepartmentNumber(Long.parseLong(req.getParameter("departmentNumber")));
                // List<Address> mine = new ArrayList<>();
                // mine.add(newAddress);
                // new UserServiceImpl().addListOfAddresses(UserId,mine , em);

                // Return new address id:
                int newId = new AddressRepoEmployee().addAddressForUser(UserId, newAddress, em); 

                resp.setContentType("application/json");
                resp.getWriter().write("{ \"newId\": " + newId + " }");

                break;
            case "deleteAddress":
                System.out.println("delete Address successfully");

                int addressId = Integer.parseInt(req.getParameter("addressId"));
                AddressServiceImp addressServiceImp = new AddressServiceImp();
                addressServiceImp.DeleteAddress(addressId, em);

                break;

        }
    }
}
