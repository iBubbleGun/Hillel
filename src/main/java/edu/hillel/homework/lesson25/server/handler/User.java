package edu.hillel.homework.lesson25.server.handler;

import edu.hillel.homework.lesson25.server.handler.util.UserNameGenerator;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private final String name;
    private final Timestamp connectedTime;
    private final Socket clientSocket;
    private final PrintWriter clientWriter;

    public String getName() {
        return name;
    }

    public Timestamp getConnectedTime() {
        return connectedTime;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public PrintWriter getClientWriter() {
        return clientWriter;
    }

    public User(@NotNull UserNameGenerator userNameGenerator, @NotNull Socket clientSocket) throws IOException {
        this.name = userNameGenerator.getNextUserName();
        this.connectedTime = new Timestamp(System.currentTimeMillis());
        this.clientSocket = clientSocket;
        this.clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(connectedTime, user.connectedTime) &&
                Objects.equals(clientSocket, user.clientSocket) &&
                Objects.equals(clientWriter, user.clientWriter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, connectedTime, clientSocket, clientWriter);
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", connectedTime=" + connectedTime +
                ", clientSocket=" + clientSocket +
                ", clientWriter=" + clientWriter +
                "}";
    }
}
