package iti.Misk.configs.listeners;

import iti.Misk.utils.EntityManagerFactorySingleton;
import iti.Misk.utils.Perfumes;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListner implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("perfumes", Perfumes.getPerfumesInstance());
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactorySingleton.close();
    }
}
