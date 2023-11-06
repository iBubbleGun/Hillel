package edu.hillel.homework.lesson25.server;

import edu.hillel.homework.lesson25.server.handler.ClientHandler;
import edu.hillel.homework.lesson25.server.handler.User;
import edu.hillel.homework.lesson25.server.handler.util.UserNameGenerator;
import edu.hillel.homework.lesson25.server.managers.ServerSocketManager;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private final List<User> clients = new ArrayList<>();
    private final UserNameGenerator userNameGenerator = new UserNameGenerator(1_000_000);
    private final ServerSocketManager socketManager;

    public Server(String address, int port) {
        this.socketManager = new ServerSocketManager(address, port);
    }

    public void start() {
        try (ServerSocket server = socketManager.getSocket()) {
            System.out.printf("[INFO] The server has started successfully and is waiting for connections: %s:%s%n",
                    server.getInetAddress(), server.getLocalPort());

            while (!server.isClosed()) {
                Socket clientSocket = server.accept();

                User user = new User(userNameGenerator, clientSocket);
                System.out.println("[INFO] [" + user.getConnectedTime() + "] \"" + user.getName() + "\" connected.");

                synchronized (clients) {
                    clients.add(user);
                }
                new Thread(new ClientHandler(user, this), user.getName()).start();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to start server.", e);
        }
    }

    public void broadcastMessage(String message, User user) {
        synchronized (clients) {
            clients.stream()
                    .filter(client -> !client.equals(user))
                    .forEach(client -> client.getClientWriter().println(message));
        }
    }

    public void removeClient(@NotNull User user) {
        final String message = "[" + new Timestamp(System.currentTimeMillis()) + "] \"" +
                user.getName() + "\" has been disconnected.";
        synchronized (clients) {
            clients.remove(user);
        }
        System.out.println(message);
        broadcastMessage(message, user);
    }
}
