package iti.Misk.configs.filters;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/AddProductsToCart", "/addSingleToCart", "/checkoutServlet", "/ConfirmOrderServlet", "/profile","/profile.jsp","/shoppingCartServlet","/updatePassword"})
public class UserFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = req.getSession(false);
        if (session != null) {
            if(session.getAttribute("userId")!=null) {
                chain.doFilter(req, res);
            }else{
                // go to error because of not logging..
                System.out.println("Unlogged user");
                res.sendRedirect("accessDenied.html");
            }
        }

    }

}
