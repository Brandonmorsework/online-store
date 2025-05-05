package com.pluralsight;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private static ArrayList<Product> products = new ArrayList<>();
    private static final String FILE_NAME = "Products.csv";

    public static void main(String[] args) {
        loadProducts(FILE_NAME);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
    }




    public static void loadProducts(String fileName) {

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String iD = parts[0];
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(iD, productName, price);
                products.add(product);

            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error, File Not Found!");
        }
    }
}
