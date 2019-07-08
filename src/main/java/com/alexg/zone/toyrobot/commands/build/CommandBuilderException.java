package com.alexg.zone.toyrobot.commands.build;

public class CommandBuilderException extends RuntimeException {
    public CommandBuilderException() {
    }

    public CommandBuilderException(String message) {
        super(message);
    }

    public CommandBuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandBuilderException(Throwable cause) {
        super(cause);
    }
}
