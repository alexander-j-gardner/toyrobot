package com.alexg.zone.toyrobot.grid;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.grid.direction.Facing;
import com.alexg.zone.toyrobot.grid.position.GridPosition;

public interface Grid {
    void acceptCommand(Command command);
    GridPosition getCurrentPosition();
    Facing getCurrentDirection();
    boolean isGridInitialised();
}
