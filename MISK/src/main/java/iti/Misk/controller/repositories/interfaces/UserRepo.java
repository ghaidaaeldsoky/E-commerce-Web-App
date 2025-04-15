package iti.Misk.controller.repositories.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import iti.Misk.model.dtos.Address;
import iti.Misk.model.newentity.*;
import jakarta.persistence.EntityManager;

public interface UserRepo {

    public Boolean addNewUser(User user, Useraddress address, EntityManager em);

    public void updateUser(int id, User newUser, EntityManager em);

    public User findUserById(Integer userId, EntityManager em);

    public User findUserByEmail(String emai, EntityManager em);

    public Boolean checkEmailAvailability(String email, EntityManager em);

    public Boolean checkPasswordValidation(String email, String password, EntityManager em);

    public List<User> getAllUsers( EntityManager em);

    public int getUserIdByEmail(String email, EntityManager em);

    public BigDecimal getUserCreditCardLimit(int id, EntityManager em);

    public Set<Order> getAllUserOrders(int id, EntityManager em);

    public Set<Shoppingcart> getUserShoppinCard(int id, EntityManager em);

    public Set<Useraddress> getUseraddress(int id, EntityManager em);

    public boolean addListOfAddresses(int id, List<Useraddress> address, EntityManager em);

    void updateCreditLimit(int userId, BigDecimal newLimit, EntityManager em);

    void updateCreditLimit2(int userId, BigDecimal newLimit, EntityManager em);
}
