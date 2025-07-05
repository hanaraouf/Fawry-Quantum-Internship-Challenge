/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.commerce;

/**
 *
 * @author hanaraouf
 */
// This is the main method to test everything together.
public class Main {
    public static void main(String[] args) {
        // A sample product class with both expirable and shippable behavior.
        abstract class SampleProduct extends ExpirableShippableProduct {
            public SampleProduct(String name, double price, int quantity, boolean expired, double weight) {
                super(name, price, quantity, expired, weight);
            }
        }

        // Create products with name, price, quantity, expired status, and weight
        Product cheese = new SampleProduct("Cheese", 100.0, 10, false, 200) {};
        Product biscuits = new SampleProduct("Biscuits", 150.0, 5, false, 700) {};

        Customer customer = new Customer("Test Customer", 500);
        
        // Create a shopping cart
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        ShippingServices shippingService = new ShippingServices();
        ShippingFeeCalculator feeCalculator = new ShippingFeeCalculator();
        
        // Create a checkout service and perform checkout
        CheckoutService checkout = new CheckoutService(shippingService, feeCalculator);
        checkout.checkout(customer, cart);
    }
}