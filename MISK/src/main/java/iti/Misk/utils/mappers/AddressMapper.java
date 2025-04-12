package iti.Misk.utils.mappers;

import iti.Misk.model.dtos.Address;
import iti.Misk.model.newentity.Useraddress;
import jakarta.validation.constraints.Null;

public class AddressMapper {

    public static Address toDto(Useraddress entity) {
        if (entity == null) {
            return null;
        }

        Address dto = new Address();
        dto.setAddressId(entity.getAddressId());
        dto.setState(entity.getState());
        dto.setCity(entity.getCity());
        dto.setStreet(entity.getStreet());
        dto.setDepartmentNumber(entity.getDepartmentNumber());
        return dto;
    }

    public static Useraddress toEntity(Address dto) {
        if (dto == null) {
            return null;
        }
    
        Useraddress entity = new Useraddress();
        
        
        if (dto.getAddressId() ==0) {
            entity.setAddressId(dto.getAddressId());
        }
        
       
        entity.setState(dto.getState());
        entity.setCity(dto.getCity());
        entity.setStreet(dto.getStreet());
        entity.setDepartmentNumber(dto.getDepartmentNumber());
        
        return entity;
    }
    
}