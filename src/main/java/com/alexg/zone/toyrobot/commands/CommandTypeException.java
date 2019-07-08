package com.alexg.zone.toyrobot.commands;

public class CommandTypeException extends RuntimeException {
    public CommandTypeException() {
    }

    public CommandTypeException(String message) {
        super(message);
    }

    public CommandTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandTypeException(Throwable cause) {
        super(cause);
    }
}
