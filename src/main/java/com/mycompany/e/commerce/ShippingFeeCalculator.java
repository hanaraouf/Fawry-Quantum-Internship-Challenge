/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.e.commerce;

import java.util.List;

/**
 *
 * @author hanaraouf
 */
// Calculates shipping fee. Flat fee if there are shippable items.
public class ShippingFeeCalculator {
     public double calculate(List<ShippableItem> items) {
        return items.isEmpty() ? 0 : 30.0; // flat fee
    }
}
