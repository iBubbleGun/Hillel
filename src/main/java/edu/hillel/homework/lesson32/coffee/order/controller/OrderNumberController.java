package edu.hillel.homework.lesson32.coffee.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class OrderNumberController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderNumberController.class);
    private static final int MAXIMUM_ORDER_NUMBER_ALLOWED = 9999;
    private int currentNumber = 1;
    private final Set<Integer> usedNumbers;
    private int totalOrdersCounterValue;

    public OrderNumberController() {
        this.usedNumbers = new HashSet<>();
    }

    public int getTotalOrdersCounterValue() {
        LOG.trace("Call getTotalOrdersCounterValue() method. " +
                "Current totalOrdersCounterValue=" + totalOrdersCounterValue);
        LOG.debug("getTotalOrdersCounterValue() method returned totalOrdersCounterValue=" + totalOrdersCounterValue);
        return totalOrdersCounterValue;
    }

    /**
     * @return next order number.
     * The method controls the issuance of the order number using the following algorithm:
     * Order numbers range from 1 to MAXIMUM_ORDER_NUMBER_ALLOWED inclusive.
     * The order number for two different orders cannot be repeated in the same instance of the class.
     * The numbers of new orders follow strictly from 1 to MAXIMUM_ORDER_NUMBER_ALLOWED.
     * Moreover, when the next order number becomes equal to MAXIMUM_ORDER_NUMBER_ALLOWED, then the next order,
     * if the total number of unfulfilled orders is less than MAXIMUM_ORDER_NUMBER_ALLOWED,
     * will be numbered 1 and then in ascending order up to MAXIMUM_ORDER_NUMBER_ALLOWED.
     * If orders are not fulfilled, but only new ones are added, then the queue will reach a maximum value of
     * MAXIMUM_ORDER_NUMBER_ALLOWED and the next order will not be added.
     * As orders are completed, order numbers will be removed from the queue. However, for subsequent new orders,
     * numbers will continue to be issued from the last number issued to the highest number up to
     * MAXIMUM_ORDER_NUMBER_ALLOWED, and the new order itself will be queued in order of nature.
     * For example, if the order queue is empty or not completely filled, subsequent orders will be added in
     * numerical order: 1,2,3,4,5...(MAXIMUM_ORDER_NUMBER_ALLOWED - 1),MAXIMUM_ORDER_NUMBER_ALLOWED.
     * Orders will be processed on a first-come, first-out basis in exactly the same order:
     * 1,2,3,4,5...(MAXIMUM_ORDER_NUMBER_ALLOWED - 1),MAXIMUM_ORDER_NUMBER_ALLOWED (the FIFO principle is observed).
     * If orders from the queue are not processed in order of priority (first in, first out),
     * but according to the order number in the queue, then for subsequent new orders the issuance of numbers will
     * continue from the last issued to the maximum value of MAXIMUM_ORDER_NUMBER_ALLOWED.
     * For example, we have a natural order queue with order sequence numbers 1,2,3,4,5,6,7,8 and
     * order issuance order 1,2,3,4,5,6,7,8. When issuing order #5 and #6 and #7 from the queue,
     * the sequence of order numbers will become 1,2,3,4,8 and the sequence of issuing orders will be 1,2,3,4,8.
     * Now, if you add a new orders, it will have a serial number of 9 and next 10
     * and a natural queue for issuing orders and will look like this: 1,2,3,4,8,9,10...
     * Thus, the FIFO principle will be observed in the same way as the natural order of order numbers.
     */
    public int getNextOrderNumber() {
        LOG.trace("Call getNextOrderNumber() method.");
        if (usedNumbers.size() == MAXIMUM_ORDER_NUMBER_ALLOWED) {
            LOG.trace("usedNumbers.size() == MAXIMUM_ORDER_NUMBER_ALLOWED");
            return -1;
        }
        while (usedNumbers.contains(currentNumber)) {
            this.currentNumber++;
            LOG.trace("Increased currentNumber. Now currentNumber value=" + currentNumber);
            if (currentNumber > MAXIMUM_ORDER_NUMBER_ALLOWED) {
                LOG.trace("currentNumber > MAXIMUM_ORDER_NUMBER_ALLOWED");
                currentNumber = 1;
            }
        }
        usedNumbers.add(currentNumber);
        LOG.trace("currentNumber=" + currentNumber + " added to usedNumbers.");
        this.totalOrdersCounterValue++;
        LOG.trace("Increased totalOrdersCounterValue. Current value=" + totalOrdersCounterValue);
        LOG.debug("getNextOrderNumber() method returned currentNumber=" + currentNumber);
        return currentNumber;
    }

    public void removeDeliveredOrderNumber(int orderNumber) {
        LOG.trace("Call removeDeliveredOrderNumber(int orderNumber) method. " +
                "orderNumber value passed: " + orderNumber);
        usedNumbers.remove(orderNumber);
        LOG.debug("Remove delivered order number \"" + orderNumber + "\" from usedNumbers.");
    }

    public void resetTotalOrdersCounter() {
        LOG.trace("Call resetTotalOrdersCounter() method.");
        this.totalOrdersCounterValue = 0;
        LOG.debug("Reset total orders counter.");
    }
}
