package edu.hillel.homework.lesson14;

import edu.hillel.homework.lesson14.coffee.CoffeeOrderBoard;

public class Main {

    public static void main(String[] args) {

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

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

        coffeeOrderBoard.deliver(12); // order can't be delivered. Order number doesn't exist.
        System.out.println();

        System.out.println("Total number of accepted orders for this moment: " +
                coffeeOrderBoard.getCurrentTotalOrdersCounter()
        );
    }
}
