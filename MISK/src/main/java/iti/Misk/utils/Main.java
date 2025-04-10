package iti.Misk.utils;

import java.math.BigDecimal;

import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.model.newentity.User;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("hhi");
        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        User user = new User();
        user.setName("Ghaidaa");
        user.setPhoneNumber("01000000000");
        user.setEmail("ghaidaa@example.com");
        user.setPassword("securepassword");
        // user.setBirthday(Date.valueOf("1995-01-01"));
        user.setJob("Software Developer");
        user.setCreditLimit(new BigDecimal("3000.00"));
        user.setInterests("Tech, Music, Travel");
        user.setIsAdmin(true);

        System.out.println(new UserRepoImpl().addNewUser(user, em));

    }
}
