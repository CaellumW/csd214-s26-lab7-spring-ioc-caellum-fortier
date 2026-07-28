package csd214.app.services;

import csd214.app.entities.ProductEntity;
import csd214.app.entities.SaleLogEntity;
import csd214.app.repositories.ProductRepository;
import csd214.app.repositories.SaleLogRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookstoreService {
    private final ProductRepository productRepo;
    private final SaleLogRepository logRepo;

    // Spring's IoC container automatically injects both repositories
    public BookstoreService(ProductRepository productRepo, SaleLogRepository logRepo) {
        this.productRepo = productRepo;
        this.logRepo = logRepo;
    }

    @Transactional
    public void performSale(Long id) {
        ProductEntity item = productRepo.findById(id).orElse(null);
        if (item != null) {
            // Business Logic: Log the transaction event
            logRepo.save(new SaleLogEntity(item.getProductId(), item.getPrice()));
            System.out.println("Audit System: Transaction logged securely to SaleLog table.");
        }
    }
}
