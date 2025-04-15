package iti.Misk.controller.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.JsonObject;

import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.controller.services.impls.UserServiceImpl;
import iti.Misk.controller.services.interfaces.UserService;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.utils.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginController")
public class loginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

        UserRepo userRepo = new UserRepoImpl() ;

         UserService service = new UserServiceImpl(userRepo);

    


        
        String type = req.getParameter("type");

        if(type.equals("email"))
        {
             checkIfEmailIsTrue(req,resp,em,service);

            
        }
        else if(type.equals("password"))
        {
            checkIfPasswordIsTrue(req,resp,em,service);
        }
        else 
        {
                //resp.sendRedirect("Users.jsp");

                logInUser(req,resp,em,service);


        }
        
    }

    private void logInUser(HttpServletRequest req, HttpServletResponse resp, EntityManager em, UserService service) {
        
        
        HttpSession session = req.getSession(true);


        String email = req.getParameter("email");


        UserDto userDto = service.findUserByEmail(email, em) ;

Boolean isAdmin = userDto.isIsAdmin();
       

        session.setAttribute("isAdmin",userDto.isIsAdmin());

        session.setAttribute("userId",userDto.getUserId());

            int userId = userDto.getUserId();
            ShoppingCartRepoImpl shoppingCartRepo = new ShoppingCartRepoImpl();
            List<Integer> l=shoppingCartRepo.getUserShoppingCart(userId,em).stream().map(
                    shoppingCart -> shoppingCart.getProduct().getProductId()

            ).collect(Collectors.toList());

            if (l==null){
               req.getSession().setAttribute("productIds",new HashSet<Integer>() );

            }
            else{

                HashSet<Integer> IDs = new HashSet<>(l);
                FileWriter fw = null ;
                try {
                    fw = new FileWriter("sds.txt");
                    for(int i : IDs)
                    {
                        fw.write(i + "\n");
                        fw.write(userId+"iddd");

                    }
                    fw.flush();
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                req.getSession().setAttribute("productIds",IDs );


            }


        


       

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("redirect", true);


        String redirectUrl ;

        if(isAdmin)
        redirectUrl = "Users.jsp";

        else
        redirectUrl = "home";

        jsonObject.addProperty("redirectUrl", redirectUrl);


       String response = jsonObject.toString();
       try {
    
        PrintWriter out = resp.getWriter();
        out.write(response);
        out.flush();
    } catch (IOException e) {
        
        e.printStackTrace();
    }
    }

    private boolean isAdmin(String email, EntityManager em) {
            return true ;
    }

    private void checkIfEmailIsTrue(HttpServletRequest req, HttpServletResponse resp, EntityManager em, UserService service) {

        String email = req.getParameter("email");

        boolean valid = isValidEmail(email,em,service);

        resp.setContentType("application/json");

        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("valid", valid);

        String response = jsonResponse.toString();
        try {
            
            PrintWriter out = resp.getWriter();
            out.write(response);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      
    }

    private boolean isValidPassword(String email, EntityManager em, UserService service, String email2, String password) {
        
        return service.checkPasswordValidation(email2, password, em);
    }
    private void checkIfPasswordIsTrue(HttpServletRequest req, HttpServletResponse resp, EntityManager em, UserService service) {

        String email = req.getParameter("email");

       

        String password = req.getParameter("password");

        boolean validPassword = isValidPassword(password,em,service,email,password);

        resp.setContentType("application/json");

        JsonObject jsonResponse = new JsonObject();

        jsonResponse.addProperty("valid", validPassword);
      
        String response = jsonResponse.toString();
        try {
            
            PrintWriter out = resp.getWriter();
            out.write(response);
            out.flush();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }

    private boolean isValidEmail(String email, EntityManager em,UserService service) {
        
        return service.checkEmailAvailability(email, em);
    }
}
