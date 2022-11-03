/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.Collection;

public class Order {
    private final String id;

    public Order(String id) {
        this.id = id;
    }

    /**
     * TODO:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) { // ShoppingCart of anything as long as it takes a Product
        System.out.printf("Order ID: %s\n", getId());
        for (Product product : cart.allItems()) {
            System.out.printf("Code: %s \n", product.getCode());
        }
        System.out.printf("Order Total: %s. \n", cart.total());
    }

    public String getId() {
        return id;
    }
}