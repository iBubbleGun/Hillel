package edu.hillel.homework.lesson25.server.handler;

import edu.hillel.homework.lesson25.server.Commands;
import edu.hillel.homework.lesson25.server.Server;
import edu.hillel.homework.lesson25.server.handler.services.FileService;
import edu.hillel.homework.lesson25.server.handler.services.impl.FileSaver;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ClientHandler implements Runnable {

    private final User user;
    private final Server server;

    public ClientHandler(@NotNull User user, Server server) {
        this.user = user;
        this.server = server;

    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(user.getClientSocket().getInputStream()))) {
            final PrintWriter out = user.getClientWriter();
            final FileService fileService = new FileSaver(user);

            out.println("Welcome!");
            server.broadcastMessage("[" + user.getConnectedTime() + "] \"" + user.getName() + "\" connected.", user);

            String inputLine;
            outer:
            while ((inputLine = in.readLine()) != null) {
                inputLine = inputLine.trim();
                if (isServerCommand(inputLine)) {
                    String command = parseCommand(inputLine);
                    String argument = parseArgument(inputLine);
                    switch (command) {
                        case "EXIT": {
                            user.getClientWriter().println("Successfully disconnected.");
                            break outer;
                        }
                        case "FILE": {
                            fileService.save(new File(argument));
                            user.getClientWriter().println("File uploaded successfully.");
                            break outer;
                        }
                        case "DATE": {
                            user.getClientWriter().println("Server local date now: " +
                                    new SimpleDateFormat("EEE, dd MMMM yyyy")
                                            .format(new Date()));
                            break;
                        }
                        case "TIME": {
                            user.getClientWriter().println("Server local time now: " + getTime());
                            break;
                        }
                        default: {
                            throw new RuntimeException("No such server command: " + command);
                        }
                    }
                } else {
                    out.println("Unknown server command.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create input stream.", e);
        } finally {
            try {
                user.getClientSocket().close();
            } catch (IOException e) {
                //throw new RuntimeException(e);
            }
            server.removeClient(user);
        }
    }

    private @NotNull String getTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss 'GMT'Z");
        return dateFormat.format(currentDate);
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
