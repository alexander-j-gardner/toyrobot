package com.alexg.zone.toyrobot;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.CommandType;
import com.alexg.zone.toyrobot.grid.Grid;

public class ToyRobot {

    private final Grid grid;
    private boolean isStarted;

    public ToyRobot(Grid grid) {
        this.grid = grid;
    }

    public void acceptCommand(Command command) {
        // Ensure very first command is a VALID PLACE command
        if (!isStarted) {
            CommandType commandType = command.getCommandType();
            if (!commandType.equals(CommandType.PLACE)) {
                return;
            } else {
                grid.acceptCommand(command);
                if (grid.isGridInitialised()) {
                    isStarted = true;
                }
            }
        }

        grid.acceptCommand(command);
    }

    public boolean isStarted() {
        return isStarted;
    }
}
