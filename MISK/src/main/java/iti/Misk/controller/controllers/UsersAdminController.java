package iti.Misk.controller.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import iti.Misk.model.dtos.UserDto;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loadUsers")
public class UsersAdminController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        List<UserDto> users = fetchAllUser();

        String jsonRespons = convertToJson(users);

        resp.setContentType("application/json");

        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.write(jsonRespons);

        out.flush();


    }

    private String convertToJson(List<UserDto> users) {
        
        JsonArrayBuilder userArray = Json.createArrayBuilder();

        for (UserDto userDto : users) {

            userArray.add(Json.createObjectBuilder()
            .add("userName",userDto.getUserName())
            .add("PhoneNumber",userDto.getPhoneNumber())
            .add("Email",userDto.getEmail())
            .add("birthday",userDto.getBirthDay())
            .add("job",userDto.getJob())
            .add("creditLimit",userDto.getCreditLimit())
            .add("interests",userDto.getIntersets()));
         
            
        }

        JsonArray  jsonArray = userArray.build();

        return jsonArray.toString();


    }

    private List<UserDto> fetchAllUser() {
    
        ArrayList<UserDto> users = new ArrayList<>();

        users.add(new UserDto("sama","01012345678","sama@example.com","2001-03-29","Admin","5000 egp", "Programming, Reading"));

        
        users.add(new UserDto("nada","01012345678","nada@example.com","2001-03-29","User","5000 egp", "Programming, Reading"));

    return users;

    }

}
