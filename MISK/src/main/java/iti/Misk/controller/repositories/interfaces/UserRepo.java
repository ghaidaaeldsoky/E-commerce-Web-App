package iti.Misk.controller.repositories.interfaces;

import java.util.List;

import iti.Misk.model.newentity.User;
import jakarta.persistence.EntityManager;

public interface UserRepo {

    public Boolean addNewUser(User user, EntityManager em);
    public void updateUser(User oldUser, User newUser, EntityManager em );
    public User getUserById(Integer userId,  EntityManager em);
    public List<User> getAllUsers(List<Integer> ids , EntityManager em);
    

} 
