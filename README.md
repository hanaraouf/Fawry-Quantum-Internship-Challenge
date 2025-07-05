# E-Commerce System (Java)

This project simulates an e-commerce system that supports:
* Product types: expirable, shippable, non-expirable, non-shippable
* Cart management
* Shipping fee calculation
* Balance validation and receipt generation

## Main Case: Successful Checkout

*Note: Each test case uses a fresh `Customer` object with enough balance to ensure accurate results.*

```java
Product cheese = new SampleProduct("Cheese", 100.0, 10, false, 200);
Product biscuits = new SampleProduct("Biscuits", 150.0, 5, false, 700);
Customer customer = new Customer("Test Customer", 500);
Cart cart = new Cart();
cart.add(cheese, 2);
cart.add(biscuits, 1);
CheckoutService checkout = new CheckoutService(new ShippingServices(), new ShippingFeeCalculator());
checkout.checkout(customer, cart);
```
**Products:**
* Cheese (expirable & shippable)
* Biscuits (expirable & shippable)

**Customer Balance:** 500

### Output:
```
** shipment notice **
2xCheese 400g
1xBiscuits 700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese    200
1x Biscuits  150
---
Subtotal    350
Shipping    30
Amount      380
Customer balance: 120
```

---

## Case 1: Expired Product

```java
Customer customer = new Customer("Test Customer", 500);
Product oldCheese = new SampleProduct("Old Cheese", 90.0, 3, true, 300);
Cart expiredCart = new Cart();
expiredCart.add(oldCheese, 1);
checkout.checkout(customer, expiredCart);
```

**Product:** Old Cheese (expired)

### Output:
```
Error: Old Cheese is expired
```
---

## Case 2: Shippable, Non-Expirable Product

```java
Customer customer = new Customer("Test Customer", 6000);
class SampleShippableOnly extends ShippableProduct {
    public SampleShippableOnly(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);
    }
}
Product tv = new SampleShippableOnly("TV", 5000.0, 1, 8000);
Cart shippableCart = new Cart();
shippableCart.add(tv, 1);
checkout.checkout(customer, shippableCart);
```

**Product:** TV (shippable only)

### Output:
```
** shipment notice **
1xTV 8000g
Total package weight 8.0kg

** Checkout receipt **
1x TV    5000
---
Subtotal    5000
Shipping    30
Amount      5030
Error: Insufficient balance
```
(*if balance < 5030*)

---

## Case 3: Non-Shippable, Non-Expirable Product

```java
Customer customer = new Customer("Test Customer", 500);
class SampleBasicProduct extends AbstractProduct {
    public SampleBasicProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
}
Product scratchCard = new SampleBasicProduct("Scratch Card", 50.0, 5);
Cart digitalCart = new Cart();
digitalCart.add(scratchCard, 2);
checkout.checkout(customer, digitalCart);
```

**Product:** Scratch Card (digital item)

### Output:
```
** Checkout receipt **
2x Scratch Card    100
---
Subtotal    100
Shipping    0
Amount      100
Customer balance: 20
```
---

## ℹ️ Notes

* Shipping fee is a flat 30 EGP if there's any shippable item
* Expired items are blocked before checkout
* Customer must have enough balance to proceed
