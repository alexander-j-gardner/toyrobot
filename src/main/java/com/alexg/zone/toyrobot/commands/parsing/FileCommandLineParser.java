package com.alexg.zone.toyrobot.commands.parsing;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.CommandType;
import com.alexg.zone.toyrobot.commands.build.CommandBuilder;
import com.alexg.zone.toyrobot.commands.validation.CommandValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileCommandLineParser implements CommandLineParser {

    private final String fileNamePath;
    private final CommandValidator commandValidator;
    private final CommandParametersParser commandParametersParser;

    public FileCommandLineParser(String fileNamePath, CommandValidator commandValidator, CommandParametersParser commandParametersParser) {
        this.fileNamePath = fileNamePath;
        this.commandValidator = commandValidator;
        this.commandParametersParser = commandParametersParser;
    }

    @Override
    public List<Command> getCommands() throws IOException  {
        Path path = null;
        try {
            path = Paths.get(fileNamePath);
        } catch (Exception e) {
            throw new FileCommandLineParserException("Invalid fileNamePath specified", e);
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new FileCommandLineParserException("Could not read the file lines", e);
        }

        List<Command> cmds = new ArrayList<>();

        lines.forEach(line -> {
            cmds.add(parseCommandFrom(line));
        });

        return cmds;
    }

    private Command parseCommandFrom(String commandLineString) {
        StringTokenizer cmdComponentsSt = new StringTokenizer(commandLineString, " ");
        List<String> cmdComponents = new ArrayList<>();
        while (cmdComponentsSt.hasMoreTokens()) {
            cmdComponents.add(cmdComponentsSt.nextToken());
        }

        commandValidator.validateCommandComponents(cmdComponents);
        CommandType commandType = CommandType.getCommandType(cmdComponents.get(0));
        CommandBuilder commandBuilder = new CommandBuilder(commandType);
        List<String> cmdParams = null;

        if (cmdComponents.size() > 1) {
            cmdParams = commandParametersParser.parseAndValidate(commandType, cmdComponents.get(1));
        } else {
            cmdParams = new ArrayList<>();
        }

        return commandBuilder.withCommandParameters(cmdParams).build();
    }
}
