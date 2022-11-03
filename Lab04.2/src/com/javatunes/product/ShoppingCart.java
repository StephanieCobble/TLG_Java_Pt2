/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


// At runtime, client will specify the <T>
// Ex: ShoppingCart<Product> cart = new ...    The <T> = Product
// Ex: ShoppingCart<MusicItem> cart = new ...  The <T> = MusicItem
public class ShoppingCart<T extends Product> { // ShoppingCart of anything as long as IS-A type Product
    // storage for the cart's contents
    private final Collection<T> items = new ArrayList<T>();  // diamond not used here just to emphasize the T

    public double total() {
        double result = 0.0;
        for (T item : items) {
            result += item.getPrice();
        }
        return result;
    }

    public Collection<T> allItems() {
        return Collections.unmodifiableCollection(items);
    }


    public int size() {
        return items.size();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void removeItem(T item) {
        items.remove(item);
    }
}