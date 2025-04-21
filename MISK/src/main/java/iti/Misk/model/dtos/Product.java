package iti.Misk.model.dtos;

public class Product {

   private int id;
   private String name;
   private String description;
   private String price;
   private Double pricee;
   private int quantity;
   private String photopath;
   private String brand;
   private String size;
   private String gender;
    private int max;

    

    public void setPricee(Double pricee) {
        this.pricee = pricee;
    }

    public Double getPricee() {
        return pricee;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
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

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBrand() {
        return brand;
    }

    public String getPhotopath() {
        return photopath;
    }

    public String getSize() {
        return size;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Product() {
    }

    public Product(int id, String name, String description, String price, String photopath, int quantity, String brand, String size, String gender, int max, double prices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photopath = photopath;
        this.quantity = quantity;
        this.brand = brand;
        this.size = size;
        this.gender = gender;
        this.max=max;
        this.pricee=prices;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price+"]";
    }
}
