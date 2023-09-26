package edu.hillel.homework.lesson15.stock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Product {

    private final String type;
    private double price;
    private boolean discountApplicable;
    private LocalDateTime dateAdded;
    private int productId;

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscountApplicable() {
        return discountApplicable;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public int getProductId() {
        return productId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean discountApplicable) {
        this.type = type;
        this.price = price;
        this.discountApplicable = discountApplicable;
        this.dateAdded = LocalDateTime.now();
        // Generating a unique identifier using a hash function
        this.productId = Math.abs((new Random().nextInt(999_999) +
                type +
                price +
                dateAdded +
                System.currentTimeMillis())
                .hashCode()
        );
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=\"" + type + "\", " +
                "price=\"" + price + " UAH\", " +
                "discountApplicable=\"" + discountApplicable + "\", " +
                "dateAdded=\"" + dateAdded.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\", " +
                "productId=\"" + productId + "\"" +
                "}";
    }
}
