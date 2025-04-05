package iti.Misk.controller.services.interfaces;

import java.util.List;

import iti.Misk.model.dtos.PerfumeDto;

public interface PerfumeServices {

    // get All Perfumes
    public List<PerfumeDto> getAllPerfumes();
    
    // Add new Perfume
    int addPerfume(PerfumeDto perfume);

    // remove Perfume
    boolean deletePerfume(int id);

    // find Perfume
    PerfumeDto findPerfume(int perfumeID);

    boolean updatePerfume(PerfumeDto perfume);
} 
