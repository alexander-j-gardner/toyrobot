package com.alexg.zone.toyrobot.grid;

import com.alexg.zone.toyrobot.commands.Command;
import com.alexg.zone.toyrobot.commands.CommandType;
import com.alexg.zone.toyrobot.commands.PlaceCommand;
import com.alexg.zone.toyrobot.commands.validation.CommandValidationException;
import com.alexg.zone.toyrobot.grid.direction.DirectionTracker;
import com.alexg.zone.toyrobot.grid.direction.Facing;
import com.alexg.zone.toyrobot.grid.position.GridPosition;
import com.alexg.zone.toyrobot.grid.position.PositionTracker;

public class ToyRobotGrid implements Grid {

    private boolean placeCommandSucceeded;
    private final DirectionTracker directionTracker;
    private final PositionTracker gridPositionTracker;

    public ToyRobotGrid(DirectionTracker directionTracker, PositionTracker gridPositionTracker) {
        this.directionTracker = directionTracker;
        this.gridPositionTracker = gridPositionTracker;
    }

    @Override
    public void acceptCommand(Command command) {
        CommandType commandType = command.getCommandType();

        switch (commandType) {
            case LEFT:
                directionTracker.left();
                break;
            case RIGHT:
                directionTracker.right();
                break;
            case REPORT:
                report();
                break;
            case MOVE:
                move();
                break;
            case PLACE:
                PlaceCommand placeCommand = (PlaceCommand) command;
                place(placeCommand.getGridPosition(), placeCommand.getFacing());
                break;
            default:
                throw new CommandValidationException("Unsupported CommandType: " + commandType);
        }
    }

    private void place(GridPosition position, Facing facing) {
        if (gridPositionTracker.setCurrentPlacementPosition(position)) {
            placeCommandSucceeded = true;
        }
        directionTracker.setPlacedDirection(facing);
    }

    private void move() {
        gridPositionTracker.validateAndMoveInDirection(getCurrentDirection());
    }

    private void report() {
        if (gridPositionTracker.isInitialised()) {
            GridPosition currentPosition = gridPositionTracker.getCurrentGridPosition();
            System.out.println("Output:" + currentPosition.getX() + "," + currentPosition.getY() + "," + getCurrentDirection());
        }
    }

    @Override
    public GridPosition getCurrentPosition() {
        return gridPositionTracker.getCurrentGridPosition();
    }

    @Override
    public Facing getCurrentDirection() {
        return directionTracker.getCurrentDirection();
    }

    @Override
    public boolean isGridInitialised() {
        return placeCommandSucceeded;
    }
}
