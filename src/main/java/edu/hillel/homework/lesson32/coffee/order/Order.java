package edu.hillel.homework.lesson32.coffee.order;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber && Objects.equals(customerName, order.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, customerName);
    }

    @Override
    public String toString() {
        return orderNumber + " | " + customerName;
    }
}
