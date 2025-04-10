package iti.Misk.controller.repositories.impls;

import java.util.List;

import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.model.newentity.User;
import jakarta.persistence.EntityManager;

public class UserRepoImpl implements UserRepo{

    @Override
    public Boolean addNewUser(User user, EntityManager em) {
        int userId=-1;

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        userId = user.getUserId();
        em.clear();
        
        return userId!=-1 ? true:false;
    }

    @Override
    public void updateUser(User oldUser, User newUser, EntityManager em) {
        
    }

    @Override
    public User getUserById(Integer userId, EntityManager em) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public List<User> getAllUsers(List<Integer> ids, EntityManager em) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }
    
}
