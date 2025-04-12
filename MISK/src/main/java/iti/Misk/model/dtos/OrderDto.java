package iti.Misk.model.dtos;

import java.util.List;

public class OrderDto {
<<<<<<< HEAD

    private String user;
    private int totalAmount;
=======
    private String user;
    private String totalAmount;
>>>>>>> 4e8c42ef76a8d8949b9c241dd7e6bb93a159bab2
    private String address;
    private String orderDate;
    private List<String> products;

<<<<<<< HEAD
    // Default constructor
    public OrderDto() {
    }

    // Parameterized constructor
    public OrderDto(String user, int totalAmount, String address, String orderDate, List<String> products) {
=======
    public OrderDto(String user, String totalAmount, String address, String orderDate, List<String> products) {
>>>>>>> 4e8c42ef76a8d8949b9c241dd7e6bb93a159bab2
        this.user = user;
        this.totalAmount = totalAmount;
        this.address = address;
        this.orderDate = orderDate;
        this.products = products;
    }

<<<<<<< HEAD
    // Getters and Setters

=======
>>>>>>> 4e8c42ef76a8d8949b9c241dd7e6bb93a159bab2
    public String getUser() {
        return user;
    }

<<<<<<< HEAD
    public void setUser(String user) {
        this.user = user;
    }

    public int getTotalAmount() {
=======
    public String getTotalAmount() {
>>>>>>> 4e8c42ef76a8d8949b9c241dd7e6bb93a159bab2
        return totalAmount;
    }

    public String getAddress() {
        return address;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<String> getProducts() {
        return products;
    }
}
