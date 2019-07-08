package com.alexg.zone.toyrobot.commands.parsing;

import com.alexg.zone.toyrobot.commands.Command;

import java.io.IOException;
import java.util.List;

public interface CommandLineParser {
    List<Command> getCommands() throws IOException;
}
