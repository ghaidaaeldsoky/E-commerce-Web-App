package iti.Misk.controller.services.impls;

import iti.Misk.controller.repositories.impls.UserRepoImpl;
import iti.Misk.model.dtos.UserDto;
import jakarta.persistence.EntityManager;

public class ProfileServiceImpl {
    
    UserRepoImpl userRepoImpl = new UserRepoImpl();
    public UserDto getUserById(int id, EntityManager em){
        return new UserDto();
    }
}
