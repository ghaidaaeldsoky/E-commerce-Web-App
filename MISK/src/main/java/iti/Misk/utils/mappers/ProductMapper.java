package iti.Misk.utils.mappers;

import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
import iti.Misk.model.newentity.Product;

public class ProductMapper {
    public static PerfumeDto toDto(Product product) {
        if (product == null) {
            return null;
        }

        PerfumeDto dto = new PerfumeDto(
            product.getProductId(),
            product.getName(),
            product.getDescription(),
            product.getPrice().doubleValue(),
            product.getQuantity(),
            product.getPhoto(),
            product.getBrand(),
            product.getSize(),
            Gender.valueOf(product.getGender()) // handling string to enum
        );

        return dto;
    }

    public static Product toEntity(PerfumeDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setProductId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(java.math.BigDecimal.valueOf(dto.getPrice()));
        product.setQuantity(dto.getQuantity());
        product.setPhoto(dto.getPhoto());
        product.setBrand(dto.getBrand());
        product.setSize(dto.getSize());
        product.setGender(dto.getGender().name()); // enum to string

        return product;
    }
}
