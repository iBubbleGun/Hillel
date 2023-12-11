package edu.hillel.homework.lesson32;

import edu.hillel.homework.lesson32.coffee.CoffeeOrderBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        final CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Tymur");
        coffeeOrderBoard.add("Oleg");
        coffeeOrderBoard.add("Colya");
        coffeeOrderBoard.add("Kateryna");
        coffeeOrderBoard.add("Vasya");
        coffeeOrderBoard.add("Olya");
        coffeeOrderBoard.add("Nina");
        coffeeOrderBoard.add("Bob");
        coffeeOrderBoard.add("Robert");
        coffeeOrderBoard.add("Antony");
        coffeeOrderBoard.add("Larisa");
        coffeeOrderBoard.draw();
        System.out.println();

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();
        System.out.println();

        coffeeOrderBoard.add("Yaroslav");
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.draw();
        System.out.println();

        coffeeOrderBoard.deliver(5);
        coffeeOrderBoard.deliver(7);
        coffeeOrderBoard.deliver(12);
        coffeeOrderBoard.draw();
        System.out.println();

        coffeeOrderBoard.add("Yaroslav");
        coffeeOrderBoard.add("Misha");
        coffeeOrderBoard.draw();
        System.out.println();

        coffeeOrderBoard.deliver(12); // Order can't be delivered because order number doesn't exist.
        System.out.println();

        LOG.info("Total number of accepted orders for this moment: " + coffeeOrderBoard.getCurrentTotalOrdersCounter());
    }
}
