package iti.Misk.utils.mappers;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import iti.Misk.model.dtos.PerfumeDto;
import iti.Misk.model.enums.Gender;
import iti.Misk.model.newentity.Product;

public class ProductMapper {
    public static PerfumeDto toDto(Product product) {
        if (product == null)
            return null;

        Gender gender = null;
        try {
            gender = Gender.valueOf(product.getGender());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender in product entity: " + product.getGender());
        }

        return new PerfumeDto(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice().doubleValue(),
                product.getQuantity(),
                product.getPhoto(),
                product.getBrand(),
                product.getSize(),
                gender);
    }

    public static Product toEntity(PerfumeDto dto) {
        if (dto == null)
            return null;

        Product product = new Product();
        product.setProductId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(BigDecimal.valueOf(dto.getPrice()));
        product.setQuantity(dto.getQuantity());
        product.setPhoto(dto.getPhoto());
        product.setBrand(dto.getBrand());
        product.setSize(dto.getSize());
        product.setGender(dto.getGender() != null ? dto.getGender().name() : null);

        return product;
    }

    public static List<PerfumeDto> toDtoList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<Product> toEntityList(List<PerfumeDto> dtos) {
        return dtos.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
    }
}
