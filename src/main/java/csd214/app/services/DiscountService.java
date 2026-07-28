package csd214.app.services;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    public double applyDiscount(double originalPrice, double percent) {
        return originalPrice * (1.0 - (percent / 100.0));
    }
}
