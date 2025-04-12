package iti.Misk.controller.repositories.interfaces;

import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Orderitems;
import iti.Misk.model.newentity.Product;
import iti.Misk.model.newentity.Shoppingcart;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Set;

public interface OrderItemsRepo {

    public void addNewOrderItem(Order order, Product product, int quantity, EntityManager em);
    public void addListOrderItem(Order order, List<Shoppingcart> cartList, EntityManager em);
    public Set<Orderitems> getOrderItemsByOrderId(int orderId, EntityManager em);

}
