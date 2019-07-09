package com.alexg.zone.toyrobot;

import com.alexg.zone.toyrobot.commands.LeftCommand;
import com.alexg.zone.toyrobot.commands.MoveCommand;
import com.alexg.zone.toyrobot.commands.PlaceCommand;
import com.alexg.zone.toyrobot.commands.ReportCommand;
import com.alexg.zone.toyrobot.commands.RightCommand;
import com.alexg.zone.toyrobot.grid.ToyRobotGrid;
import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.direction.RotationalDirectionTracker;
import com.alexg.zone.toyrobot.grid.position.GridPositionTracker;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ToyRobotTest {

    @Test
    public void testInitialisation() {
        GridDimensions gridDimensions = new GridDimensions();
        GridPositionTracker gridPositionTracker = new GridPositionTracker(gridDimensions);
        RotationalDirectionTracker directionTracker = new RotationalDirectionTracker();
        ToyRobotGrid toyRobotGrid = new ToyRobotGrid(directionTracker, gridPositionTracker);

        ToyRobot toyRobot = new ToyRobot(toyRobotGrid);
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new LeftCommand());
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new RightCommand());
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new MoveCommand());
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new ReportCommand());
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new PlaceCommand(Arrays.asList("3", "3", "WEST")));
        Assert.assertEquals("ToyRobot should be started", true, toyRobot.isStarted());
    }
}
