package com.nphase.entity;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal pricePerUnit;
    private final int quantity;
    private int minimumCountForReward;
    private BigDecimal discount;
    private String category;

    public Product(String name, BigDecimal pricePerUnit, int quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public Product(String name, BigDecimal pricePerUnit, int quantity, int minimumCountForReward, BigDecimal discount) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.minimumCountForReward = minimumCountForReward;
        this.discount = discount;
    }

    public Product(String name, BigDecimal pricePerUnit, int quantity, int minimumCountForReward, BigDecimal discount, String category) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
        this.minimumCountForReward = minimumCountForReward;
        this.discount = discount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinimumCountForReward() {
        return minimumCountForReward;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getCategory() {
        return category;
    }
}
