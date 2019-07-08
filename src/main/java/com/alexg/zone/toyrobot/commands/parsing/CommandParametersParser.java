package com.alexg.zone.toyrobot.commands.parsing;

import com.alexg.zone.toyrobot.commands.CommandType;

import java.util.List;

public interface CommandParametersParser {
    List<String> parseAndValidate(CommandType commandType, String commandParams);
}
