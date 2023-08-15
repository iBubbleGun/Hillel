package edu.hillel.homework.lesson4;

public class Main {
    public static void main(String[] args) {
        Animals dog1 = new Dog("Barbos");
        Animals dog2 = new Dog("Frank");
        Animals dog3 = new Dog("Chakkie");
        Animals dog4 = new Dog("Black");


        Animals cat1 = new Cat("Fluffy");
        Animals cat2 = new Cat("Tosha");
        Animals cat3 = new Cat("Kote");
        Animals cat4 = new Cat("Asya");
        Animals cat5 = new Cat("Sima");

        dog1.run(15);
        dog2.run(150);
        dog3.run(499);
        dog4.run(600);

        dog1.swim(5);
        dog2.swim(2);
        dog3.swim(10);
        dog4.swim(15);

        System.out.println();

        cat1.run(100);
        cat2.run(200);
        cat3.run(250);
        cat4.run(95);
        cat5.run(150);

        cat1.swim(2);
        cat2.swim(10);

        System.out.println();
        System.out.println("Totally we have " + Cat.getTotalCatsCount() + " cats.");
        System.out.println("Totally we have " + Dog.getTotalDogsCount() + " dogs.");
        System.out.println("Totally we have " + Animals.getTotalAnimalsCount() + " animals.");
    }
}
