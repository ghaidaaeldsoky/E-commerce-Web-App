package iti.Misk.utils.mappers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.User;

public class UserMapper {


    public static  User toEntity(UserDto userDto)
    {
        User userEntity ;
        /*  
    


    private String password ;
        
        */

            // userEntity = findUserByEmail(userDto.getEmail());

            userEntity = new User();

            if(userEntity ==null)
        throw new NullPointerException("can not found this user");

        if(userDto.getUserName() != null)
            userEntity.setName(userDto.getUserName());
            
        if(userDto.getPhoneNumber() != null)
        userEntity.setPhoneNumber(userDto.getPhoneNumber());

        
        if(userDto.getEmail() != null)
            userEntity.setEmail(userDto.getEmail());

            
        if(userDto.getBirthDay() != null)
        userEntity.setBirthday(Date.valueOf(userDto.getBirthDay()));

               
        if(userDto.getJob() != null)
        userEntity.setJob(userDto.getJob());

                 
        if(userDto.getCreditLimit() != null)
        userEntity.setCreditLimit(new BigDecimal(userDto.getCreditLimit() ));

        if(userDto.getIntersets() != null)
        {
            userEntity.setInterests(userDto.getIntersets());
        }

        if(userDto.getPassword()!= null)
        userEntity.setPassword(userDto.getPassword());


        //still we dont have address
            return userEntity;

    }

    
        public static UserDto toDto(User userEntity) {
            UserDto userDto = new UserDto();
        
            if (userEntity == null)
                throw new NullPointerException("User entity is null");
        
            if (userEntity.getName() != null)
                userDto.setUserName(userEntity.getName());
        
            if (userEntity.getPhoneNumber() != null)
                userDto.setPhoneNumber(userEntity.getPhoneNumber());
        
            if (userEntity.getEmail() != null)
                userDto.setEmail(userEntity.getEmail());
        
            if (userEntity.getBirthday() != null)
                userDto.setBirthDay(userEntity.getBirthday().toString()); // Converts java.sql.Date to String
        
            if (userEntity.getJob() != null)
                userDto.setJob(userEntity.getJob());
        
            if (userEntity.getCreditLimit() != null)
                userDto.setCreditLimit(userEntity.getCreditLimit().toString()); // Converts BigDecimal to String
        
            if (userEntity.getInterests() != null)
                userDto.setIntersets(userEntity.getInterests());
  
        
            return userDto;
        }
            
    

    
}
