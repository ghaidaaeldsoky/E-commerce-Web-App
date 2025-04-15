package iti.Misk.controller.repositories.interfaces;

import java.math.BigDecimal;
import java.util.List;

import iti.Misk.model.newentity.Product;
import jakarta.persistence.EntityManager;

public interface ProductRepo {

    public int addNewProduct(Product product, EntityManager em);

    public boolean updateProduct(Product product, EntityManager em);

    boolean updateProduct2(Product product, EntityManager em);

    public List<Product> getAllProducts(EntityManager em);
    public Product getProductById(Integer id, EntityManager em);
    // public List<Product> getFilteredProducts(Filer,int pageNum EntityManager em);
    
    public boolean deleteProduct(Product product, EntityManager em);

    public List<Product> filterProducts(EntityManager em, int offset, int limit, String search, String gender, BigDecimal minPrice, BigDecimal maxPrice);

    public long getTotalProductsCount(EntityManager em);
    public BigDecimal getMinPrice(EntityManager em);
    public BigDecimal getMaxPrice(EntityManager em);

} 