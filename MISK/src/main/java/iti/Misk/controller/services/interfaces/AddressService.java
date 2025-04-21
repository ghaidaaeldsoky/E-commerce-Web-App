package iti.Misk.controller.services.interfaces;

import jakarta.persistence.EntityManager;

public interface AddressService  {


    public void DeleteAddress(int id,  EntityManager em);

}
