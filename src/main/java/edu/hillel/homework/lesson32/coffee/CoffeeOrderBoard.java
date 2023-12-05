package edu.hillel.homework.lesson32.coffee;

import edu.hillel.homework.lesson32.coffee.order.Order;
import edu.hillel.homework.lesson32.coffee.order.controller.OrderNumberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {

    private static final Logger LOG = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final OrderNumberController orderNumberController;
    private final Queue<Order> orderQueue;

    public CoffeeOrderBoard() {
        this.orderNumberController = new OrderNumberController();
        this.orderQueue = new LinkedList<>();
    }

    public void add(String customerName) {
        LOG.trace("Call add(String customerName) method. customerName value passed=" + customerName);
        int nextOrderNumber = orderNumberController.getNextOrderNumber();
        if (nextOrderNumber > 0) {
            final Order order = new Order(nextOrderNumber, customerName);
            orderQueue.offer(order);
            LOG.info("Added new order #" + order.getOrderNumber() + " for " + order.getCustomerName() + ".");
        } else {
            LOG.error("A new order cannot be added because the queue is already full.");
        }
    }

    public int getCurrentTotalOrdersCounter() {
        LOG.trace("Call getCurrentTotalOrdersCounter() method.");
        final int currentTotalOrdersCounter = orderNumberController.getTotalOrdersCounterValue();
        LOG.debug("getCurrentTotalOrdersCounter() method returned totalOrdersCounterValue=" + currentTotalOrdersCounter);
        return currentTotalOrdersCounter;
    }

    public void resetCurrentTotalOrdersCounter() {
        LOG.trace("Call resetCurrentTotalOrdersCounter() method.");
        orderNumberController.resetTotalOrdersCounter();
        LOG.debug("Reset total orders counter.");
    }

    public void deliver() {
        LOG.trace("Call deliver() method.");
        if (!orderQueue.isEmpty()) {
            final Order order = orderQueue.poll();
            LOG.trace("Poll from orderQueue order: " + order);
            orderNumberController.removeDeliveredOrderNumber(order.getOrderNumber());
            LOG.info("Delivered order #" + order.getOrderNumber() + " for " + order.getCustomerName() + ".");
        } else {
            LOG.warn("The order sheet is empty now!");
        }
    }

    public void deliver(int targetOrderNumber) {
        LOG.trace("Call deliver(int targetOrderNumber) method. targetOrderNumber value passed=" + targetOrderNumber);
        for (Order order : orderQueue) {
            if (order.getOrderNumber() == targetOrderNumber) {
                orderQueue.remove(order);
                LOG.trace("Remove from orderQueue order: " + order);
                orderNumberController.removeDeliveredOrderNumber(targetOrderNumber);
                LOG.info("Delivered order #" + order.getOrderNumber() + " for " + order.getCustomerName() + ".");
                return;
            }
        }
        LOG.error("Sorry, the order number \"" + targetOrderNumber + "\" doesn't exist!");
    }

    public void draw() {
        LOG.trace("Call draw() method.");
        LOG.info("Remaining orders in queue:");
        LOG.info("Num | Name");
        if (!orderQueue.isEmpty()) {
            orderQueue.stream()
                    .map(String::valueOf)
                    .forEach(LOG::info);
        } else {
            LOG.info("-- | --");
        }
    }
}
