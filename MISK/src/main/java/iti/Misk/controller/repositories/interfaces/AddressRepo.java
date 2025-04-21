package iti.Misk.controller.repositories.interfaces;

import iti.Misk.model.newentity.Useraddress;
import jakarta.persistence.EntityManager;

public interface AddressRepo {

    
    public void DeleteAddress(int id,  EntityManager em);

    Useraddress getAddressbyAddressID(int addressID, EntityManager em);

    public int addAddressForUser(int userId, Useraddress addressEntity, EntityManager em);
}