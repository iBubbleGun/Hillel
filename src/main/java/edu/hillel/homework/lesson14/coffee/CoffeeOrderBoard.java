package edu.hillel.homework.lesson14.coffee;

import edu.hillel.homework.lesson14.coffee.order.Order;
import edu.hillel.homework.lesson14.coffee.order.controller.OrderNumberController;
import edu.hillel.homework.lesson14.coffee.order.messages.OrderMessage;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {

    private final OrderNumberController orderNumberController;
    private final OrderMessage orderMessage;
    private final Queue<Order> orderQueue;

    /**
     * Initial constructor
     */
    public CoffeeOrderBoard() {
        this.orderNumberController = new OrderNumberController();
        this.orderMessage = new OrderMessage();
        this.orderQueue = new LinkedList<>();
    }

    /**
     * The method adds a new order to the queue (FIFO principle).
     *
     * @param customerName - the name of customer
     */
    public void add(String customerName) {
        int nextOrderNumber = orderNumberController.getNextOrderNumber();
        if (nextOrderNumber > 0) {
            Order order = new Order(nextOrderNumber, customerName);
            orderQueue.offer(order);
            orderMessage.addedNewOrder(order);
        } else {
            orderMessage.orderSheetIsFull();
        }
    }

    /**
     * @return Integer type - the current value of the counter for the total number of accepted orders.
     */
    public int getCurrentTotalOrdersCounter() {
        return orderNumberController.getTotalOrdersCounterValue();
    }

    /**
     * The method resets the counter of the total number of accepted orders.
     */
    public void resetCurrentTotalOrdersCounter() {
        orderNumberController.resetTotalOrdersCounter();
    }

    /**
     * The method fulfills the order in order of queue following the FIFO principle
     */
    public void deliver() {
        if (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            orderNumberController.removeDeliveredOrderNumber(order.getOrderNumber());
            orderMessage.orderDelivered(order);
        } else {
            orderMessage.orderSheetIsEmpty();
        }
    }

    /**
     * The method fulfills the order on demand, not in queue order, but according to the order number.
     *
     * @param targetOrderNumber - order number, which must be delivered now (not in queue order).
     */
    public void deliver(int targetOrderNumber) {
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == targetOrderNumber) {
                orderQueue.remove(order);
                orderNumberController.removeDeliveredOrderNumber(targetOrderNumber);
                orderMessage.orderDelivered(order);
                return;
            }
        }
        orderMessage.orderNumberDoesNotExist(targetOrderNumber);
    }

    /**
     * The method displays a sequence of orders to the console in strict order
     * of the order issuance queue from the earliest to the latest.
     */
    public void draw() {
        orderMessage.remainingOrdersInQueue();
        if (!orderQueue.isEmpty()) {
            for (Order order : orderQueue) {
                System.out.println(order);
            }
        } else {
            orderMessage.emptyOrderSheet();
        }
    }
}
