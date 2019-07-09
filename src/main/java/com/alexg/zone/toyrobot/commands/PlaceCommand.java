package com.alexg.zone.toyrobot.commands;

import com.alexg.zone.toyrobot.commands.build.CommandBuilderException;
import com.alexg.zone.toyrobot.grid.direction.Facing;
import com.alexg.zone.toyrobot.grid.position.GridPosition;

import java.util.List;

public class PlaceCommand extends Command {

    private final GridPosition position;
    private final Facing facing;

    public PlaceCommand(List<String> cmdParams) {
        super(CommandType.PLACE);

        if (cmdParams == null) {
            throw new CommandBuilderException("Command parameters missing for CommandType: " + CommandType.PLACE);
        }

        int x = Integer.valueOf(cmdParams.get(0));
        int y = Integer.valueOf(cmdParams.get(1));
        Facing providedFacing = Facing.valueOf(cmdParams.get(2));

        this.position = new GridPosition();
        this.position.setX(x);
        this.position.setY(y);
        this.facing = providedFacing;
    }

    public GridPosition getGridPosition() {
        return position;
    }

    public Facing getFacing() {
        return facing;
    }
}
