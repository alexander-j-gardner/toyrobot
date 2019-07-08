package com.alexg.zone.toyrobot.commands.validation;

import com.alexg.zone.toyrobot.commands.CommandType;
import java.util.List;

public interface CommandParserValidator {
    void validateCommandParameters(CommandType commandType, List<String> commandParams);
}
