package com.alexg.zone.toyrobot.commands.parsing;

import com.alexg.zone.toyrobot.commands.CommandType;
import com.alexg.zone.toyrobot.commands.validation.CommandParserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ToyRobotCommandParameterParser implements CommandParametersParser {

    private final CommandParserValidator commandParserValidator;

    public ToyRobotCommandParameterParser(CommandParserValidator commandParserValidator) {
        this.commandParserValidator = commandParserValidator;
    }

    @Override
    public List<String> parseAndValidate(CommandType commandType, String commandParams) {
        StringTokenizer cmdParamsSt = new StringTokenizer(commandParams, ",");
        List<String> cmdParams = getCommandParameters(cmdParamsSt);
        commandParserValidator.validateCommandParameters(commandType, cmdParams);

        return cmdParams;
    }

    private List<String> getCommandParameters(StringTokenizer cmdParamsSt) {
        List<String> cmdParams = new ArrayList<>();
        while (cmdParamsSt.hasMoreTokens()) {
            cmdParams.add(cmdParamsSt.nextToken());
        }

        return cmdParams;
    }
}
