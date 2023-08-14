package edu.hillel.homework.lesson4;

public class Cat extends Animals {

    private static int totalCatsCount = 0;

    public Cat(String catName) {
        super(catName);
        totalCatsCount++;
    }

    public static int getTotalCatsCount() {
        return totalCatsCount;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Котики не можуть пробігти більше 200 метрів!");
            return;
        }
        System.out.println("Котик " + super.getName() + " пробіг " + distance + " метрів.");
    }
}
