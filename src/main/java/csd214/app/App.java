package csd214.app;

import csd214.app.entities.ProductEntity;
import csd214.app.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {

    private ProductRepository repository;

    public void ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductEntity> findLessThan(int num) {
        return repository.findByPriceLessThan(num);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
