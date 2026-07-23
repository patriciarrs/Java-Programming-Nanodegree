package com.udacity.cart.service;

import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalsCalculatorTest {
    @Test
    @DisplayName("Verify 2+6+2 = 11 and 0.5+0.6+0.1 = 1.2")
    public void getTotals_givenMultipleItems_sumsPriceAndTax() {
        // Arrange
        TotalsCalculator totalsCalculator = new TotalsCalculator();

        CartItem cartItem1 = new CartItem("Soda", 3.00, 0.50);
        CartItem cartItem2 = new CartItem("Small peperoni pizza", 6.00, 0.60);
        CartItem cartItem3 = new CartItem("Fries", 2.00, 0.10);

        List<CartItem> cartItemList = List.of(cartItem1, cartItem2, cartItem3);

        // Act
        CartTotals cartTotals = totalsCalculator.getTotals(cartItemList);

        // Assert
        /* assertEquals(double) takes an additional parameter specifying the acceptable variance,
         * because doubles are floating point numbers that will rarely be 100% equal */
        Assertions.assertAll("This Message Will Print In The Test Report",
                () -> assertEquals(11.00, cartTotals.getSubtotal(), 0.001),
                () -> assertEquals(1.2, cartTotals.getTaxes(), 0.001));
    }
}
