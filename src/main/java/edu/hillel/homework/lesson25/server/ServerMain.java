package edu.hillel.homework.lesson25.server;

public class ServerMain {

    public static void main(String[] args) {

        Server server = new Server("localhost", 7777);
        server.start();
    }
}
