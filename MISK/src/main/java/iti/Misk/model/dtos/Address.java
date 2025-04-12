package iti.Misk.model.dtos;

import iti.Misk.model.newentity.User;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    private int addressId;
    private String state;
    private String city;
    private String street;
    private Long departmentNumber;

}
