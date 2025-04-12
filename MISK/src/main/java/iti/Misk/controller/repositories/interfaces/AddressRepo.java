package iti.Misk.controller.repositories.interfaces;

import jakarta.persistence.EntityManager;

public interface AddressRepo {

    
    public void DeleteAddress(int id,  EntityManager em);
}