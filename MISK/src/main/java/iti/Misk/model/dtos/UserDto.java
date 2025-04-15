package iti.Misk.model.dtos;

import java.util.List;
import java.util.Set;
import java.util.List;

public class UserDto {

    private Integer userId ;
    private String userName;
    private String phoneNumber;
    private String email;
    private String birthDay;
    private String job;
   
    private String creditLimit;
    private String intersets;
    private String password ;
    private boolean isAdmin;

    private Set<Address> addresses;





    public UserDto() {


    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

  

    //temp
    public UserDto(String userName, String phoneNumber, String email, String birthDay, String job, String creditLimit, String intersets) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDay = birthDay;
        this.job = job;
        this.creditLimit = creditLimit;
        this.intersets = intersets;
    }

    public UserDto(String userName, String phoneNumber, String email, String birthDay, String job, String creditLimit, String intersets,String password) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDay = birthDay;
        this.job = job;
        this.creditLimit = creditLimit;
        this.intersets = intersets;
        this.password = password;
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getIntersets() {
        return intersets;
    }

    public void setIntersets(String intersets) {
        this.intersets = intersets;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
    
    @Override
public String toString() {
    return "UserDto{" +
            "userName='" + userName + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", email='" + email + '\'' +
            ", birthDay='" + birthDay + '\'' +
            ", job='" + job + '\'' +
            ", creditLimit='" + creditLimit + '\'' +
            ", interests='" + intersets + '\'' +
            ", password='" + password + '\'' +
            '}';
}


}
