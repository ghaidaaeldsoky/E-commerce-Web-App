package iti.Misk.controller.repositories.impls;

import iti.Misk.controller.repositories.interfaces.OrderItemsRepo;
import iti.Misk.model.newentity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderItemsRepoImpl implements OrderItemsRepo {


    @Override
    public void addNewOrderItem(Order order, Product product,int quantity, EntityManager em) {
        OrderitemsId orderitemsId = new OrderitemsId(order.getOrderId(), product.getProductId());
        Orderitems orderitems = new Orderitems();
        orderitems.setId(orderitemsId);
        orderitems.setOrder(order);
        orderitems.setProduct(product);
        orderitems.setQuantity(quantity);
        em.merge(orderitems);
    }

    @Override
    public void addListOrderItem(Order order, List<Shoppingcart> cartList, EntityManager em) {
        em.getTransaction().begin();
        for(Shoppingcart item : cartList){
            addNewOrderItem(order, item.getProduct(), item.getQuantity(), em);
        }
        em.getTransaction().commit();
        em.clear();
    }

    @Override
    public Set<Orderitems> getOrderItemsByOrderId(int orderId, EntityManager em) {
        Query query = em.createQuery("SELECT oi FROM Orderitems oi WHERE oi.id.orderId = :orderId");
        query.setParameter("orderId", orderId);
        List<Orderitems> orderItemsList = query.getResultList();

        return new HashSet<>(orderItemsList);
    }



}
