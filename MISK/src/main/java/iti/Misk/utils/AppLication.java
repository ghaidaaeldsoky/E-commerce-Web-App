package iti.Misk.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
        System.out.println("hi");
        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();

        Address addressDto = new Address();
        addressDto.setState("Cairo");
        addressDto.setCity("Nasr City");
        addressDto.setStreet("Makram Ebeid");
        addressDto.setDepartmentNumber(305L);

        Address addressDto2 = new Address();
        addressDto2.setState("Alex");
        addressDto2.setCity("Nasr City");
        addressDto2.setStreet("Makram");
        addressDto2.setDepartmentNumber(3052L);

        UserDto userDto = new UserDto();
        userDto.setUserName("Sama");
        userDto.setPhoneNumber("0123456789");
        userDto.setEmail("sama@example.com");
        userDto.setBirthDay("1998-05-10");
        userDto.setJob("Software Engineer");
        userDto.setCreditLimit("5000.00");
        userDto.setIntersets("Reading, Coding");
        userDto.setPassword("securePassword123");

        User user = UserMapper.toEntity(userDto);

        Useraddress address = AddressMapper.toEntity(addressDto);
        Useraddress address2 = AddressMapper.toEntity(addressDto2);

        user.getUseraddresses().add(address);
        user.getUseraddresses().add(address2);
        address.setUser(user);
        address2.setUser(user);

        em.getTransaction().begin();

        em.merge(user);

        em.getTransaction().commit();

        em.getTransaction().begin();

        User userelzeft = em.find(User.class, 1);

        Set<Useraddress> set = userelzeft.getUseraddresses();

        em.getTransaction().commit();

        Address addressDto4 = new Address();
        addressDto4.setState("Cairo");
        addressDto4.setCity("Nasr City");
        addressDto4.setStreet("Makram Ebeid");
        addressDto4.setDepartmentNumber(305L);

        Address addressDto3 = new Address();
        addressDto3.setState("Alex");
        addressDto3.setCity("Nasr City");
        addressDto3.setStreet("Makram");
        addressDto3.setDepartmentNumber(3052L);

        Useraddress address3 = AddressMapper.toEntity(addressDto3);
        Useraddress address4 = AddressMapper.toEntity(addressDto4);

        System.out.println(address3.getState());

        em.getTransaction().begin();


        User user2 = em.find(User.class, 1);

        System.out.println("heeeeeeeeeeeee" + user2.getUserId());

        user2.getUseraddresses().add(address3);

        user2.getUseraddresses().add(address4);

        address3.setUser(user2);

        address4.setUser(user2);

        em.merge(user2);

        em.getTransaction().commit();

        // Iterator<Useraddress> iterator = set.iterator
        // while (iterator.hasNext()) {
        // Useraddress address3 = iterator.next(); 
        // System.out.println(address.getStreet()); =
        // }

        em.getTransaction().begin();

        Useraddress addressToRemove = em.find(Useraddress.class, 1);
    
        if (addressToRemove != null) {
          
            User user0 = addressToRemove.getUser();
    
            if (user0 != null) {
             
                user0.getUseraddresses().remove(addressToRemove);
    
             
                addressToRemove.setUser(null);
    
              
                em.merge(user0); 
            }
    
            em.remove(addressToRemove); 
        } else {
            System.out.println("Address not found.");
        }
    
   
        em.getTransaction().commit();
    }
    
}