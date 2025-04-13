package iti.Misk.controller.services.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import iti.Misk.model.dtos.Address;
import iti.Misk.model.dtos.UserDto;
import iti.Misk.model.newentity.Order;
import iti.Misk.model.newentity.Shoppingcart;
import jakarta.persistence.EntityManager;

public interface UserService {



      public Boolean addNewUserDto(UserDto UserDto, Address address, EntityManager em);

    public void updateUser(int id, UserDto newUserDto, EntityManager em);

    public UserDto findUserById(Integer UserDtoId, EntityManager em);

    public UserDto findUserByEmail(String emai, EntityManager em);

    public Boolean checkEmailAvailability(String email, EntityManager em);

    public Boolean checkPasswordValidation(String email, String password, EntityManager em);

    public List<UserDto> getAllUserDtos( EntityManager em);

    public int getUserDtoIdByEmail(String email, EntityManager em);

    public BigDecimal getUserDtoCreditCardLimit(int id, EntityManager em);

    public Set<Order> getAllUserDtoOrders(int id, EntityManager em);

    public Set<Shoppingcart> getUserDtoShoppinCard(int id, EntityManager em);

    public Set<Address> getAddress(int id, EntityManager em);

    public boolean addListOfAddresses(int id, List<Address> address, EntityManager em);

}
