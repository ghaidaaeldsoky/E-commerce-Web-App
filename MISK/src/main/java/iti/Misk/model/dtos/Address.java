package iti.Misk.model.dtos;

public class Address {

    private int id;
   private String Country;
   private String city;
   private String str;
   private int b;


    public Address(int id, String country, String city, String str, int b) {
        this.id = id;
        Country = country;
        this.city = city;
        this.str = str;
        this.b = b;
    }

    public Address() {
    }


    public int getId() {
        return id;
    }

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return city;
    }

    public String getStr() {
        return str;
    }

    public int getB() {
        return b;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setB(int b) {
        this.b = b;
    }
}
