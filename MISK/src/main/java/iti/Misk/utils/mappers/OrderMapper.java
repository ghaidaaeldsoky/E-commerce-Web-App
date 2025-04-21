package iti.Misk.utils.mappers;

import java.util.stream.Collector;
import java.util.stream.Collectors;

import iti.Misk.model.dtos.OrderDto;
import iti.Misk.model.newentity.Order;

public class OrderMapper {


    // Method to map Order to OrderDto
    public static OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
         orderDto.setUser(order.getUser().getName());
         orderDto.setTotalAmount(order.getTotalAmount().intValue());
         orderDto.setAddress(order.getUseraddress().toString());
         orderDto.setOrderDate(order.getOrderDate().toString());
     orderDto.setProducts(order.getOrderitemses().stream()
                .map(item -> item.getProduct().getName())
               .collect(Collectors.toList())
               );
        return orderDto;
    }
}
