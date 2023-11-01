package edu.hillel.homework.lesson24.data;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Data {

    private final int id;
    private final String info;

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public Data(int id, String info) {
        this.id = id;
        this.info = info;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "Data{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Data) obj;
        return this.id == that.id && Objects.equals(this.info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info);
    }
}
