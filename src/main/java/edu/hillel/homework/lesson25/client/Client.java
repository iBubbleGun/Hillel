package edu.hillel.homework.lesson25.client;

import edu.hillel.homework.lesson25.client.managers.ClientSocketManager;
import edu.hillel.homework.lesson25.client.services.FileService;
import edu.hillel.homework.lesson25.client.services.impl.FileSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Client {

    private final ClientSocketManager clientSocketManager;
    private final FileService fileService;

    public Client(String address, int port) {
        this.clientSocketManager = new ClientSocketManager(address, port);
        this.fileService = new FileSender();
    }

    public void start() {
        try (Socket socket = clientSocketManager.getSocket();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.printf("The connection to the server %s:%s was successfully established.%n", socket.getInetAddress(), socket.getPort());

            new Thread(() -> {
                try {
                    String serverResponse;
                    while ((serverResponse = in.readLine()) != null) {
                        System.out.println("[SERVER]: ".concat(serverResponse));
                    }
                } catch (IOException e) {
                    //throw new RuntimeException("Error reading data from server.", e);
                }
            }, "Client").start();

            wait(100);
            System.out.println("""
                    Available server commands:
                    -file path\\to\\your\\file.name - to upload your file in to the server.
                    -exit - to disconnect from the server.
                    -date - print local server date.
                    -time - print local server time.
                    Type your command:""");

            String userInput;
            outer:
            while (true) {
                userInput = consoleInput.readLine();
                if (!userInput.isEmpty()) {
                    out.println(userInput);
                    wait(50);
                    if (isServerCommand(userInput)) {
                        String command = parseCommand(userInput);
                        String argument = parseArgument(userInput);
                        switch (command) {
                            case "EXIT": {
                                wait(100);
                                break outer;
                            }
                            case "FILE": {
                                fileService.send(new File(argument), socket);
                                wait(100);
                                break outer;
                            }
                            case "DATE", "TIME": {
                                break;
                            }
                            default: {
                                throw new RuntimeException("No such server command: " + command);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to connect to the server.", e);
        }
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isServerCommand(String str) {
        return Arrays.stream(Commands.values())
                .anyMatch(c -> c.name().equals(parseCommand(str)));
    }

    private @NotNull String parseCommand(@NotNull String str) {
        if (str.equalsIgnoreCase("-" + Commands.EXIT.name()) ||
                str.equalsIgnoreCase("-" + Commands.DATE.name()) ||
                str.equalsIgnoreCase("-" + Commands.TIME.name())) {
            return str.replaceAll("-", "").toUpperCase();
        }
        String[] parts = str.split(" ");
        if (parts.length == 2 && parts[0].startsWith("-")) {
            return parts[0]
                    .replaceAll("-", "")
                    .toUpperCase();
        }
        return str;
    }

    @Contract(pure = true)
    private @NotNull String parseArgument(@NotNull String str) {
        String[] parts = str.split(" ");
        if (parts.length == 2) {
            return parts[1];
        }
        return str;
    }
}
