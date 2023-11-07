package edu.hillel.homework.lesson25.client;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client("localhost", 7777);
        client.start();
    }
}
