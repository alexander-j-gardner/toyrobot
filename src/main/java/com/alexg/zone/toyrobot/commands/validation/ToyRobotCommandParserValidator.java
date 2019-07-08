package com.alexg.zone.toyrobot.commands.validation;

import com.alexg.zone.toyrobot.commands.CommandType;
import java.util.List;

public class ToyRobotCommandParserValidator implements CommandParserValidator {
    @Override
    public void validateCommandParameters(CommandType commandType, List<String> commandParams) {
        switch (commandType) {
            case LEFT:
                validateZeroParmetersCommand(commandType, commandParams);
                break;
            case RIGHT:
                validateZeroParmetersCommand(commandType, commandParams);
                break;
            case REPORT:
                validateZeroParmetersCommand(commandType, commandParams);
                break;
            case MOVE:
                validateZeroParmetersCommand(commandType, commandParams);
                break;
            case PLACE:
                validatePlaceParmetersCommand(commandType, commandParams);
                break;
            default:
                throw new CommandValidationException("Unsupported CommandType: " + commandType);
        }
    }

    private void validateZeroParmetersCommand(CommandType commandType, List<String> commandParams) {
        if (commandParams.size() > 0) {
            throw new CommandValidationException(commandType + " command requires zero parameters");
        }
    }

    private void validatePlaceParmetersCommand(CommandType commandType, List<String> commandParams) {
        if (commandParams.size() != 3) {
            throw new CommandValidationException(commandType + " requires parameters X,Y,FACING");
        }
    }
}
