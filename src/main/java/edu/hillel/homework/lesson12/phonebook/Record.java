package edu.hillel.homework.lesson12.phonebook;

import edu.hillel.homework.lesson12.phonebook.exceptions.InvalidPhoneNumberFormatException;
import org.jetbrains.annotations.NotNull;

public class Record {

    private String name;
    private String phone;

    public Record(String name, String phone) {
        this.name = name;
        try {
            setPhone(phone);
        } catch (InvalidPhoneNumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(@NotNull String phone) throws InvalidPhoneNumberFormatException {
        if (phone.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}$")) {
            this.phone = phone;
        } else {
            try {
                throw new RuntimeException("Invalid phone number format! Must be +XX(XXX)XXXXXXX");
            } catch (RuntimeException e) {
                throw new InvalidPhoneNumberFormatException(e.getMessage(), e);
            }
        }
    }

    @Override
    public String toString() {
        return "Record{" +
                "name=\"" + name + "\"" +
                ", phone=\"" + phone + "\"" +
                "}";
    }
}
