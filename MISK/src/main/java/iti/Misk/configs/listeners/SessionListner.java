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
        IDs.add(198);
        IDs.add(199);
        IDs.add(156);
        IDs.add(157);
        IDs.add(1);

        se.getSession().setAttribute("productIds",IDs );


    }
}
