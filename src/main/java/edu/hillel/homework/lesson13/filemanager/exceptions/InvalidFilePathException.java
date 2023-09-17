package edu.hillel.homework.lesson13.filemanager.exceptions;

public class InvalidFilePathException extends Exception {

    /**
     * empty constructor
     */
    public InvalidFilePathException() {
    }

    /**
     * @param message String parameter
     */
    public InvalidFilePathException(String message) {
        super(message);
    }

    /**
     * @param message String parameter
     * @param cause Throwable parameter
     */
    public InvalidFilePathException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause Throwable parameter
     */
    public InvalidFilePathException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message String parameter
     * @param cause Throwable parameter
     * @param enableSuppression boolean parameter
     * @param writableStackTrace boolean parameter
     */
    public InvalidFilePathException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
