package edu.hillel.homework.lesson25.server.handler.util;

import java.util.concurrent.atomic.AtomicInteger;

public class UserNameGenerator {

    private final int maxClientRotateNumber;
    private final AtomicInteger counter = new AtomicInteger(0);

    public UserNameGenerator(int maxClientRotateNumber) {
        this.maxClientRotateNumber = maxClientRotateNumber;
    }

    public String getNextUserName() {
        if (counter.get() == maxClientRotateNumber) {
            counter.set(0);
        }
        return "Client-" + counter.incrementAndGet();
    }
}
