package com.alexg.zone.toyrobot.command.parsing;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.parsing.CommandParametersParser;
import com.alexg.zone.toyrobot.commands.parsing.FileCommandLineParser;
import com.alexg.zone.toyrobot.commands.parsing.ToyRobotCommandParameterParser;
import com.alexg.zone.toyrobot.commands.validation.CommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.CommandValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandValidator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CommandFileParseTest {
        @Test
        public void parseCommandFileTest() throws IOException {

            CommandValidator commandValidator = new ToyRobotCommandValidator();
            CommandParserValidator commandParserValidator = new ToyRobotCommandParserValidator();
            CommandParametersParser commandParametersParser = new ToyRobotCommandParameterParser(commandParserValidator);
            FileCommandLineParser commandLineParser = new FileCommandLineParser(
                    "src/test/resources/ToyRobotCommands.txt",
                     commandValidator,
                     commandParametersParser
                    );
            List<Command> cmds = commandLineParser.getCommands();
            Assert.assertEquals("Must retrieve 20 commands from the file", 20, cmds.size());
        }

    @Test
    public void parseEmptyCommandFileTest() throws IOException {

        CommandValidator commandValidator = new ToyRobotCommandValidator();
        CommandParserValidator commandParserValidator = new ToyRobotCommandParserValidator();
        CommandParametersParser commandParametersParser = new ToyRobotCommandParameterParser(commandParserValidator);
        FileCommandLineParser commandLineParser = new FileCommandLineParser(
                "src/test/resources/EmptyCommands.txt",
                commandValidator,
                commandParametersParser
        );
        List<Command> cmds = commandLineParser.getCommands();
        Assert.assertEquals("Must retrieve 0 commands from the file", 0, cmds.size());
    }
}
