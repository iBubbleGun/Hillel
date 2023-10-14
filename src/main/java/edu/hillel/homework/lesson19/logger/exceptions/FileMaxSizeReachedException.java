package edu.hillel.homework.lesson19.logger.exceptions;

public class FileMaxSizeReachedException extends Exception {

    public FileMaxSizeReachedException() {
    }

    public FileMaxSizeReachedException(String message) {
        super(message);
    }

    public FileMaxSizeReachedException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileMaxSizeReachedException(Throwable cause) {
        super(cause);
    }

    public FileMaxSizeReachedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileMaxSizeReachedException(long currentSize, long maxSize, String filePath) {
        super("Max file size reached. Current size: " + currentSize + " bytes. " +
                "Max size: " + maxSize + " bytes. " +
                "File path: " + filePath);
    }
}
