package com.mycompany.e.commerce;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// Interface used for shipping logic, must provide weight and name.
public interface ShippableItem {
    String getName() ;
    double getWeight() ;
}
