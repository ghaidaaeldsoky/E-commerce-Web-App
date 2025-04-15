package iti.Misk.controller.services.impls;

import iti.Misk.controller.repositories.impls.AddressRepoEmployee;
import iti.Misk.controller.repositories.interfaces.AddressRepo;
import iti.Misk.controller.services.interfaces.AddressService;
import iti.Misk.model.dtos.Address;
import iti.Misk.utils.mappers.AddressMapper;
import jakarta.persistence.EntityManager;

public class AddressServiceImp implements AddressService {

    AddressRepo addressRepo;

    public AddressServiceImp( AddressRepo addressRepo)
    {
        this.addressRepo = addressRepo;
    }

    public AddressServiceImp() {
        addressRepo = new AddressRepoEmployee();
    }


    @Override
    public void DeleteAddress(int id, EntityManager em) {
      
        addressRepo.DeleteAddress(id, em);
    }

    public int addNewAddressForUser(int userId, Address addressDto, EntityManager em){
        return addressRepo.addAddressForUser(userId, AddressMapper.toEntity(addressDto), em);
    }

}
