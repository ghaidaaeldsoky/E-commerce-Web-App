package iti.Misk.controller.repositories.impls;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.User;
import iti.Misk.model.newentity.Useraddress;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import iti.Misk.utils.*;

public class UserRepoImpl implements UserRepo {

    @Override
    public Boolean addNewUser(User user, Useraddress address, EntityManager em) {
        int userId = -1;

        user.getUseraddresses().add(address);

        address.setUser(user);

        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();

        return true;
    }

    @Override
    public void updateUser(int id, User newUser, EntityManager em) {

        em.getTransaction().begin();

        User existUser = em.find(User.class, id);

        if (newUser.getEmail() != null) {
            existUser.setEmail(newUser.getEmail());
        }

        if (newUser.getName() != null) {
            existUser.setName(newUser.getName());
        }

        if (newUser.getPhoneNumber() != null) {
            existUser.setPhoneNumber(newUser.getPhoneNumber());
        }

        if (newUser.getPassword() != null) {
            existUser.setPassword(newUser.getPassword());
        }

        if (newUser.getBirthday() != null) {
            existUser.setBirthday(newUser.getBirthday());
        }

        if (newUser.getJob() != null) {
            existUser.setJob(newUser.getJob());
        }

        if (newUser.getCreditLimit() != null) {
            existUser.setCreditLimit(newUser.getCreditLimit());
        }

        if (newUser.getInterests() != null) {
            existUser.setInterests(newUser.getInterests());
        }

        if (newUser.isIsAdmin() != existUser.isIsAdmin()) {
            existUser.setIsAdmin(newUser.isIsAdmin());
        }

        if (newUser.getOrders() != null && !newUser.getOrders().isEmpty()) {
            existUser.setOrders(newUser.getOrders());
        }

        em.merge(existUser);

        em.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers(EntityManager em) {

        CriteriaBuilder cb = EntityManagerFactorySingleton.getEntityManagerFactory().getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);

        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public User findUserById(Integer userId, EntityManager em) {

        em.getTransaction().begin();

        User user = em.find(User.class, userId);

        em.getTransaction().commit();

        return user;
    }

    @Override
    public User findUserByEmail(String email, EntityManager em) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);

        Predicate emailPredicate = cb.equal(userRoot.get("email"), email);
        criteriaQuery.where(emailPredicate);

        return em.createQuery(criteriaQuery).getSingleResult();

    }

    @Override
    public Boolean checkEmailAvailability(String email, EntityManager em) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);

        Predicate emailPredicate = cb.equal(userRoot.get("email"), email);
        criteriaQuery.where(emailPredicate);

        List<User> users = em.createQuery(criteriaQuery).getResultList();
        return !users.isEmpty();

    }

    @Override
    public Boolean checkPasswordValidation(String email, String password, EntityManager em) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);

        Predicate emailPredicate = cb.equal(userRoot.get("email"), email);
        criteriaQuery.where(emailPredicate);

        User user = em.createQuery(criteriaQuery).getSingleResult();

        return user.getPassword() == password;

    }

    @Override
    public int getUserIdByEmail(String email, EntityManager em) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);

        Root<User> userRoot = criteriaQuery.from(User.class);

        Predicate emailPredicate = cb.equal(userRoot.get("email"), email);
        criteriaQuery.where(emailPredicate);

        User user = em.createQuery(criteriaQuery).getSingleResult();

        return user.getUserId();

    }

    @Override
    public BigDecimal getUserCreditCardLimit(int id, EntityManager em) {

        BigDecimal CreditLimit = findUserById(id, em).getCreditLimit();

        return CreditLimit;

    }

    @Override
    public Set<Order> getAllUserOrders(int id, EntityManager em) {

        Set<Order> orders = findUserById(id, em).getOrders();

        return orders;

    }

    @Override
    public Set<Shoppingcart> getUserShoppinCard(int id, EntityManager em) {

        Set<Shoppingcart> shoppingcarts = findUserById(id, em).getShoppingcarts();

        return shoppingcarts;

    }

    @Override
    public Set<Useraddress> getUseraddress(int id, EntityManager em) {

        Set<Useraddress> useraddress = findUserById(id, em).getUseraddresses();

        return useraddress;

    }

    @Override
    public boolean addListOfAddresses(int id, List<Useraddress> addresses, EntityManager em) {

        em.getTransaction().begin();

        User user = em.find(User.class, id);

        // System.out.println("heeeeeeeeeeeee" + user2.getUserId());

        for (Useraddress address : addresses) {
            user.getUseraddresses().add(address);

            address.setUser(user);
        }

        em.merge(user);

        em.getTransaction().commit();

        return true;
    }

    @Override
    public void updateCreditLimit(int userId, BigDecimal newLimit, EntityManager em) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createQuery("UPDATE User u SET u.creditLimit = :lim WHERE u.id = :id")
                .setParameter("lim", newLimit)
                .setParameter("id", userId)
                .executeUpdate();
        tx.commit();
    }

}
