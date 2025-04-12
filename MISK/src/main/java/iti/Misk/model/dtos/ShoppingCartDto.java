package iti.Misk.model.dtos;

import java.sql.Timestamp;

public class ShoppingCartDto {
    private int userId;
    private int productId;
    private int quantity;
    private Timestamp addedAt;

    // Optional product info (useful in frontend)
    private String productName;
    private String productPhoto;
    private double productPrice;

    public ShoppingCartDto() {}

    public ShoppingCartDto(int userId, int productId, int quantity, Timestamp addedAt) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.addedAt = addedAt;
    }    

    public ShoppingCartDto(int userId, int productId, int quantity, Timestamp addedAt,
                           String productName, String productPhoto, double productPrice) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.addedAt = addedAt;
        this.productName = productName;
        this.productPhoto = productPhoto;
        this.productPrice = productPrice;
    }

    // Getters and Setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Timestamp getAddedAt() { return addedAt; }
    public void setAddedAt(Timestamp addedAt) { this.addedAt = addedAt; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductPhoto() { return productPhoto; }
    public void setProductPhoto(String productPhoto) { this.productPhoto = productPhoto; }

    public double getProductPrice() { return productPrice; }
    public void setProductPrice(double productPrice) { this.productPrice = productPrice; }
}
