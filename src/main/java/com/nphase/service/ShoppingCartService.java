package com.nphase.service;

import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartService {

    public BigDecimal calculatePriceByRewardWithCategory(ShoppingCart shoppingCart) {
        List<Product> products = shoppingCart.getProducts();
        Map<String, Integer> map = getProductQuantityAsMap(products);

        return products.stream().map(product -> {
                    BigDecimal price = product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
                    int count = map.get(product.getCategory());
                    price = count > product.getMinimumCountForReward() ? price.subtract(price.multiply(product.getDiscount()).divide(BigDecimal.valueOf(100))) : price;
                    return price;
                }).reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private Map<String, Integer> getProductQuantityAsMap(List<Product> products) {
        Map<String, Integer> map = new HashMap<>();
        for (Product product : products) {
            String category = product.getCategory();
            int quantity = map.get(category) == null ? 0 : product.getQuantity();
            map.put(category, quantity + product.getQuantity());
        }
        return map;
    }

    public BigDecimal calculateTotalPriceByReward(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts().stream().map(product -> {
                    BigDecimal price = product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
                    price = product.getQuantity() > product.getMinimumCountForReward() ? price.subtract(price.multiply(product.getDiscount()).divide(BigDecimal.valueOf(100))) : price;
                    return price;
                }).reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
