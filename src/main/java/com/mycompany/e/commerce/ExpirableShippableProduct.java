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
// Combines both expirable and shippable behavior.
public abstract class ExpirableShippableProduct extends AbstractProduct implements Expirable,ShippableItem{
    private boolean expired;
    private double Weight;
    
    public ExpirableShippableProduct(String Name, double Price, int Quantity,boolean expired,double Weight) {
        super(Name, Price, Quantity);
        this.Weight=Weight;
        this.expired=expired;
    }
    
    public boolean isExpired() {
        return expired;
    }
    public double getWeight() {
        return Weight;
    }
}
