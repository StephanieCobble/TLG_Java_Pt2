/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {

    private final String id;
    private double cost;

    private final Location location;

    public Order(String id, Location location) {
        this.id = id;
        this.location = location;
    }


    // TODO friday morning
    // tax is a function of location: Online, USA, EU
    // NOTE: could do massive if/elseif/elseif but don't.
    public double getTax() {
        // fetch tax calculator from the factory (coding by intention)
        TaxCalculator calc = TaxCalculatorFactory.getTaxCalculator(getLocation());

        // delegate to it for the actual tax collection, given this Order's cost
        return calc.taxAmount(getCost());
    }

    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }
        this.cost = cart.total(); // get the total value of all the products & store it
        System.out.println("Order Total: " + getCost());
    }

    public String getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public Location getLocation() {
        return location;
    }
}