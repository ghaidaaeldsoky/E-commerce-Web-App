package iti.Misk.controller.repositories.impls;

import iti.Misk.controller.repositories.interfaces.OrderRepo;
import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Orderitems;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class OrderRepoImpl implements OrderRepo {


    //this one will return the order id which will be used in the setOrderPrice &setOrderItems method
    @Override
    public int addNewOrder(Order order, EntityManager em) {
        int orderId = -1;
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
        orderId = order.getOrderId();
        em.clear();
        return orderId;
    }

    @Override
    public void setOrderPrice(int OrderID, BigDecimal totalAmount, EntityManager em) {
        em.getTransaction().begin();
        Order order = em.find(Order.class, OrderID);
        order.setTotalAmount(totalAmount);
        em.merge(order);
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public void setOrderItemsList(int OrderID, Set<Orderitems> orderitemsSet, EntityManager em) {
        em.getTransaction().begin();
        Order order = em.find(Order.class, OrderID);
        order.setOrderitemses(orderitemsSet);
        em.merge(order);
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public Order getOrder(EntityManager em, int orderId) {
        Order order = em.find(Order.class, orderId);
        order.getOrderitemses();
        em.clear();
        return order;
    }

    //I have the id of the order when inserted which is the return of this addNewOrder
    //so i can use it to update the order
    @Override
    public void updateOrder(Order newOrder, EntityManager em) {
        em.getTransaction().begin();
        em.merge(newOrder);
        em.getTransaction().commit();
        em.clear();
    }


    @Override
    public List<Order> getAllOrders(EntityManager em) {
        Query query = em.createQuery("select o from Order o");
        List<Order> orders = query.getResultList();
        em.clear();
        return orders;
    }

    @Override
    public List<Order> getOrdersByUserID(int userID, EntityManager em) {
        Query query = em.createQuery("select o from Order o where o.user.userId = :ID");
        query.setParameter("ID", userID);
        List<Order> orders = query.getResultList();
        em.clear();
        return orders;
    }

}
