package iti.Misk.model.dtos;

import iti.Misk.model.newentity.User;
import lombok.*;


@ToString
public class Address {

    private int addressId;
    private String state;
    private String city;
    private String street;
    private Long departmentNumber;


    public int getAddressId() {
        return addressId;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }


    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public Address(int addressId, String state, String city, String street, Long departmentNumber) {
        this.addressId = addressId;
        this.state = state;
        this.city = city;
        this.street = street;
        this.departmentNumber = departmentNumber;
    }

    public Address() {
    }
}
