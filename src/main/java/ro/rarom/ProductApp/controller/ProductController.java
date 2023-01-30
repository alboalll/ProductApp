package ro.rarom.ProductApp.controller;

import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.rarom.ProductApp.entity.Product;
import ro.rarom.ProductApp.exception.ResourceNotFoundException;
import ro.rarom.ProductApp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    List<Product> getProducts() {
        return service.getProducts();
    }
    @GetMapping("{productId}")
    Product getProductById(@PathVariable int productId){
        return service.getProductById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Could not find product with id " + productId));
    }
    @PostMapping
    Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @DeleteMapping("{productId}")
    void deleteProductById(@PathVariable int productId){
        service.deleteProductById(productId);
    }
}
