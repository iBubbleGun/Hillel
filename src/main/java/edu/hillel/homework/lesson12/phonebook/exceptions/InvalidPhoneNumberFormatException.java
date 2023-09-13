package edu.hillel.homework.lesson12.phonebook.exceptions;

public class InvalidPhoneNumberFormatException extends Exception {

    public InvalidPhoneNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
