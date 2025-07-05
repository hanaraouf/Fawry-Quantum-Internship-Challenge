package com.mycompany.e.commerce;


import com.mycompany.e.commerce.ShippableItem;
import com.mycompany.e.commerce.AbstractProduct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// Interface defines the basic properties all products must have.
interface Product {
    String getName();
    double getPrice();
    int getQuantity();
    void setQuantity(int quantity);

    public boolean isAvailable(int quantity);
}