package csd214.app.services;

import csd214.app.entities.ProductEntity;
import csd214.app.entities.SaleLogEntity;
import csd214.app.repositories.ProductRepository;
import csd214.app.repositories.SaleLogRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookstoreService {
    private final ProductRepository productRepo;
    private final SaleLogRepository logRepo;
    private final DiscountService discountService; // Nested Dependency

    public BookstoreService(ProductRepository pr, SaleLogRepository lr, DiscountService ds) {
        this.productRepo = pr;
        this.logRepo = lr;
        this.discountService = ds;
    }

    @Transactional
    public void sellWithDiscount(Long id, double percent) {
        ProductEntity item = productRepo.findById(id).orElse(null);
        if (item != null) {
            double finalPrice = discountService.applyDiscount(item.getPrice(), percent);
            System.out.println("Dynamic Pricing: Discount applied via Nested Service. Final Total: $" + finalPrice);
            performSale(id); // Logs the sale transaction polymorphically
        }
    }

    private void performSale(Long id) {
        // this needs to log the sale
        ProductEntity item = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Item not found")); // grab the item

        SaleLogEntity log = new SaleLogEntity(); // making the log!
        log.setId(id); // assigning the item
        log.setPriceSoldAt(item.getPrice()); // assigning the price
        log.setTimestamp(LocalDateTime.now()); // assigning the date/time of the sale

        logRepo.save(log); // save

        // could decrease the stock of the item buuuut that's a lot of work and you didn't say we had to so
    }
}

