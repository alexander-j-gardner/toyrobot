package com.alexg.zone.toyrobot.commands;

public abstract class Command {
    private CommandType commandType;

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }
}
