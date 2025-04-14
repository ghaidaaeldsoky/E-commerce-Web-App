package iti.Misk.model.dtos;

import java.util.List;

public class OrderDto {

    private String user;
    private String totalAmount;

    private String address;
    private String orderDate;
    private List<String> products;

    // Default constructor
    public OrderDto() {
    }

    // Parameterized constructor
 
    public OrderDto(String user, String totalAmount, String address, String orderDate, List<String> products) {

        this.user = user;
        this.totalAmount = totalAmount;
        this.address = address;
        this.orderDate = orderDate;
        this.products = products;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getTotalAmount() {

  
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}