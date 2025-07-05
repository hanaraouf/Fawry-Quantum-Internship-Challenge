/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.commerce;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanaraouf
 */
// Handles the full process of checking out: validation, shipping, and payment.
public class CheckoutService {
    private ShippingServices shippingService;
    private ShippingFeeCalculator feeCalculator;

    public CheckoutService(ShippingServices shippingService, ShippingFeeCalculator feeCalculator) {
        this.shippingService = shippingService;
        this.feeCalculator = feeCalculator;
    }

    // Validates cart, checks stock and expiration, processes payment, and prints receipt.
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty");
            return;
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (!product.isAvailable(quantity)) {
                System.out.println("Error: " + product.getName() + " is out of stock");
                return;
            }
            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    System.out.println("Error: " + product.getName() + " is expired");
                    return;
                }
            }
        }

        double subtotal = cart.calculateSubtotal();
        List<ShippableItem> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof ShippableItem) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add((ShippableItem) item.getProduct());
                }
            }
        }

        double shippingFee = feeCalculator.calculate(shippableItems);
        double total = subtotal + shippingFee;

        if (!customer.hasSufficientBalance(total)) {
            System.out.println("Error: Insufficient balance");
            return;
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
        customer.pay(total);

        shippingService.ship(shippableItems);
        printReceipt(cart, subtotal, shippingFee, total, customer.getbalance());
    }

    // Shows what the customer bought and how much they paid.
    private void printReceipt(Cart cart, double subtotal, double shippingFee, double total, double balance) {
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            String name = item.getProduct().getName();
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            System.out.println(item.getQuantity() + "x " + name + "    " + (int)itemTotal);
        }
        System.out.println("---");
        System.out.println("Subtotal    " + (int)subtotal);
        System.out.println("Shipping    " + (int)shippingFee);
        System.out.println("Amount      " + (int)total);
        System.out.println("Customer balance: " + (int)balance + "\n");
    }
}
