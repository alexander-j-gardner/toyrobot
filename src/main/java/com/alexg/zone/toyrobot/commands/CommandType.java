package com.alexg.zone.toyrobot.commands;

public enum CommandType {
    PLACE("place"), MOVE("move"), LEFT("left"), RIGHT("right"), REPORT("report");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public static CommandType getCommandType(String commandString) throws CommandTypeException {
        switch (commandString) {
            case "place":
                return PLACE;
            case "move":
                return MOVE;
            case "left":
                return LEFT;
            case "right":
                return RIGHT;
            case "report":
                return REPORT;
            default:
                throw new CommandTypeException("Invalid command type specified: " + commandString);
        }
    }

    public String getValue() {
        return value;
    }
}
