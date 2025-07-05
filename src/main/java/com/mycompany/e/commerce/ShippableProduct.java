package com.mycompany.e.commerce;


import com.mycompany.e.commerce.AbstractProduct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// A product that can be shipped must have a weight.
public abstract class ShippableProduct extends AbstractProduct implements ShippableItem{
    private double Weight;
    
    public ShippableProduct(String Name, double Price, int Quantity,double Weight) {
        super(Name, Price, Quantity);
        this.Weight=Weight;
    }
    
    public double getWeight() {return Weight ;}
    
}
