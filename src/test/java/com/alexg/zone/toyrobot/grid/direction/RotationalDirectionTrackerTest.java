package com.alexg.zone.toyrobot.grid.direction;

import com.alexg.zone.toyrobot.grid.direction.RotationalDirectionTracker;
import com.alexg.zone.toyrobot.grid.direction.Facing;
import org.junit.Assert;
import org.junit.Test;

public class RotationalDirectionTrackerTest {

    @Test
    public void testDefaultStartingDirection() {
        RotationalDirectionTracker tracker = new RotationalDirectionTracker();
        Assert.assertEquals("Invalid direction must be NORTH", Facing.NORTH, tracker.getCurrentDirection());
    }

    @Test
    public void testPlacedStartingDirection() {
        RotationalDirectionTracker tracker = new RotationalDirectionTracker();
        tracker.setPlacedDirection(Facing.SOUTH);
        Assert.assertEquals("Invalid direction must be SOUTH", Facing.SOUTH, tracker.getCurrentDirection());
    }

    @Test
    public void testRotation() {
        RotationalDirectionTracker tracker = new RotationalDirectionTracker();
        Assert.assertEquals("Invalid direction must be NORTH", Facing.NORTH, tracker.getCurrentDirection());
        tracker.left();
        Assert.assertEquals("Invalid direction must be WEST", Facing.WEST, tracker.getCurrentDirection());
        tracker.left();
        Assert.assertEquals("Invalid direction must be SOUTH", Facing.SOUTH, tracker.getCurrentDirection());
        tracker.right();
        tracker.right();
        tracker.right();
        Assert.assertEquals("Invalid direction must be EAST", Facing.EAST, tracker.getCurrentDirection());
    }
}
