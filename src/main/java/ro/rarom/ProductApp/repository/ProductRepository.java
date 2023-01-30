package ro.rarom.ProductApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.ProductApp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
