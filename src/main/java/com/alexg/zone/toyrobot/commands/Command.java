package com.alexg.zone.toyrobot.commands;

import java.util.List;

public abstract class Command {
    private CommandType commandType;
    private List<String> commandParameters;

    public Command(CommandType commandType, List<String> commandParameters) {
        this.commandType = commandType;
        this.commandParameters = commandParameters;
    }

    public CommandType getCommandType() {
        return commandType;
    }
}
