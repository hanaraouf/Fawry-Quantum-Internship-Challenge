package com.mycompany.e.commerce;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// This is a base class for all product types, implementing basic product behavior.
abstract class AbstractProduct implements Product {
    protected String name;
    protected double price;
    protected int quantity;

    public AbstractProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public boolean isAvailable(int requestedQty) {
        return requestedQty <= quantity; // Returns true if the requested quantity is available.
    }
}