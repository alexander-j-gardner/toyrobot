package com.alexg.zone.toyrobot.commands.build;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.CommandType;
import com.alexg.zone.toyrobot.commands.LeftCommand;
import com.alexg.zone.toyrobot.commands.MoveCommand;
import com.alexg.zone.toyrobot.commands.PlaceCommand;
import com.alexg.zone.toyrobot.commands.ReportCommand;
import com.alexg.zone.toyrobot.commands.RightCommand;

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
                return new LeftCommand();
            case RIGHT:
                return new RightCommand();
            case REPORT:
                return new ReportCommand();
            case MOVE:
                return new MoveCommand();
            case PLACE:
                return new PlaceCommand(commandParameters);
            default:
                throw new CommandBuilderException("Unsupported CommandType: " + commandType);
        }
    }
}
