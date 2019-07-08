package com.alexg.zone.toyrobot.grid.position;

import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.direction.Facing;

public class GridPositionTracker implements PositionTracker {

    private final GridDimensions gridDimensions;
    private GridPosition currentGridPosition;

    public GridPositionTracker(GridDimensions gridDimensions) {
        this.gridDimensions = gridDimensions;
    }

    @Override
    public boolean validateAndMoveInDirection(Facing moveInDirection) {

        if (!isInitialised()) {
            return false;
        }

        switch(moveInDirection) {
            case NORTH:
                if (currentGridPosition.getY() + 1 <= gridDimensions.getMaxYPosition()) {
                    currentGridPosition.moveNorth();
                    return true;
                }

                return false;
            case EAST:
                if (currentGridPosition.getX() + 1 <= gridDimensions.getMaxXPosition()) {
                    currentGridPosition.moveEast();
                    return true;
                }

                return false;
            case SOUTH:
                if (currentGridPosition.getY() - 1 >= gridDimensions.getMinYPosition()) {
                    currentGridPosition.moveSouth();
                    return true;
                }

                return false;
            case WEST:
                if (currentGridPosition.getX() - 1 >= gridDimensions.getMinXPosition()) {
                    currentGridPosition.moveWest();
                    return true;
                }

                return false;
            default:
                throw new PostionTrackerException("Unsupported Facing: " + moveInDirection);
        }
    }

    @Override
    public GridPosition getCurrentGridPosition() {
        if (currentGridPosition != null) {
            return currentGridPosition.clonePosition();
        }

        return null;
    }

    @Override
    public boolean setCurrentPlacementPosition(GridPosition placementPosition) {
        if (placementPosition.getX() < gridDimensions.getMinXPosition()
            ||
            placementPosition.getY() < gridDimensions.getMinYPosition()
            ||
            placementPosition.getX() > gridDimensions.getMaxXPosition()
            ||
            placementPosition.getY() > gridDimensions.getMaxYPosition()) {
            // ignore invalid placement position
            return false;
        }
        currentGridPosition = placementPosition.clonePosition();
        return true;
    }

    @Override
    public boolean isInitialised() {
        return (currentGridPosition != null) ? true : false;
    }
}
