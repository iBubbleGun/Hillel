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

    public String getCatName() {
        return super.getAnimalName();
    }

    @Override
    public void run(int distance) {
        //
    }
}
