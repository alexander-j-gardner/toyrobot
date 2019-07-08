package com.alexg.zone.toyrobot.commands;

import java.util.List;

public class MoveCommand extends Command {
    public MoveCommand(CommandType commandType, List<String> commandParameters) {
        super(commandType, commandParameters);
    }
}
