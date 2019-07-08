package com.alexg.zone.toyrobot.commands.build;

import com.alexg.zone.toyrobot.commands.*;
import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    private final CommandType commandType;
    private List<String> commandParameters;

    public CommandBuilder(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandBuilder withCommandParameters(List<String> commandParameters) {
        this.commandParameters = commandParameters;

        return this;
    }

    public Command build() {
        switch (commandType) {
            case LEFT:
                return new LeftCommand(CommandType.LEFT, new ArrayList<String>());
            case RIGHT:
                return new RightCommand(CommandType.RIGHT, new ArrayList<String>());
            case REPORT:
                return new ReportCommand(CommandType.REPORT, new ArrayList<String>());
            case MOVE:
                return new MoveCommand(CommandType.MOVE, new ArrayList<String>());
            case PLACE:
                if (commandParameters == null) {
                    throw new CommandBuilderException("Command parameters missing for CommandType: " + commandType);
                }
                return new PlaceCommand(CommandType.PLACE, commandParameters);
            default:
                throw new CommandBuilderException("Unsupported CommandType: " + commandType);
        }
    }
}
