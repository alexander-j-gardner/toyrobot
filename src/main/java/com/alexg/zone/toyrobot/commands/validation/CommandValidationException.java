package com.alexg.zone.toyrobot.commands.validation;

public class CommandValidationException extends RuntimeException {
    public CommandValidationException() {
    }

    public CommandValidationException(String message) {
        super(message);
    }

    public CommandValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandValidationException(Throwable cause) {
        super(cause);
    }
}
