package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Product> cart = new ArrayList<>();
    private static final String FILE_NAME = "Products.csv";

    public static void main(String[] args) {
        loadProducts(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;


        while (running) {
            System.out.println(" ");
            System.out.println("Welcome to the Store!");
            System.out.println(" ");
            System.out.println("Please Choose an Option: ");
            System.out.println(" ");
            System.out.println("Press 'D' to Display All Available Products");
            System.out.println(" ");
            System.out.println("Press 'A' to Add Items to Your Cart");
            System.out.println(" ");
            System.out.println("Press 'S' to View Your Shopping Cart");
            System.out.println(" ");
            System.out.println("Press 'X' to Exit the Store");
            System.out.println(" ");

            String input = scanner.nextLine().trim();

            switch  (input.toUpperCase()) {
                case "A":
                    System.out.println(" ");
                    System.out.printf("%-12s | %-35s | %-10s\n", "ID", "Product Name", "Price");
                    System.out.println(" ");
                    for (Product shoppingProducts : products)
                        System.out.println(shoppingProducts);
                    addItemsToCart();
                    break;
                case "D":
                    displayProducts();
                    break;
                case "S":
                    displayShoppingCart();
                    break;
                case "X":
                    System.out.println(" ");
                    System.out.println("Thank You For Shopping, Goodbye!");
                    running = false;
                    break;
            }

        }
    }

    public static void loadProducts(String fileName) {

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String id = parts[0];
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product shoppingProducts = new Product(id, productName, price);
                products.add(shoppingProducts);

            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error, File Not Found!");
        }
    }



    public static void displayProducts() {

        System.out.println(" ");
        System.out.println("Here Are The Available Products:");
        System.out.println(" ");
        System.out.printf("%-12s | %-35s | %-10s", "ID", "Product Name", "Price");
        System.out.println(" ");
        for (Product shoppingProduct : products) {
            System.out.println(" ");
            System.out.println(shoppingProduct);
        }
    }

    public static void displayShoppingCart() {

        System.out.println(" ");
        System.out.println("Here is Your Current Cart:");

        if (cart.isEmpty()) {
            System.out.println(" ");
            System.out.println("Your Cart is Empty!");

        } else {
            double totalPrice = 0.0;

            for (Product cartItem : cart) {
                System.out.println(" ");
                System.out.println(cartItem);
                totalPrice += cartItem.getPrice();
            }

                System.out.println(" ");
                System.out.println("Your Cart Total is: $" + totalPrice);
            }
    }

        public static void addItemsToCart() {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Enter the ID of the Product You Want to Add to Your Cart");
            System.out.println(" ");
            String iD = scanner.nextLine().trim();

            for (Product product : products) {
                if (product.getid().equalsIgnoreCase(iD)) {
                    System.out.println(" ");
                    System.out.println("Added " + product.getProductName() + " To the Cart!");
                    cart.add(product);
                    System.out.println(" ");
                    System.out.println(product);

                    double totalPrice = 0.0;
                    for (Product cartItem : cart) {
                        totalPrice += cartItem.getPrice();
                    }

                    System.out.println("Total Price of Your Shopping Cart is: $" + totalPrice);
                    return;
                }
            }
            System.out.println("ID of Product Not Found...");

        }

        private static void CheckOut () {

        }
    }





