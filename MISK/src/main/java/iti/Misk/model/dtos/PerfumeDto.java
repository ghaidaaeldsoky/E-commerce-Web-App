package iti.Misk.model.dtos;

import iti.Misk.model.enums.Gender;

public class PerfumeDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private String photo;
    private String brand;
    private String size;
    private Gender gender; // "Men", "Women", "Unisex"

    public PerfumeDto(int id, String name, String description, double price, int quantity, String photo, String brand,
            String size, Gender gender) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.photo = photo;
        this.brand = brand;
        this.size = size;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoto() {
        return photo;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSize() {
        return size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
