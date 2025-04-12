package iti.Misk.controller.repositories.interfaces;

import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Orderitems;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface OrderRepo {
    public int addNewOrder(Order order, EntityManager em);

    public void setOrderPrice(int OrderID, BigDecimal totalAmount, EntityManager em);
    public void setOrderItemsList(int OrderID, Set<Orderitems> orderitemsList, EntityManager em);

    public List<Order> getAllOrders(EntityManager em);

    public List<Order> getOrdersByUserID(int userID, EntityManager em);

    public Order getOrder(EntityManager em, int orderId);


    public void updateOrder(Order newOrder, EntityManager em);
}