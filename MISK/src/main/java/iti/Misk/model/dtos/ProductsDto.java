package iti.Misk.model.dtos;

public class ProductsDto {

    private int productId;
    private String photo;
    private String name;
    private String description;
    private int price;
    private int quantity;
    private String brand;
    private int size;
    private String gender;

   
    public ProductsDto() {
    }

  
    public ProductsDto(int productId, String photo, String name,String description, int price, int quantity, String brand, int size, String gender) {
        this.productId = productId;
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.size = size;
        this.gender = gender;
    }

    
    public ProductsDto( String photo, String name,String description, int price, int quantity, String brand, int size, String gender) {
        
        this.photo = photo;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.size = size;
        this.gender = gender;
    }


    public String getDescription()
    {
        return description;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
public String toString() {
    return "Product{" +
           
            ", photo='" + photo + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            ", quantity=" + quantity +
            ", brand='" + brand + '\'' +
            ", size=" + size +
            ", gender='" + gender + '\'' +
            '}';
}
}
