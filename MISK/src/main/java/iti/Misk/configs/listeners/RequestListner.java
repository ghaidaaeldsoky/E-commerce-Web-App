package iti.Misk.configs.listeners;

import iti.Misk.utils.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;



@WebListener
public class RequestListner  implements ServletRequestListener{
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        request.setAttribute("em", em);

    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        EntityManager em =(EntityManager) request.getAttribute("em");
        em.close();
    }
}
