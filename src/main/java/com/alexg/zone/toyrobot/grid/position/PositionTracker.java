package com.alexg.zone.toyrobot.grid.position;

import com.alexg.zone.toyrobot.grid.direction.Facing;

public interface PositionTracker {
    boolean validateAndMoveInDirection(Facing moveInDirection);

    GridPosition getCurrentGridPosition();

    boolean setCurrentPlacementPosition(GridPosition placementPosition);

    boolean isInitialised();
}
