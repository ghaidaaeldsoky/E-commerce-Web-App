package iti.Misk.controller.repositories.impls;

import java.util.List;

import iti.Misk.controller.repositories.interfaces.ShoppingCartRepo;
import iti.Misk.model.newentity.Product;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.ShoppingcartId;
import iti.Misk.model.newentity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class ShoppingCartRepoImpl implements ShoppingCartRepo {

    @Override
    public int addCartItem(User user, Product product, int quantity, EntityManager em) {
        Shoppingcart item = getCartItem(user, product, em);
        if (item != null) { // already exist
            if (item.getQuantity() + quantity <= product.getQuantity()) { // less than boundry
                item.setQuantity(item.getQuantity() + quantity);
            } else { // more than boundry
                item.setQuantity(product.getQuantity());
            }
        } else {
            ShoppingcartId id = new ShoppingcartId(product.getProductId(), user.getUserId());
            item = new Shoppingcart(id, user, product, quantity);
        }
        try {
            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();
            return 1; // Success
        } catch (Exception e) {
            System.out.println("Error in adding shopping cart item: " + e.getMessage());
            return -1; // Failure
        }
    }

    @Override
    public boolean updateCartItem(User user, Product product, int quantity, EntityManager em) {
        if (quantity <= 0) {
            removeCartItem(user, product, em);
            return true;
        }
        Shoppingcart item = getCartItem(user, product, em);
        if (item.getProduct().getQuantity() < quantity || item == null) {
            System.out.println("Quanity of product less than it or it not found ");
            return false;
        }
        item.setQuantity(quantity);
        try {
            em.getTransaction().begin();
            em.merge(item);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error in updating shopping cart item: " + e.getMessage());
            return false;
        }

    }

    @Override
    public boolean removeCartItem(User user, Product product, EntityManager em) {
        Shoppingcart item = getCartItem(user, product, em);

        try {
            em.getTransaction().begin();
            em.remove(item);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error in removing shopping cart item: " + e.getMessage());
            return false;
        }

    }

    @Override
    public Shoppingcart getCartItem(User user, Product product, EntityManager em) {
        return em.find(Shoppingcart.class, new ShoppingcartId(product.getProductId(), user.getUserId()));
    }

    @Override
    public List<Shoppingcart> getUserShoppingCart(int userId, EntityManager em) {
        try {
            TypedQuery<Shoppingcart> query = em.createQuery(
                    "SELECT sc FROM Shoppingcart sc WHERE sc.user.id = :userId", Shoppingcart.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error in returning shopping cart for user: " + e.getMessage());
            return null;
        }

    }

    @Override
    public boolean clearUserShoppingCart(int userId, EntityManager em) {
        try{
            List<Shoppingcart> cartItems = getUserShoppingCart(userId, em);
            if( cartItems != null && !cartItems.isEmpty()){
                em.getTransaction().begin();
                for (Shoppingcart item : cartItems) {
                    em.remove(item);
                }
                em.getTransaction().commit();
            }
            return true;
        }catch(Exception e) {
            System.out.println("Error in clearing shopping cart for user: " + e.getMessage());
            return false;
        }
    }

    // @Override
    // public int addOrUpdateItem(Shoppingcart shoppingCartItem, EntityManager em) {
    // try {
    // em.getTransaction().begin();

    // // Check if item already exists in the cart
    // Shoppingcart existingItem = em.find(Shoppingcart.class,
    // shoppingCartItem.getId());

    // if (existingItem != null) {
    // // Update the quantity if item already exists
    // existingItem.setQuantity(existingItem.getQuantity() +
    // shoppingCartItem.getQuantity());
    // em.merge(existingItem); // Merge to update the item
    // } else {
    // // If item doesn't exist -> persist the new item
    // em.persist(shoppingCartItem);
    // }

    // em.getTransaction().commit();
    // return 1; // Success
    // } catch (Exception e) {
    // System.out.println("Error adding/updating shopping cart item: " +
    // e.getMessage());
    // return -1; // Failure
    // }
    // }

    // @Override
    // public boolean removeItem(Shoppingcart shoppingCartItem, EntityManager em) {
    // try {
    // em.getTransaction().begin();
    // em.remove(shoppingCartItem); // Remove item from cart
    // em.getTransaction().commit();
    // return true; // Success
    // } catch (Exception e) {
    // System.out.println("Error removing shopping cart item: " + e.getMessage());
    // return false; // Failure
    // }
    // }

    // @Override
    // public List<Shoppingcart> getAllCartItemsForUser(int userId, EntityManager
    // em) {
    // try {
    // return em.createQuery("FROM Shoppingcart WHERE user_id = :userId",
    // Shoppingcart.class)
    // .setParameter("userId", userId)
    // .getResultList();
    // } catch (Exception e) {
    // System.out.println("Error fetching shopping cart items: " + e.getMessage());
    // return null; // Failure
    // }
    // }

    // @Override
    // public boolean clearCartForUser(int userId, EntityManager em) {
    // try {
    // em.getTransaction().begin();
    // List<Shoppingcart> cartItems = this.getAllCartItemsForUser(userId, em);
    // for (Shoppingcart item : cartItems) {
    // em.remove(item); // Remove each item in the cart
    // }
    // em.getTransaction().commit();
    // return true; // Success
    // } catch (Exception e) {
    // System.out.println("Error clearing shopping cart: " + e.getMessage());
    // return false; // Failure
    // }
    // }

}
