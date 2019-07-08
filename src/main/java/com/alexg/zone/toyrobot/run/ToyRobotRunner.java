package com.alexg.zone.toyrobot.run;

import com.alexg.zone.toyrobot.ToyRobot;
import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.parsing.CommandParametersParser;
import com.alexg.zone.toyrobot.commands.parsing.FileCommandLineParser;
import com.alexg.zone.toyrobot.commands.parsing.ToyRobotCommandParameterParser;
import com.alexg.zone.toyrobot.commands.validation.CommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.CommandValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandValidator;
import com.alexg.zone.toyrobot.grid.ToyRobotGrid;
import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.direction.RotationalDirectionTracker;
import com.alexg.zone.toyrobot.grid.position.GridPositionTracker;

import java.io.IOException;
import java.util.List;

public class ToyRobotRunner {
    public static void main(String[] args) throws IOException {
        CommandArgsValidator argsValidator = new CommandArgsValidator();
        argsValidator.validateArgs(args);

        String fileNamePath = args[0];

        GridDimensions gridDimensions = new GridDimensions();
        GridPositionTracker gridPositionTracker = new GridPositionTracker(gridDimensions);
        RotationalDirectionTracker directionTracker = new RotationalDirectionTracker();
        ToyRobotGrid toyRobotGrid = new ToyRobotGrid(directionTracker, gridPositionTracker);

        ToyRobot toyRobot = new ToyRobot(toyRobotGrid);

        CommandValidator commandValidator = new ToyRobotCommandValidator();
        CommandParserValidator commandParserValidator = new ToyRobotCommandParserValidator();
        CommandParametersParser commandParametersParser = new ToyRobotCommandParameterParser(commandParserValidator);
        FileCommandLineParser commandLineParser = new FileCommandLineParser(
                fileNamePath,
                commandValidator,
                commandParametersParser
        );
        List<Command> cmds = commandLineParser.getCommands();
        cmds.forEach(cmd -> {
            toyRobot.acceptCommand(cmd);
        });
    }
}
