package csd214.app.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sale_logs")
public class SaleLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private double priceSoldAt;
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPriceSoldAt() {
        return priceSoldAt;
    }

    public void setPriceSoldAt(double priceSoldAt) {
        this.priceSoldAt = priceSoldAt;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SaleLogEntity{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", priceSoldAt=" + priceSoldAt +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SaleLogEntity that = (SaleLogEntity) o;
        return Double.compare(priceSoldAt, that.priceSoldAt) == 0 && Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, priceSoldAt, timestamp);
    }

    // no param constructor
    public SaleLogEntity() {}

    // overloaded constructor
    public SaleLogEntity(String productId, double price) {
        this.productId = productId;
        this.priceSoldAt = price;
        this.timestamp = LocalDateTime.now();
    }

}