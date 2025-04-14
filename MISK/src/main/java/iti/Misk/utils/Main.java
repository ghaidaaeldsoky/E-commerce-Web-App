package iti.Misk.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import iti.Misk.controller.repositories.impls.OrderItemsRepoImpl;
import iti.Misk.controller.repositories.impls.OrderRepoImpl;
import iti.Misk.controller.repositories.impls.ProductRepoImpl;
import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.newentity.*;
import iti.Misk.utils.mappers.AddressMapper;
import iti.Misk.utils.mappers.ProductMapper;
import jakarta.persistence.EntityManager;
import iti.Misk.controller.repositories.impls.ShoppingCartRepoImpl;
import iti.Misk.model.dtos.Product;
import iti.Misk.model.dtos.ShoppingCartDto;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.utils.EntityManagerFactorySingleton;
import iti.Misk.utils.mappers.ShoppingCartMapper;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
//        User user = new User();
//        user.setName("Ghaidaa");
//        user.setPhoneNumber("01000000000");
//        user.setEmail("ghaidaa@example.com");
//        user.setPassword("securepassword");
//        user.setJob("Software Developer");
//        user.setCreditLimit(new BigDecimal("3000.00"));
//        user.setInterests("Tech, Music, Travel");
//        user.setIsAdmin(true);
//
//
//
//        // Useraddress useraddress = new Useraddress();
//        // useraddress.setUser(user);
//        // useraddress.setCity("Cairo");
//        // useraddress.setStreet("Al-Masry Street");
//        // useraddress.setState("123");
//        // useraddress.setDepartmentNumber(100l);
//
//
//        Product product1 = new Product(1, "Running Shoes", new BigDecimal("89.99"), 50, "Nike", "42", "Unisex");
//        Product product2 = new Product(2, "Denim Jacket", new BigDecimal("119.50"), 20, "Levi's", "M", "Male");
//        Product product3 = new Product(3, "Summer Dress", new BigDecimal("75.25"), 30, "Zara", "S", "Female");
//
//        Product product = new Product();
//        product.setName("Oud Musk");
//        product.setDescription("A luxurious oriental scent.");
//        product.setPrice(new BigDecimal("350.00"));
//        product.setQuantity(10);
//        product.setPhoto("./img/product/dior_sauvage.jpg");
//        product.setBrand("MISK");
//        product.setSize("100ml");
//        product.setGender("Male");
//
//        // System.out.println(new ProductRepoImpl().addNewProduct(product, em));
//        // product = new ProductRepoImpl().getProductById(4, em);
//        // product.setBrand("Updated");
//        // System.out.println(new ProductRepoImpl().updateProduct(product, em));
//        // System.out.println(new ProductRepoImpl().deleteProduct(product, em));
//        // List<Product> filterd = new ProductRepoImpl().filterProducts(em, 0, 2, null, "Male", null, null);
//        // for(Product p: filterd) {
//        //     System.out.println(p.getProductId()+ " Name: "+ p.getName());
//        // }
//
//        User user1 = em.find(User.class, 1);
//        Product product_1 = em.find(Product.class, 1);
//        Product product_2 = em.find(Product.class, 2);
//
//        // Add item to card:
//        System.out.println(new ShoppingCartRepoImpl().addCartItem(user1, product_2, 2, em));
//        System.out.println(new ShoppingCartRepoImpl().addCartItem(user1, product_1, 2, em));
//
//        // Update Item Quantity
//        // System.out.println(new ShoppingCartRepoImpl().updateCartItem(user1,product_1,60,em));
//
//        // getUserCart
//        // for(Shoppingcart cart:new ShoppingCartRepoImpl().getUserShoppingCart(1,em)) {
//        //     System.out.println(cart.getId().getProductId()+ " Q= "+cart.getQuantity());
//        // }
//
//        // remove item
//        // System.out.println(new ShoppingCartRepoImpl().removeCartItem(user1, product_2, em));
//
//        System.out.println(new ShoppingCartRepoImpl().clearUserShoppingCart(1, em));
//
//
//        product = new ProductRepoImpl().getProductById(1, em);
//        PerfumeDto perfumeDto = ProductMapper.toDto(product);
//        System.out.println(perfumeDto.getId()+ " " + perfumeDto.getBrand()+ " " + perfumeDto.getName());
//
//
//        // List<Shoppingcart>  l = Arrays.asList(
//        //         new Shoppingcart(new ShoppingcartId(product1.getProductId(),user.getUserId()),user,product1,5),
//        //         new Shoppingcart(new ShoppingcartId(product2.getProductId(),user.getUserId()),user,product2,6),
//        //         new Shoppingcart(new ShoppingcartId(product3.getProductId(),user.getUserId()),user,product3,7)
//
//        // );
//
//
//        // Order order = new Order();
//        // order.setOrderDate(Timestamp.valueOf("2025-04-10 22:36:31"));
//        // order.setUser(user);
//        // order.setUseraddress(useraddress);
//        // int order_id= new OrderRepoImpl().addNewOrder(order,em);
//        // Order x=null;
//        // if(order_id!=-1){
//        //     x= new OrderRepoImpl().getOrder(em, order_id);
//        // }
//
//        // new OrderItemsRepoImpl().addListOrderItem(x, l, em);
//        // Set<Orderitems> s=new OrderItemsRepoImpl().getOrderItemsByOrderId(order.getOrderId(), em);
//        // new OrderRepoImpl().setOrderPrice(order_id, new BigDecimal("1000.00"), em);
//        // new OrderRepoImpl().setOrderItemsList(order_id, s, em);

//        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
//        List<Shoppingcart> shoppingCartList = new ShoppingCartRepoImpl().getUserShoppingCart(1, em);
//        List<ShoppingCartDto> l = shoppingCartList.stream().map(ShoppingCartMapper::toDto).collect(Collectors.toList());
//        Iterator<ShoppingCartDto> iterator = l.iterator();
//        while (iterator.hasNext()) {
//            ShoppingCartDto shoppingCartDto = iterator.next();
//
//            if (shoppingCartDto.getStorage() <= 0) {
//                iterator.remove();
//            } else {
//                if (shoppingCartDto.getQuantity() >= shoppingCartDto.getStorage()) {
//                    shoppingCartDto.setQuantity(shoppingCartDto.getStorage());
//                }
//            }
//        }
//
//
//        for (ShoppingCartDto dto : l) {
//            System.out.println(dto);
//        }
//    }}

//        EntityManager em = EntityManagerFactorySingleton.getEntityManagerFactory().createEntityManager();
//        Set<Useraddress> userAddress = new UserRepoImpl().getUseraddress(1, em);
//        List<Address> addresses = new ArrayList<>();
//        if (userAddress != null) {
//            for (Useraddress useraddress : userAddress) {
//                addresses.add(AddressMapper.toDto(useraddress));
//            }
//        }
//        for (Address address : addresses) {
//            System.out.println(address);
//        }


//        PerfumeDto perfumeDetails = PerfumeServicesImpl.getPerfumeServices().findPerfume(4);
//        System.out.println(perfumeDetails.getQuantity());


    }
}