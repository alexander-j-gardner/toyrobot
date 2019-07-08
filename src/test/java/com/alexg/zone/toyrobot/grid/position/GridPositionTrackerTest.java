package com.alexg.zone.toyrobot.grid.position;

import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.direction.Facing;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridPositionTrackerTest {

    private GridPositionTracker tracker;

    @Before
    public void initialise() {
        GridDimensions gridDimensions = new GridDimensions();
        tracker = new GridPositionTracker(gridDimensions);
    }

    @Test
    public void testValidNorthMovement() {
        // Ensure that the grid has been initialised first
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(0);
        gridPosition.setX(0);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertTrue("Must be valid movement", tracker.validateAndMoveInDirection(Facing.NORTH));
    }

    @Test
    public void testInvalidNorthMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(4);
        gridPosition.setX(0);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertFalse("Must be invalid movement", tracker.validateAndMoveInDirection(Facing.NORTH));
    }

    @Test
    public void testValidSouthMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setX(4);
        gridPosition.setY(4);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertTrue("Must be valid movement", tracker.validateAndMoveInDirection(Facing.SOUTH));
    }

    @Test
    public void testInvalidSouthMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setX(4);
        gridPosition.setY(0);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertFalse("Must be invalid movement", tracker.validateAndMoveInDirection(Facing.SOUTH));
    }

    @Test
    public void testValidEastMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(0);
        gridPosition.setX(0);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertTrue("Must be valid movement", tracker.validateAndMoveInDirection(Facing.EAST));
    }

    @Test
    public void testInvalidEastMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(0);
        gridPosition.setX(4);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertFalse("Must be invalid movement", tracker.validateAndMoveInDirection(Facing.EAST));
    }

    @Test
    public void testValidWestMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(0);
        gridPosition.setX(3);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertTrue("Must be valid movement", tracker.validateAndMoveInDirection(Facing.WEST));
    }

    @Test
    public void testInvalidWestMovement() {
        GridPosition gridPosition = new GridPosition();
        gridPosition.setY(0);
        gridPosition.setX(0);
        tracker.setCurrentPlacementPosition(gridPosition);

        Assert.assertFalse("Must be invalid movement", tracker.validateAndMoveInDirection(Facing.WEST));
    }
}
