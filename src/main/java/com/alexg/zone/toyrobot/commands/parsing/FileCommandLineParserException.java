package com.alexg.zone.toyrobot.commands.parsing;

public class FileCommandLineParserException extends RuntimeException {
    public FileCommandLineParserException() {
    }

    public FileCommandLineParserException(String message) {
        super(message);
    }

    public FileCommandLineParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileCommandLineParserException(Throwable cause) {
        super(cause);
    }
}
