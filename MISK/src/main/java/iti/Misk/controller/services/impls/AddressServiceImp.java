package iti.Misk.controller.services.impls;

import iti.Misk.controller.repositories.interfaces.AddressRepo;
import iti.Misk.controller.services.interfaces.AddressService;
import jakarta.persistence.EntityManager;

public class AddressServiceImp implements AddressService {

    AddressRepo addressRepo;

    AddressServiceImp( AddressRepo addressRepo)
    {
        this.addressRepo = addressRepo;
    }

    @Override
    public void DeleteAddress(int id, EntityManager em) {
      
        addressRepo.DeleteAddress(id, em);
    }

}
