package iti.Misk.controller.controllers;

import java.io.IOException;

import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.controller.services.impls.UserServiceImpl;
import iti.Misk.controller.services.interfaces.UserService;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.utils.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
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

        Address address = new Address();
        
        address.setState(request.getParameter("state"));

        address.setCity(request.getParameter("city"));

        address.setDepartmentNumber(Long.parseLong(request.getParameter("department")));

        System.out.println(request.getParameter(request.getParameter("street")));
        address.setStreet(request.getParameter("street"));

        System.out.println(address.toString());
     UserRepo userRepo = new UserRepoImpl() ;

         UserService service = new UserServiceImpl(userRepo);

         EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

         service.addNewUserDto(user, address, em);

     

        resp.sendRedirect("login.jsp");
        
    }

}
