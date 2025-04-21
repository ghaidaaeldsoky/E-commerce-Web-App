package iti.Misk.utils.mappers;

import iti.Misk.model.dtos.ShoppingCartDto;
import iti.Misk.model.newentity.Product;
import iti.Misk.model.newentity.Shoppingcart;
import iti.Misk.model.newentity.ShoppingcartId;
import iti.Misk.model.newentity.User;

public class ShoppingCartMapper {
    
    public static ShoppingCartDto toDto(Shoppingcart entity) {
        if (entity == null) return null;

        return new ShoppingCartDto(
            entity.getId().getUserId(),
            entity.getId().getProductId(),
            entity.getQuantity(),
            entity.getAddedAt(),
            entity.getProduct() != null ? entity.getProduct().getName() : null,
            entity.getProduct() != null ? entity.getProduct().getPhoto() : null,
            entity.getProduct() != null ? entity.getProduct().getPrice().doubleValue() : 0.0,
            entity.getProduct() != null ? entity.getProduct().getQuantity() : 0
        );
    }

    public static Shoppingcart toEntity(ShoppingCartDto dto, Product product, User user) {
        if (dto == null || product == null || user == null) return null;

        Shoppingcart entity = new Shoppingcart();
        ShoppingcartId id = new ShoppingcartId(dto.getProductId(), dto.getUserId());
        entity.setId(id);
        entity.setProduct(product);
        entity.setUser(user);
        entity.setQuantity(dto.getQuantity());
        entity.setAddedAt(dto.getAddedAt());
        return entity;
    }
}
