package iti.Misk.configs.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/Orders.jsp","/Users.jsp"})
public class AdminFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
                HttpSession httpSession = req.getSession(false);

                if(httpSession== null)
                {
                    res.sendRedirect("login.jsp");
                    return;
                    
                }
                else{
                    Object isAdmin = httpSession.getAttribute("isAdmin");

                    if(!(isAdmin instanceof Boolean)||!(Boolean)isAdmin )
                    {
                        res.sendRedirect("accessDenied.html");
                        return;

                    }
                    chain.doFilter(req, res);
                }
    }
}
