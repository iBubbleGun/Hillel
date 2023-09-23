package edu.hillel.homework.lesson14.coffee.order;

public class Order {

    private final int orderNumber;
    private final String customerName;

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Order(int orderNumber, String customerName) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return orderNumber + " | " + customerName;
    }
}
