package csd214.app.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sale_logs")
public class SaleLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private double priceSoldAt;
    private LocalDateTime timestamp;

    public SaleLogEntity() {}

    public SaleLogEntity(String productId, double price) {
        this.productId = productId;
        this.priceSoldAt = price;
        this.timestamp = LocalDateTime.now();
    }

    // Generate getters, setters, toString, equals, and hashCode using Alt+Insert
}