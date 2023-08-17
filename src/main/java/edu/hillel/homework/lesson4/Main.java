package edu.hillel.homework.lesson4;

import edu.hillel.homework.lesson4.cats.Cat;
import edu.hillel.homework.lesson4.dogs.Dog;

public class Main {
    public static void main(String[] args) {
        Counter counter = new AnimalCounter();

        Animals dog1 = new Dog("Barbos", counter);
        Animals dog2 = new Dog("Frank", counter);
        Animals dog3 = new Dog("Chakkie", counter);
        Animals dog4 = new Dog("Black", counter);

        Animals cat1 = new Cat("Fluffy", counter);
        Animals cat2 = new Cat("Tosha", counter);
        Animals cat3 = new Cat("Kote", counter);
        Animals cat4 = new Cat("Asya", counter);
        Animals cat5 = new Cat("Sima", counter);

        dog1.run(15);
        dog2.run(150);
        dog3.run(499);
        dog4.run(600);

        dog1.swim(5);
        dog2.swim(2);
        dog3.swim(10);
        dog4.swim(15);

        ((Dog) dog1).sayWuf();
        ((Dog) dog3).sayWuf();

        System.out.println();

        cat1.run(100);
        cat2.run(200);
        cat3.run(250);
        cat4.run(95);
        cat5.run(150);

        cat1.swim(2);
        cat2.swim(10);

        ((Cat) cat1).sayMeow();
        ((Cat) cat4).sayMeow();

        System.out.println();
        System.out.println("Totally we have " + counter.getTotalCatsCount() + " cats.");
        System.out.println("Totally we have " + counter.getTotalDogsCount() + " dogs.");
        System.out.println("Totally we have " + counter.getTotalAnimalsCount() + " animals.");
    }
}
