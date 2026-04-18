package johannanguyen.redflagbackend.repository;

import johannanguyen.redflagbackend.entity.Product;
import johannanguyen.redflagbackend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long > {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByCategory(ProductCategory category);
}
