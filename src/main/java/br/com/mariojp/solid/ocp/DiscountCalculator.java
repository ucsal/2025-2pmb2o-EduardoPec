package br.com.mariojp.solid.ocp;

import java.util.EnumMap;
import java.util.Map;

public class DiscountCalculator {
    
    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        this.policies = new EnumMap<>(CustomerType.class);
        this.policies.put(CustomerType.REGULAR, new RegularPolicy());
        this.policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        this.policies.put(CustomerType.PARTNER, new PartnerPolicy());
    }

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public double apply(double amount, CustomerType type) {
        return policies.get(type).apply(amount);
    }
}
