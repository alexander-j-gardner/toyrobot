package com.alexg.zone.toyrobot.grid;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.parsing.CommandParametersParser;
import com.alexg.zone.toyrobot.commands.parsing.FileCommandLineParser;
import com.alexg.zone.toyrobot.commands.parsing.ToyRobotCommandParameterParser;
import com.alexg.zone.toyrobot.commands.validation.CommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.CommandValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandParserValidator;
import com.alexg.zone.toyrobot.commands.validation.ToyRobotCommandValidator;
import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.direction.RotationalDirectionTracker;
import com.alexg.zone.toyrobot.grid.position.GridPositionTracker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringTokenizer;

public class ToyRobotGridTest {

    private List<Command> cmds;
    private ToyRobotGrid toyRobotGrid;

    @Before
    public void initialise() throws IOException  {
        CommandValidator commandValidator = new ToyRobotCommandValidator();
        CommandParserValidator commandParserValidator = new ToyRobotCommandParserValidator();
        CommandParametersParser commandParametersParser = new ToyRobotCommandParameterParser(commandParserValidator);
        FileCommandLineParser commandLineParser = new FileCommandLineParser(
                "src/test/resources/ToyRobotCommands.txt",
                commandValidator,
                commandParametersParser
        );
        cmds = commandLineParser.getCommands();

        GridDimensions gridDimensions = new GridDimensions();
        GridPositionTracker gridPositionTracker = new GridPositionTracker(gridDimensions);
        RotationalDirectionTracker directionTracker = new RotationalDirectionTracker();
        toyRobotGrid = new ToyRobotGrid(directionTracker, gridPositionTracker);
    }


    @Test
    public void captureSysout() throws UnsupportedEncodingException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        cmds.forEach(cmd -> {
            toyRobotGrid.acceptCommand(cmd);
        });

        String sysoutStr = byteArrayOutputStream.toString("UTF-8");
        StringTokenizer outputSt = new StringTokenizer(sysoutStr, System.lineSeparator());
        Assert.assertEquals("Three calls on report must have occurred", 3, outputSt.countTokens());
        String firstReportOutput = outputSt.nextToken();
        String secondReportOutput = outputSt.nextToken();
        String thirdReportOutput = outputSt.nextToken();

        Assert.assertEquals("First report output must be Output:0,1,NORTH", "Output:0,1,NORTH", firstReportOutput);
        Assert.assertEquals("Second report output must be Output:0,0,WEST", "Output:0,0,WEST", secondReportOutput);
        Assert.assertEquals("Third report output must be Output:3,3,NORTH", "Output:3,3,NORTH", thirdReportOutput);
    }
}
