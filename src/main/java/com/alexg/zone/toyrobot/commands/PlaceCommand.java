package com.alexg.zone.toyrobot.commands;

import com.alexg.zone.toyrobot.grid.direction.Facing;
import com.alexg.zone.toyrobot.grid.position.GridPosition;
import java.util.List;

public class PlaceCommand extends Command {

    private final GridPosition position;
    private final Facing facing;

    public PlaceCommand(CommandType commandType, List<String> cmdParams) {
        super(commandType, cmdParams);
        int x = Integer.valueOf(cmdParams.get(0));
        int y = Integer.valueOf(cmdParams.get(1));
        Facing facing = Facing.valueOf(cmdParams.get(2));

        this.position = new GridPosition();
        this.position.setX(x);
        this.position.setY(y);
        this.facing = facing;
    }

    public GridPosition getGridPosition() {
        return position;
    }

    public Facing getFacing() {
        return facing;
    }
}
