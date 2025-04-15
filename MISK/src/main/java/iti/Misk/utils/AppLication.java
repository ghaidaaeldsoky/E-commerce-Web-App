package iti.Misk.utils;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.User;
import iti.Misk.model.newentity.Useraddress;
import iti.Misk.utils.mappers.AddressMapper;
import iti.Misk.utils.mappers.UserMapper;
import jakarta.persistence.EntityManager;
import iti.Misk.utils.EntityManagerFactorySingleton;

public class AppLication {
    public static void main(String[] args) {

//      User user1 = new User();
// user1.setName("Sama");
// user1.setPhoneNumber("01012345678");
// user1.setEmail("sama@example.com");
// user1.setPassword("password123");
// user1.setBirthday(java.sql.Date.valueOf("2000-05-20"));
// user1.setJob("Developer");
// user1.setCreditLimit(new BigDecimal("10000.00"));
// user1.setInterests("Programming, Reading");
// user1.setIsAdmin(false);

// User user2 = new User();
// user2.setName("Ahmed");
// user2.setPhoneNumber("01198765432");
// user2.setEmail("ahmed@example.com");
// user2.setPassword("securePass");
// user2.setBirthday(java.sql.Date.valueOf("1998-03-15"));
// user2.setJob("Designer");
// user2.setCreditLimit(new BigDecimal("7500.50"));
// user2.setInterests("Design, Music");
// user2.setIsAdmin(true);

// Useraddress address1 = new Useraddress();
// address1.setState("Cairo");
// address1.setCity("Nasr City");
// address1.setStreet("Al Tayaran Street");
// address1.setDepartmentNumber(12L);

// Useraddress address2 = new Useraddress();
// address2.setState("Giza");
// address2.setCity("Dokki");
// address2.setStreet("Tahrir Street");
// address2.setDepartmentNumber(5L);


// EntityManager entityManager=  EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

 
//         UserRepoImpl repoImpl = new UserRepoImpl();

//         repoImpl.addNewUser(user2, address2, entityManager);

//         repoImpl.addNewUser(user1, address1, entityManager);

//       System.out.println(repoImpl.checkPasswordValidation("sama@example.com","test122224" ,entityManager));  

//       System.out.println(repoImpl.getUserCreditCardLimit(1, entityManager));
    }
    
}