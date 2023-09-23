package edu.hillel.homework.lesson14.coffee.order.messages;

import edu.hillel.homework.lesson14.coffee.order.Order;
import org.jetbrains.annotations.NotNull;

public class OrderMessage {

    public void addedNewOrder(@NotNull Order order) {
        System.out.println(
                "Added new order #" + order.getOrderNumber() +
                        " for " + order.getCustomerName() + "."
        );
    }

    public void orderDelivered(Order order) {
        System.out.println(
                "Delivered order #" + order.getOrderNumber() +
                        " for " + order.getCustomerName() + "."
        );
    }

    public void orderNumberDoesNotExist(int orderNumber) {
        System.out.println(
                "Sorry, the order number \"" + orderNumber + "\" doesn't exist."
        );
    }

    public void orderSheetIsEmpty() {
        System.out.println("The order sheet is empty now.");
    }

    public void orderSheetIsFull() {
        System.out.println("A new order cannot be added because the queue is already full.");
    }

    public void emptyOrderSheet() {
        System.out.println("-- | --");
    }

    public void remainingOrdersInQueue() {
        System.out.println("Remaining orders in queue:\nNum | Name");
    }
}
