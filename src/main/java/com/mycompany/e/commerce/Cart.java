package com.mycompany.e.commerce;

import java.util.ArrayList;
import java.util.List;

// Holds items added by the customer and calculates the subtotal.
public class Cart {
    private final List<CartItem> items = new ArrayList<>();
    
// Adds a product to the cart if there's enough quantity.
    public boolean add(Product product, int quantity) {
        if (!product.isAvailable(quantity)) return false;

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQty = item.getQuantity() + quantity;
                if (!product.isAvailable(newQty)) return false;
                item.setQuantity(newQty);
                return true;
            }
        }

        items.add(new CartItem(product, quantity));
        return true;
    }

    public List<CartItem> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }

     // Calculates the total price of all items in the cart.
    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (CartItem item : items) {
            subtotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return subtotal;
    }
}