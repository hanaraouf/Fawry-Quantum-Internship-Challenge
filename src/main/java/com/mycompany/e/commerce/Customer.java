package com.mycompany.e.commerce;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hanaraouf
 */
// Represents a user with a balance to make purchases.
public class Customer {
    private String Name;
    private double balance;
    
    public Customer(String Name,double balance) {
        this.Name=Name;
        this.balance=balance;
    }
    
    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }
    
    public double getbalance() {return balance;}
    
    // Deducts the amount if sufficient funds are available.
    public void pay(double amount) {
    if (!hasSufficientBalance(amount)) {
        System.out.println("Error: Insufficient balance");
        return;
    }
    balance -= amount;
  }
}
