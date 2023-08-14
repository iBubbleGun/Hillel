package edu.hillel.homework.lesson4;

public class Main {
    public static void main(String[] args) {
        Animals dog1 = new Dog("Barbos");
        Animals dog2 = new Dog("Palkan");
        Animals cat = new Cat("Markizza");
        System.out.println("Dog name: " + dog1.getName());
        dog1.run(15);
        System.out.println("Cat name: " + cat.getName());
        cat.run(250);

        System.out.println("Cats: " + Cat.getTotalCatsCount());
        System.out.println("Dogs: " + Dog.getTotalDogsCount());
        System.out.println("Animals: " + Animals.getTotalAnimalsCount());
    }
}
