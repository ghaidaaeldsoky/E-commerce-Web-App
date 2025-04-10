package iti.Misk.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import iti.Misk.controller.services.impls.PerfumeServicesImpl;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;

public class Perfumes {

    public static final int PAGE_SIZE = 6;

    private static List<PerfumeDto> perfumes;
    private static Perfumes perfumesInstance;
    private long totalNoOfRecords;

    // private static List<CategoryDto> categoriesWithRandomImg;

    private Perfumes() {

    }

    public static Perfumes getPerfumesInstance() {
        if (perfumesInstance == null)
            perfumesInstance = new Perfumes();
        return perfumesInstance;
    }

    // public List<PerfumeDto> getFilteredPerfumes(String brand, Gender gender,
    // double minPrice, double maxPrice,
    // int pageNumber) {
    // List<PerfumeDto> perfumes =
    // PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();

    // // Filter
    // perfumes = perfumes.stream()
    // .filter(p -> brand == null || p.getBrand().equalsIgnoreCase(brand))
    // .filter(p -> gender == null || p.getGender() == gender)
    // .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
    // .collect(Collectors.toList());

    // return paginate(perfumes, pageNumber);
    // }

    // public List<PerfumeDto> getFilteredPerfumes(String brand, Gender gender,
    // double minPrice, double maxPrice, int pageNumber) {
    // List<PerfumeDto> allPerfumes =
    // PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();

    // List<PerfumeDto> filteredList = allPerfumes.stream()
    // .filter(p -> gender == null || p.getGender() == gender)
    // .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
    // .collect(Collectors.toList());

    // return paginate(filteredList, pageNumber);
    // }

    public List<PerfumeDto> getFilteredPerfumes(String searchQuery, Gender gender,
            double minPrice, double maxPrice,
            int pageNumber) {
        List<PerfumeDto> allPerfumes = PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();

        List<PerfumeDto> filteredList = allPerfumes.stream()
                .filter(p -> gender == null || p.getGender() == gender)
                .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                .filter(p -> searchQuery == null ||
                        p.getName().toLowerCase().contains(searchQuery.toLowerCase()) ||
                        p.getBrand().toLowerCase().contains(searchQuery.toLowerCase()))
                .collect(Collectors.toList());

        return paginate(filteredList, pageNumber);
    }

    private List<PerfumeDto> paginate(List<PerfumeDto> perfumeList, int pageNumber) {
        if (pageNumber < 1)
            pageNumber = 1;
        totalNoOfRecords = perfumeList.size();
        int start = (pageNumber - 1) * PAGE_SIZE;

        if (start >= totalNoOfRecords) {
            return new ArrayList<>();
        }

        return perfumeList.stream()
                .skip(start)
                .limit(PAGE_SIZE)
                .collect(Collectors.toList());

    }

    public int getNoOfPages() {
        return (int) Math.ceil((double) totalNoOfRecords / PAGE_SIZE);
    }

    public List<PerfumeDto> getPerfumes(int pageNumber) {
        if (perfumes == null) {
            perfumes = PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();
        }
        totalNoOfRecords = perfumes.size();
        return paginate(perfumes, pageNumber);
    }

    public double getMinPrice() {
        if (perfumes == null) {
            perfumes = PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();
        }
        return perfumes.stream()
                .mapToDouble(PerfumeDto::getPrice)
                .min()
                .orElse(0.0);
    }

    public double getMaxPrice() {
        if (perfumes == null) {
            perfumes = PerfumeServicesImpl.getPerfumeServices().getAllPerfumes();
        }
        return perfumes.stream()
                .mapToDouble(PerfumeDto::getPrice)
                .max()
                .orElse(250.0);
    }
}
