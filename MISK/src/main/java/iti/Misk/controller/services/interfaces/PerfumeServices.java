package iti.Misk.controller.services.interfaces;

import java.util.List;

import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
import jakarta.persistence.EntityManager;

public interface PerfumeServices {

    // get All Perfumes
    public List<PerfumeDto> getAllPerfumes(EntityManager em);

    // Add new Perfume
    int addPerfume(PerfumeDto perfume, EntityManager em);

    // remove Perfume
    boolean deletePerfume(int id ,EntityManager em);

    // find Perfume
    PerfumeDto findPerfume(int perfumeID, EntityManager em);

    boolean updatePerfume(PerfumeDto perfume, EntityManager em);

    public List<PerfumeDto> getFilteredPerfumes(String searchQuery, Gender gender,
            double minPrice, double maxPrice,
            int pageNumber, EntityManager em);

    public int getTotalPages(EntityManager em, String searchQuery, Gender gender,
            double minPrice, double maxPrice);

    public double getMinPrice(EntityManager em);

    public double getMaxPrice(EntityManager em);

    public PerfumeDto getPerfumeById(int id, EntityManager em);
}
