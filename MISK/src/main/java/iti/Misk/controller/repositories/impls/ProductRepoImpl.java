package iti.Misk.controller.repositories.impls;

import java.math.BigDecimal;
import java.util.List;

import iti.Misk.controller.repositories.interfaces.ProductRepo;
import iti.Misk.model.newentity.Product;
import jakarta.persistence.EntityManager;

public class ProductRepoImpl implements ProductRepo {

    @Override
    public int addNewProduct(Product product, EntityManager em) {
        Product newProduct;
        try {
            em.getTransaction().begin();
            newProduct = em.merge(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return -1;
        }
        return newProduct.getProductId();
    }

    @Override
    public boolean updateProduct(Product product, EntityManager em) {
        try {
            em.getTransaction().begin();
            em.merge(product);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts(EntityManager em) {
        try {
            return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error fetching products: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Product getProductById(Integer id, EntityManager em) {
        try {
            return em.find(Product.class, id);
        } catch (Exception e) {
            System.out.println("Error fetching product by ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteProduct(Product product, EntityManager em) {
        try {
            em.getTransaction().begin();
            Product managedProduct = em.contains(product) ? product : em.merge(product);
            em.remove(managedProduct);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting product: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    @Override
    public List<Product> filterProducts(EntityManager em, int offset, int limit, String search, String gender,
            BigDecimal minPrice, BigDecimal maxPrice) {
        try {
            var cb = em.getCriteriaBuilder();
            var cq = cb.createQuery(Product.class);
            var root = cq.from(Product.class);

            var predicates = cb.conjunction(); // كأننا بنبدأ بـ true

            if (search != null && !search.isBlank()) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("name")), "%" + search.toLowerCase() + "%"));
            }

            if (gender != null && !gender.isBlank()) {
                predicates = cb.and(predicates,
                        cb.equal(cb.lower(root.get("gender")), gender.toLowerCase()));
            }

            if (minPrice != null) {
                predicates = cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates = cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            cq.select(root).where(predicates);

            return em.createQuery(cq)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList();

        } catch (Exception e) {
            System.out.println("Error in filtering products: " + e.getMessage());
            return null;
        }
    }

}
