package iti.Misk.controller.repositories.impls;

import iti.Misk.controller.repositories.interfaces.AddressRepo;
import iti.Misk.model.newentity.User;
import iti.Misk.model.newentity.Useraddress;
import jakarta.persistence.EntityManager;

public class AddressRepoEmployee  implements AddressRepo{

    @Override
    public void DeleteAddress(int id, EntityManager em) {

        em.getTransaction().begin();
       
        Useraddress addressToRemove = em.find(Useraddress.class, id);

        if (addressToRemove != null) {
  
            User user= addressToRemove.getUser();
        

            user.getUseraddresses().remove(addressToRemove);

            addressToRemove.setUser(null);


            em.merge(user);        

            em.getTransaction().commit();
            

       

    }
}





@Override
public Useraddress getAddressbyAddressID(int addressID, EntityManager em){

        em.getTransaction().begin();
        Useraddress address = em.find(Useraddress.class, addressID);
        em.getTransaction().commit();
        return address;
}






}