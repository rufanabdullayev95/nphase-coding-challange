package com.nphase.service;


import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartServiceTest {

    private final ShoppingCartService service = new ShoppingCartService();

    @Test
    public void calculatesPriceByRewardWithCategory() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, 3, BigDecimal.valueOf(10), "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, 3, BigDecimal.valueOf(10), "drinks"),
                new Product("Cheese", BigDecimal.valueOf(8), 2, 3, BigDecimal.valueOf(10), "Food")
        ));

        BigDecimal result = service.calculatePriceByRewardWithCategory(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }

    @Test
    public void calculatesPriceWithReward() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 5, 3, BigDecimal.valueOf(10)),
                new Product("Coffee", BigDecimal.valueOf(3.5), 3, 3, BigDecimal.valueOf(10))
        ));

        BigDecimal result = service.calculateTotalPriceByReward(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(33.0));
    }

    @Test
    public void calculatesPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 2),
                new Product("Coffee", BigDecimal.valueOf(6.5), 1)
        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(16.5));
    }

}