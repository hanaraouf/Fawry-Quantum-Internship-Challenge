package com.mycompany.e.commerce;


import com.mycompany.e.commerce.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// Represents a product added to the cart and its quantity.
public class CartItem {
    private Product Product;
    private int quantity;
    
    public CartItem(Product Product,int quantity){
        this.Product=Product;
        this.quantity=quantity;
    }
    public Product getProduct() {return Product;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity=quantity;} 
}
