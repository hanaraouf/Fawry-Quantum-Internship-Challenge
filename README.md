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
<img width="638" alt="Screenshot 2025-07-08 at 9 51 07 PM" src="https://github.com/user-attachments/assets/2b993bf3-1c4a-4e14-b7ba-25e87bebe20f" />

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
<img width="640" alt="Screenshot 2025-07-08 at 9 54 08 PM" src="https://github.com/user-attachments/assets/a9a4b1cb-0e30-4306-88b6-4802b0e9dbfa" />
---

## Case 2: Shippable, Non-Expirable Product

```java
Customer customer = new Customer("Test Customer", 6000);
abstract class SampleShippableOnly extends ShippableProduct {
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

<img width="597" alt="Screenshot 2025-07-08 at 9 56 38 PM" src="https://github.com/user-attachments/assets/892c8a9f-0e5e-455c-bb42-936b0d50d7d5" />

---

## Case 3: Non-Shippable, Non-Expirable Product

```java
Customer customer = new Customer("Test Customer", 500);
abstract class SampleBasicProduct extends AbstractProduct {
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
<img width="597" alt="Screenshot 2025-07-08 at 9 59 01 PM" src="https://github.com/user-attachments/assets/bffaf9ed-cca7-4877-b877-df49c9af85e0" />

---

## ℹ️ Notes

* Shipping fee is a flat 30 EGP if there's any shippable item
* Expired items are blocked before checkout
* Customer must have enough balance to proceed
