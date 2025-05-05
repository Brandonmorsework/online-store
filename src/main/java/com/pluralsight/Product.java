package com.pluralsight;

public class Product {

    private String iD;
    private String productName;
    private double price;

    public Product(String iD, String productName, double price) {
        this.iD = iD;
        this.productName = productName;
        this.price = price;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
