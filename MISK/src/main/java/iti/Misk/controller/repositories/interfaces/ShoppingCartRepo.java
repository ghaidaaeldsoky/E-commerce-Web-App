package iti.Misk.controller.repositories.interfaces;

import java.util.List;

import iti.Misk.model.newentity.Product;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.User;
import jakarta.persistence.EntityManager;

public interface ShoppingCartRepo {

    // Each Item Process:
    public int addCartItem(User user,Product product, int quantity, EntityManager em);
    public boolean updateCartItem(User user,Product product, int quantity, EntityManager em);

    public boolean removeCartItem(User user,Product product, EntityManager em);
    public Shoppingcart getCartItem(User user,Product product, EntityManager em);
    

    // Each user process:
    public List<Shoppingcart> getUserShoppingCart(int userId,EntityManager em);
    public boolean clearUserShoppingCart(int userId, EntityManager em);


    // public int addOrUpdateItem(Shoppingcart shoppingCartItem, EntityManager em);

    // public boolean removeItem(Shoppingcart shoppingCartItem, EntityManager em);

    // public List<Shoppingcart> getAllCartItemsForUser(int userId, EntityManager em);

    // public boolean clearCartForUser(int userId, EntityManager em);
}
