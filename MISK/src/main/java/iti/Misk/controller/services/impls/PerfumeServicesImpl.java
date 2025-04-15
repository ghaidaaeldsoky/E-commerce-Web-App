package iti.Misk.controller.services.impls;

import java.util.ArrayList;
import java.util.List;

import iti.Misk.controller.services.interfaces.PerfumeServices;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;

public class PerfumeServicesImpl implements PerfumeServices {

    // My Perfumes in the arrayList
    private List<PerfumeDto> perfumes = new ArrayList<>();
    private static PerfumeServicesImpl perfumeService;
    private static int idCounter = 1;

    private PerfumeServicesImpl() {
        // testing
      

    }

    public static PerfumeServicesImpl getPerfumeServices() {
        if (perfumeService == null)
            perfumeService = new PerfumeServicesImpl();
        return perfumeService;
    }

    @Override
    public List<PerfumeDto> getAllPerfumes() {
        List<PerfumeDto> filteredPerfumes = new ArrayList<>();

        return perfumes;
    }

    @Override
    public int addPerfume(PerfumeDto perfume) {
        perfume.setId(idCounter++);
        perfumes.add(perfume);
        return perfume.getId();
    }

    @Override
    public boolean deletePerfume(int id) {
        return perfumes.removeIf(perfume -> perfume.getId() == id);
    }

    @Override
    public PerfumeDto findPerfume(int perfumeID) {
        return perfumes.stream()
                .filter(perfume -> perfume.getId() == perfumeID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updatePerfume(PerfumeDto perfume) {
        for (int i = 0; i < perfumes.size(); i++) {
            if (perfumes.get(i).getId() == perfume.getId()) {
                perfumes.set(i, perfume);
                return true;
            }
        }
        return false;
    }

}
