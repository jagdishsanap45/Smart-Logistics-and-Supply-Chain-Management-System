package Jag.sanap.SLSCMS.Inventory.Service.repository;

import Jag.sanap.SLSCMS.Inventory.Service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query method to find a product by its name
    Optional<Product> findByName(String name);
}
