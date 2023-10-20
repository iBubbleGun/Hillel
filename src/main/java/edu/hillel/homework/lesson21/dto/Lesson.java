package edu.hillel.homework.lesson21.dto;

import java.sql.Timestamp;

public class Lesson {

    private int id;
    private final String name;
    private final Timestamp updatedAt;
    private final Homework homework;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lesson(String name, Homework homework) {
        this.name = name;
        this.updatedAt = new Timestamp(System.currentTimeMillis());
        this.homework = homework;
    }

    public Lesson(int id, String name, Timestamp updatedAt, Homework homework) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
        this.homework = homework;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", homework='" + homework + '\'' +
                '}' + "\n";
    }
}
