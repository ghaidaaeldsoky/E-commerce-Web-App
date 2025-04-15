package iti.Misk.controller.services.impls;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iti.Misk.controller.repositories.interfaces.UserRepo;
import iti.Misk.controller.services.interfaces.UserService;
import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.User;
import iti.Misk.model.newentity.Useraddress;
import iti.Misk.utils.mappers.AddressMapper;
import iti.Misk.utils.mappers.UserMapper;
import jakarta.persistence.EntityManager;

public class UserServiceImpl implements UserService {

    UserRepo userRepo ;

    public UserServiceImpl(UserRepo userReoo)
    {
        this.userRepo = userReoo;
    }

    @Override
    public Boolean addNewUserDto(UserDto UserDto, Address address, EntityManager em) {
        
        User user = UserMapper.toEntity(UserDto);

        Useraddress useraddress = AddressMapper.toEntity(address);

      return  userRepo.addNewUser(user, useraddress, em);

        
    }

    @Override
    public void updateUser(int id, UserDto newUserDto, EntityManager em) {
        
        User user = UserMapper.toEntity(newUserDto);

        userRepo.updateUser(id, user, em);


    }

    @Override
    public UserDto findUserById(Integer UserDtoId, EntityManager em) {
        
        User user = userRepo.findUserById(UserDtoId, em);

        return UserMapper.toDto(user);

    }

    @Override
    public UserDto findUserByEmail(String email, EntityManager em) {

        User user = userRepo.findUserByEmail(email, em);

        return UserMapper.toDto(user);
      
    }

    @Override
    public Boolean checkEmailAvailability(String email, EntityManager em) {
       
        return userRepo.checkEmailAvailability(email, em);
    }

    @Override
    public Boolean checkPasswordValidation(String email, String password, EntityManager em) {
        
        return userRepo.checkPasswordValidation(email, password,em);
    }

    @Override
    public List<UserDto> getAllUserDtos(EntityManager em) {
        
        List<User> users = userRepo.getAllUsers( em);

        List<UserDto> usersDto = new ArrayList<>();
        for(User user :users)
        {


            usersDto.add(UserMapper.toDto(user));
        }

        return usersDto;
    }

    @Override
    public int getUserDtoIdByEmail(String email, EntityManager em) {
       
        return userRepo.getUserIdByEmail(email, em);
    }

    @Override
    public BigDecimal getUserDtoCreditCardLimit(int id, EntityManager em) {
       
        return  userRepo.getUserCreditCardLimit(id, em);
    }

    @Override
    public Set<Order> getAllUserDtoOrders(int id, EntityManager em) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUserDtoOrders'");
    }

    @Override
    public Set<Shoppingcart> getUserDtoShoppinCard(int id, EntityManager em) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserDtoShoppinCard'");
    }

    @Override
public Set<Address> getAddress(int id, EntityManager em) {

    Set<Useraddress> userAddresses = userRepo.getUseraddress(id, em);
    
    Set<Address> addresses = new HashSet<>();
    for (Useraddress ua : userAddresses) {
        addresses.add(AddressMapper.toDto(ua));
    }

    return addresses;
}

@Override
public boolean addListOfAddresses(int id, List<Address> addresses, EntityManager em) {

    List<Useraddress> userAddresses = new ArrayList<>();
    for (Address address : addresses) {
        userAddresses.add(AddressMapper.toEntity(address));
    }

    return userRepo.addListOfAddresses(id, userAddresses, em);
}


}
