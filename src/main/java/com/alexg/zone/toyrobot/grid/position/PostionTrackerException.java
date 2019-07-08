package com.alexg.zone.toyrobot.grid.position;

public class PostionTrackerException extends RuntimeException {
    public PostionTrackerException() {
    }

    public PostionTrackerException(String message) {
        super(message);
    }

    public PostionTrackerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PostionTrackerException(Throwable cause) {
        super(cause);
    }
}
