# Java E-Commerce Console Application 
___
Welcome to my E-Commerce Console Application Project !
This project is a Java console application that simulates an e-commerce website with different functionalities for both Customers and Admins.
It has many features such as: user authentication, product management, shopping cart, order management, etc.
# Table of Contents
1. [Features](#features)
2. [How to use](#how-to-use)
3. [Design Decesions](#design-decisions)
4. [class Diagram](#class-diagram)
5. [the two optional features](#the-two-optional-features)
6. [the design patterns](#the-design-patterns)

## Features
___
* User authentication System
* Product management
* Shopping cart
* Order management
* Discounts and coupons management
* Payment system
* Dynamic product filtering
* Review and rating system
* **Admins** :
    * Add a new product
    * Add a new product category(if the product category doesn't exist)
    * remove a product
    * update a product
    * see the stock on a product
    * see the low stock products
    * see the products that are out of stock
    * put a product on sale
    * put a category of products on sale
    * put all the products on sale
    * search for a product :
        * By ID 
        * By name (partial or full name case-sensitive) and can be further filtered
        * By category
        * By price range
        * By quantity range
        * By brand
        * or any combination of the above
    * **Note** : Admins cannot register . They must be created in the main method as objects, but before using the system admins must log in first . 
The search for a product is case-sensitive . Admins are the only ones who can manage the products and the product categories (through the product manager class).
* **Users** :
    * Register as a new user
    * Log in as a user
    * Log out
    * See the list of products
    * **Search for a product** :
        * By ID 
        * By name (partial or full name case-sensitive) and can be further filtered
        * By category
        * By price range
        * By quantity range
        * By brand
        * or any combination of the above
    * Add a product to the shopping cart
    * Remove a product from the shopping cart
    * See the shopping cart
    * Add a coupon code to the shopping cart
    * See the discount applied to the shopping cart
    * Change their info
    * See their info
    * See their orders
    * See their reviews
    * Add a review and a rating to a product
    * See the reviews and ratings of a product
    * Pay the order
    * See the payment method
* **Note** : the search for a product is case-sensitive . The orders of a user are created when he pays for his shopping cart . once a user object created it's added to the authentication system class .
  
## How to use
___
1. Clone the repository
2. Open the project in your IDE
3. You could either :
* Run the main method in the Main class with the methods that are already there to test the application .
* Or you could create your own methods and test the application .
* **Note** : If you want to test the application with your own methods , you should create a new object of the class Product Manager ,a new object of the class AuthenticationSystem and AT LEAST ONE admin if you want to log in as an admin (you can create as many admins as you want) .
4. Call the log in method in the AuthenticationSystem class to log in as an admin or a customer (customers can be registered through the log in menu no need to create them as new objects).
5. You are good to go ! Enjoy !

## Design Decisions
___
* The product manager class is ued to manage the products and the product categories .
* The authentication system class is used to manage the users and the admins .
* The shopping cart class is used to manage the shopping cart of the customers .
* The order manager class is used to manage the orders of the customers .
* The payment system class is used to manage the payment of the orders .
* The review and rating system class is used to manage the reviews and ratings of the products and the customers .
* The discount and coupon manager class is used to manage the discounts and coupons of the products and the customers' orders .
* The product class is used to create new products, but it is as abstract class so that we can create different types of products .

## class Diagram
___
![class diagram](https://github.com/loueysioua/Java-tp/blob/main/E-Commerce/Class%20Diagram.png)

## the two optional features
___
* The first optional feature is the review and rating system .
* The second optional feature is the coupons and discounts system.
1. The review and rating system :
   * the review and rating system is used to manage the reviews and ratings of the products and the customers .
   * every product has a list of reviews and ratings and an average rating .
   * every customer has a list of his reviews  .
   * the customer can add a review and a rating to a product , the review will be added to the list of reviews of the product and the average rating of the product will be updated .
   * the customer can see the reviews and ratings of a product .
   * the customer can also see all his reviews .
2. The coupons and discounts :
    * the coupons and discounts system is used to manage the discounts and coupons of the products and the customers' orders .
    * there are two types of discounts : the percentage discount and the fixed discount .
    * the class CouponsAndDiscountsManager is used for the management of the codes . It contains a list of codes that represent every coupon .
    * admins can add a new coupon to the list of codes .
    * admins can also add discounts on either a product or a specific category of products or even on all the products .
        * **Note** : for future updates , admins will be able to add discounts in events (event class not yet created) .
    * if the customer has a coupon code , he can use it to get a discount on his order .
    * the discount will be applied to the total price of the order .
    * the customer can see the discount applied to his order .
    * the customer can also see all his coupons .
    * if the customer uses a coupon code , the code will be added to the customer's list of used coupons . Thus , the customer can't use the same coupon code twice .
    * the customer can't use a coupon code if it is not valid .
         * **Note** : a coupon code is valid if it is in the list of codes and if it is not in the list of used codes of the customer .

## the design patterns
___
The first design pattern is the Singleton design pattern .
1. The Singleton design pattern is used in the AuthenticationSystem class .
    * The AuthenticationSystem class is a Singleton class because we want to have only one instance of this class .
    * The AuthenticationSystem class is used to manage the users and the admins .
    * The AuthenticationSystem class has a list of users and a list of admins .
    * The AuthenticationSystem class has a method to log in as an admin or a customer .
    * The AuthenticationSystem class has a method to register a new customer .
    * The AuthenticationSystem class has a method to check if a user exists .
    * The AuthenticationSystem class has a method to check if an admin exists .
    * The AuthenticationSystem class has a method to check if a user is logged in .
    * The AuthenticationSystem class has a method to check if an admin is logged in .
    * The AuthenticationSystem class has a method to log out .
    * The AuthenticationSystem class has a method to get the list of users .
    * The AuthenticationSystem class has a method to get the list of admins .
    * The AuthenticationSystem class has a method to get the list of logged-in users .
    * The AuthenticationSystem class has a method to get the list of logged-in admins .

The second design pattern is the Strategy design pattern .
2. The Strategy design pattern is used in the PaymentSystem .
   * The PaymentSystem is used to manage the payment of the orders .
   * The PaymentStrat class is an interface that has a method to pay .
   * The CreditCardPayment class has a method to pay with a credit card .
   * The E_dinarPayment class has a method to pay with an E-Dinar card .
   * The OurCardPayment class has a method to pay with the app card .
   * The GiftCard class has a method to pay with a gift card .
   
## Problem Faced
___
I faced a bug in the java input console . In fact, when an int input or float input is expected and when nextInt() or  nextFloat() methods are used , the console skips the next input . I think fixed it in the project , but I'm not sure . If you encounter this bug , please let me know and please don't consider it as a bug in my project . Thank you .
* **Note** : I used the Scanner class to get the input from the user .
# Conclusion
___
This project was a great experience for me . I learned a lot of things , became better at utilizing OOP concepts and I had a lot of fun doing it . I had a lot of other ideas that I wanted to implement, but I didn't have the time to do it due to upcoming exams .
I hope you like it and I hope you find it useful . Thank you for your time .