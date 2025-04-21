package iti.Misk.controller.controllers;

import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.model.dtos.Product;
import iti.Misk.model.dtos.ShoppingCartDto;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.utils.EntityManagerFactorySingleton;
import iti.Misk.utils.mappers.ShoppingCartMapper;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/shoppingCartServlet")
public class shoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager em =(EntityManager) req.getAttribute("em");
        int UserId = (int) req.getSession(false).getAttribute("userId");
         List<Shoppingcart> shoppingCartList=new ShoppingCartRepoImpl().getUserShoppingCart(UserId,em);
        List<ShoppingCartDto> l= shoppingCartList.stream().map(ShoppingCartMapper::toDto).collect(Collectors.toList());
        Iterator<ShoppingCartDto> iterator = l.iterator();
        while (iterator.hasNext()) {
            ShoppingCartDto shoppingCartDto = iterator.next();

            if(shoppingCartDto.getQuantity() <= 0) {
                iterator.remove();
                continue;
            }

            if (shoppingCartDto.getStorage() <= 0) {
                iterator.remove();
                continue;
            }


            if (shoppingCartDto.getQuantity() >= shoppingCartDto.getStorage()) {
                shoppingCartDto.setQuantity(shoppingCartDto.getStorage());
            }

        }


//        fetched from DB
//        List<Product> l=new ArrayList<>();
//        Product product=new Product(2,"majestic men","this is the description","130 EGP","img/cart/cart1.png",7,"koria","30 mm","men",15,1.0);
//        Product product2=new Product(200," men silver scent","this is the description","130 EGP","img/cart/cart2.png",5,"koria","30 mm","men",16,1.0);
//        Product product3=new Product(300,"one man show","this is the description","130 EGP","img/category/oud.jpg",9,"koria","30 mm","men",17,1.0);
//        l.add(product);
//        l.add(product2);
//        l.add(product3);
        req.setAttribute("prol",l);
        req.getRequestDispatcher("shoppingCart.jsp").forward(req,resp);
    }

}
