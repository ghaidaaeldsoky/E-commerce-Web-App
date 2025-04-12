package iti.Misk.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import iti.Misk.controller.repositories.impls.OrderItemsRepoImpl;
import iti.Misk.controller.repositories.impls.OrderRepoImpl;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.model.newentity.*;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {

        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
        User user = new User();
        user.setName("Ghaidaa");
        user.setPhoneNumber("01000000000");
        user.setEmail("ghaidaa@example.com");
        user.setPassword("securepassword");
        user.setJob("Software Developer");
        user.setCreditLimit(new BigDecimal("3000.00"));
        user.setInterests("Tech, Music, Travel");
        user.setIsAdmin(true);

        Useraddress useraddress = new Useraddress();
        useraddress.setUser(user);
        useraddress.setCity("Cairo");
        useraddress.setStreet("Al-Masry Street");
        useraddress.setState("123");
        useraddress.setDepartmentNumber(100l);


        Product product1 = new Product(1, "Running Shoes", new BigDecimal("89.99"), 50, "Nike", "42", "Unisex");
        Product product2 = new Product(2, "Denim Jacket", new BigDecimal("119.50"), 20, "Levi's", "M", "Male");
        Product product3 = new Product(3, "Summer Dress", new BigDecimal("75.25"), 30, "Zara", "S", "Female");


        em.getTransaction().begin();
        em.persist(user);
        em.persist(useraddress);
        em.merge(product1);
        em.merge(product2);
        em.merge(product3);
        em.getTransaction().commit();






        List<Shoppingcart>  l = Arrays.asList(
                new Shoppingcart(new ShoppingcartId(product1.getProductId(),user.getUserId()),user,product1,5),
                new Shoppingcart(new ShoppingcartId(product2.getProductId(),user.getUserId()),user,product2,6),
                new Shoppingcart(new ShoppingcartId(product3.getProductId(),user.getUserId()),user,product3,7)

        );


        Order order = new Order();
        order.setOrderDate(Timestamp.valueOf("2025-04-10 22:36:31"));
        order.setUser(user);
        order.setUseraddress(useraddress);
        int order_id= new OrderRepoImpl().addNewOrder(order,em);
        Order x=null;
        if(order_id!=-1){
            x= new OrderRepoImpl().getOrder(em, order_id);
        }

        new OrderItemsRepoImpl().addListOrderItem(x, l, em);
        Set<Orderitems> s=new OrderItemsRepoImpl().getOrderItemsByOrderId(order.getOrderId(), em);
        new OrderRepoImpl().setOrderPrice(order_id, new BigDecimal("1000.00"), em);
        new OrderRepoImpl().setOrderItemsList(order_id, s, em);





    }
}
