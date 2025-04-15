package iti.Misk.configs.listeners;

import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.utils.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@WebListener
public class SessionListner implements HttpSessionAttributeListener{

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {

//        //(int)event.getValue()
//        if (event.getName().equals("userId")) {
//            EntityManager em= EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
//            ShoppingCartRepoImpl shoppingCartRepo = new ShoppingCartRepoImpl();
//            List<Integer> l=shoppingCartRepo.getUserShoppingCart(3,em).stream().map(
//                    shoppingCart -> shoppingCart.getProduct().getProductId()
//
//            ).collect(Collectors.toList());
//
//            if (l==null){
//                event.getSession().setAttribute("productIds",new HashSet<Integer>() );
//                em.close();
//                return;
//            }
//
//            em.close();
//            HashSet<Integer> IDs = new HashSet<>(l);
//            event.getSession().setAttribute("productIds",IDs );
//        }


    }


}
