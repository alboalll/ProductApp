package ro.rarom.ProductApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.rarom.ProductApp.entity.Category;
import ro.rarom.ProductApp.entity.Product;
import ro.rarom.ProductApp.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class ProductAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp(ProductRepository repository){
		return args -> {
			repository.saveAll(List.of(
					new Product("Laptop", 300, "ASUS", Category.ELECTRONICS),
					new Product("Laptop", 400, "APPLE", Category.ELECTRONICS),
					new Product("RADIO", 300, "LENOVO", Category.ELECTRONICS),
					new Product("Laptop", 333, "ASUS", Category.ELECTRONICS),
					new Product("TV", 350, "HP", Category.ELECTRONICS),
					new Product("T-SHIRT", 20, "ASUS", Category.CLOTHING),
					new Product("SHIRT", 40, "ASUS", Category.CLOTHING),
					new Product("JACKET", 100, "ASUS", Category.CLOTHING),
					new Product("Laptop", 300, "ASUS", Category.ELECTRONICS),
					new Product("Laptop", 300, "ASUS", Category.ELECTRONICS)
			));
		};
	}

}
