package iti.Misk.controller.services.impls;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import iti.Misk.controller.repositories.impls.ProductRepoImpl;
import iti.Misk.controller.repositories.interfaces.ProductRepo;
import iti.Misk.controller.services.interfaces.PerfumeServices;
import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
import iti.Misk.model.newentity.Product;
import iti.Misk.utils.mappers.ProductMapper;
import jakarta.persistence.EntityManager;

public class PerfumeServicesImpl implements PerfumeServices{

    // My Perfumes in the arrayList
    private List<PerfumeDto> perfumes = new ArrayList<>();
    private static PerfumeServicesImpl perfumeService;
    private static int idCounter = 1;
    private ProductRepo productRepo = new ProductRepoImpl();
    private static final int PAGE_SIZE = 6;

    private PerfumeServicesImpl() {
        // testing
        // perfumes.add(new PerfumeDto(idCounter++, "Dior Sauvage", "Fresh and strong scent", 120.0, 0,
        //         "./img/product/dior_sauvage.jpg", "Dior", "100ml", Gender.Men));
        // perfumes.add(
        //         new PerfumeDto(idCounter++, "Chanel No. 5", "Luxury Perfume", 150.0, 10, "./img/product/chanel_no5.jpg",
        //                 "Chanel", "50ml", Gender.Women));
        // perfumes.add(new PerfumeDto(idCounter++, "Tom Ford Oud Wood", "Elegant woody scent", 200.0, 12,
        //         "./img/product/tom_ford_oud_wood.jpg", "Tom Ford", "100ml", Gender.Unisex));
        // perfumes.add(new PerfumeDto(idCounter++, "Versace Eros", "Seductive and intense", 100.0, 20,
        //         "./img/product/versace_eros.jpg",
        //         "Versace", "100ml", Gender.Men));
        // perfumes.add(new PerfumeDto(idCounter++, "Gucci Bloom", "Floral and graceful", 130.0, 18,
        //         "./img/product/gucci_bloom.jpg",
        //         "Gucci", "75ml", Gender.Women));
        // perfumes.add(new PerfumeDto(idCounter++, "Creed Aventus", "Powerful and rich", 250.0, 8,
        //         "./img/product/creed_aventus.jpg",
        //         "Creed", "100ml", Gender.Men));
        // perfumes.add(new PerfumeDto(idCounter++, "YSL Libre", "Bold and floral", 140.0, 14,
        //         "./img/product/ysl_libre.jpg", "YSL",
        //         "90ml", Gender.Women));
        // perfumes.add(new PerfumeDto(idCounter++, "Armani Code", "Modern and masculine", 110.0, 16,
        //         "./img/product/armani_code.jpg",
        //         "Armani", "100ml", Gender.Men));
        // perfumes.add(new PerfumeDto(idCounter++, "Lancôme La Vie Est Belle", "Sweet and joyful", 135.0, 9,
        //         "./img/product/lancome_la_vie_est_belle.jpg", "Lancôme", "75ml", Gender.Women));
        // perfumes.add(new PerfumeDto(idCounter++, "Dolce & Gabbana Light Blue", "Fresh and energetic", 120.0, 13,
        //         "./img/product/dg_light_blue.jpg", "D&G", "100ml", Gender.Unisex));

    }

    public static PerfumeServicesImpl getPerfumeServices() {
        if (perfumeService == null)
            perfumeService = new PerfumeServicesImpl();
        return perfumeService;
    }

    // @Override
    // public List<PerfumeDto> getAllPerfumes() {
    //     List<PerfumeDto> filteredPerfumes = new ArrayList<>();

    //     return perfumes;
    // }

    // @Override
    // public int addPerfume(PerfumeDto perfume) {
    //     perfume.setId(idCounter++);
    //     perfumes.add(perfume);
    //     return perfume.getId();
    // }

    // @Override
    // public boolean deletePerfume(int id) {
    //     return perfumes.removeIf(perfume -> perfume.getId() == id);
    // }

    // @Override
    // public PerfumeDto findPerfume(int perfumeID) {
    //     return perfumes.stream()
    //             .filter(perfume -> perfume.getId() == perfumeID)
    //             .findFirst()
    //             .orElse(null);
    // }

    // @Override
    // public boolean updatePerfume(PerfumeDto perfume) {
    //     for (int i = 0; i < perfumes.size(); i++) {
    //         if (perfumes.get(i).getId() == perfume.getId()) {
    //             perfumes.set(i, perfume);
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // With DB:
    public List<PerfumeDto> getFilteredPerfumes(String searchQuery, Gender gender,
                                                double minPrice, double maxPrice,
                                                int pageNumber, EntityManager em) {
        BigDecimal min = BigDecimal.valueOf(minPrice);
        BigDecimal max = BigDecimal.valueOf(maxPrice);

        List<Product> filteredProducts = productRepo.filterProducts(em, pageNumber, PAGE_SIZE,
                searchQuery,
                gender != null ? gender.toString() : null,
                min, max);

        return filteredProducts.stream()
                .map(product -> ProductMapper.toDto(product))
                .collect(Collectors.toList());
    }

    public int getTotalPages(EntityManager em, String searchQuery, Gender gender,
                             double minPrice, double maxPrice) {
        List<Product> allMatching = productRepo.filterProducts(em, 1, Integer.MAX_VALUE,
                searchQuery,
                gender != null ? gender.toString() : null,
                BigDecimal.valueOf(minPrice),
                BigDecimal.valueOf(maxPrice));

        if (allMatching == null) return 0;

        int totalProducts = allMatching.size();
        return (int) Math.ceil((double) totalProducts / PAGE_SIZE);
    }

    public double getMinPrice(EntityManager em) {
        BigDecimal min = productRepo.getMinPrice(em);
        return min != null ? min.doubleValue() : 0;
    }

    public double getMaxPrice(EntityManager em) {
        BigDecimal max = productRepo.getMaxPrice(em);
        return max != null ? max.doubleValue() : 0;
    }

    public PerfumeDto getPerfumeById(int id, EntityManager em) {
        Product p = productRepo.getProductById(id, em);
        if(p==null) return null;
        return ProductMapper.toDto(p);
    }

    @Override
    public List<PerfumeDto> getAllPerfumes(EntityManager em) {
        return ProductMapper.toDtoList(productRepo.getAllProducts(em));
    }

    @Override
    public int addPerfume(PerfumeDto perfume,EntityManager em) {
        return productRepo.addNewProduct(ProductMapper.toEntity(perfume), em);
    }

    @Override
    public boolean deletePerfume(int id,EntityManager em) {
        Product p = productRepo.getProductById(id, em);
        return productRepo.deleteProduct(p, em);
    }

    @Override
    public PerfumeDto findPerfume(int perfumeID,EntityManager em) {
        return ProductMapper.toDto(productRepo.getProductById(perfumeID, em));
    }

    @Override
    public boolean updatePerfume(PerfumeDto perfume,EntityManager em) {
        return productRepo.updateProduct(ProductMapper.toEntity(perfume), em);
    }


}
