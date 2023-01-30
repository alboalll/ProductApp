package ro.rarom.ProductApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ro.rarom.ProductApp.entity.Product;
import ro.rarom.ProductApp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Optional<Product> getProductById(int productId) {
        return repo.findById(productId);
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }

    public Product deleteProductById(int productId) {
        Optional<Product> inventory = repo.findById(productId);
        inventory.ifPresent(repo::delete);
        return inventory.orElse(null);
    }
}
