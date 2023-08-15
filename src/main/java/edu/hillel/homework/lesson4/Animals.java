package edu.hillel.homework.lesson4;

public class Animals {

    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        System.out.println("The animal " + getName() + " ran " + distance + " meters.");
    }

    public void swim(int distance) {
        System.out.println("The animal " + getName() + " swam " + distance + " meters.");
    }
}
