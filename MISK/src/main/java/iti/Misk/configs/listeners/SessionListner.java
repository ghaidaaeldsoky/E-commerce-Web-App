package iti.Misk.configs.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.HashSet;

@WebListener
public class SessionListner implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // fetch db and get a set of cart items IDs
        // and set it in the session
        HashSet<Integer> IDs  =new HashSet<>();


        se.getSession().setAttribute("productIds",IDs );


    }
}
