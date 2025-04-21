package iti.Misk.controller.controllers;

import iti.Misk.controller.repositories.impls.AddressRepoEmployee;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.Product;
import iti.Misk.model.dtos.ProductsDto;
import iti.Misk.model.newentity.Useraddress;
import iti.Misk.utils.mappers.AddressMapper;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/checkoutServlet")
public class checkoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // //some DB work
        // ArrayList<Address> addresses=new ArrayList<>();
        // Address address1 =new Address(1,"ksa","gada","125",20l);
        // Address address2 =new Address(2,"oman","gada","125",10l);
        // Address address3 =new Address(300,"qatar","gada","125",10l);
        // addresses.add(address1);
        // addresses.add(address2);
        //// addresses.add(address3);

        int UserId = (int) req.getSession(false).getAttribute("userId");

        EntityManager em = (EntityManager) req.getAttribute("em");
        Set<Useraddress> userAddress = new UserRepoImpl().getUseraddress(UserId, em);
        List<Address> addresses = new ArrayList<>();
        if (userAddress != null) {
            for (Useraddress useraddress : userAddress) {
                addresses.add(AddressMapper.toDto(useraddress));
            }
        }

        //
        // List<ProductsDto> l=(List<ProductsDto>)
        // req.getSession(false).getAttribute("cartItems");
        // FileWriter fw=new FileWriter("wheeee.txt");
        // for(ProductsDto p:l){
        // fw.write(p.getName()+"\n");
        // }
        // fw.write("session "+session);
        // fw.flush();
        // fw.close();

        HttpSession session = req.getSession(false);
        session.setAttribute("adr", addresses);
        req.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/checkingOut.jsp");
        dispatcher.forward(req, resp);

    }

}
