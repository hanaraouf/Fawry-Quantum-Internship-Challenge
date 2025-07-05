package com.mycompany.e.commerce;


import com.mycompany.e.commerce.AbstractProduct;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// A product that can expire like food items.
public abstract class ExpirableProduct extends AbstractProduct implements Expirable {
    private boolean expired;
    
    public ExpirableProduct(String Name, double Price,int Quantity,boolean expired) {
        super(Name,Price,Quantity);
        this.expired=expired;
    }
    public boolean isExpired() {
        return expired;
    }
}