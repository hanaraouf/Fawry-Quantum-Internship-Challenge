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
// Prints shipping details like how many items to ship and their weights.
public class ShippingServices {
    public void ship(List<ShippableItem> items) {
        if (items.isEmpty()) return;
        System.out.println("** shipment notice **");
        double totalweight = 0.0;
        
        for(int i=0; i<items.size(); i++) {
            ShippableItem current = items.get(i);
            String name = current.getName();
            double weight = current.getWeight();
            
            boolean alreadyPrinted = false;
            for(int j=0;j<i;j++) {
                if (items.get(j).getName().equals(name)) {
                    alreadyPrinted = true ;
                    break;
                }
            }
            if (alreadyPrinted) continue;
            
            int count=0;
            for(ShippableItem item : items) {
                if(item.getName().equals(name)) {
                    count ++;
                }
            }
          double groupWeight = count * weight; 
          System.out.println(count+"x"+name+" "+(int)groupWeight+"g");
          totalweight += groupWeight;
        }
        double totalWeightKg = ((int)(totalweight / 100)) / 10.0;
        System.out.println("Total package weight " + totalWeightKg + "kg\n");
    }
    
}
