package com.alexg.zone.toyrobot;

import com.alexg.zone.toyrobot.commands.*;
import com.alexg.zone.toyrobot.grid.direction.RotationalDirectionTracker;
import com.alexg.zone.toyrobot.grid.dimension.GridDimensions;
import com.alexg.zone.toyrobot.grid.position.GridPositionTracker;
import com.alexg.zone.toyrobot.grid.ToyRobotGrid;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ToyRobotTest {

    @Test
    public void testInitialisation() {
        GridDimensions gridDimensions = new GridDimensions();
        GridPositionTracker gridPositionTracker = new GridPositionTracker(gridDimensions);
        RotationalDirectionTracker directionTracker = new RotationalDirectionTracker();
        ToyRobotGrid toyRobotGrid = new ToyRobotGrid(directionTracker, gridPositionTracker);

        ToyRobot toyRobot = new ToyRobot(toyRobotGrid);
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new LeftCommand(CommandType.LEFT, new ArrayList<String>()));
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new RightCommand(CommandType.RIGHT, new ArrayList<String>()));
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new MoveCommand(CommandType.MOVE, new ArrayList<String>()));
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());

        toyRobot.acceptCommand(new ReportCommand(CommandType.REPORT, new ArrayList<String>()));
        Assert.assertEquals("ToyRobot should not be started", false, toyRobot.isStarted());


        toyRobot.acceptCommand(new PlaceCommand(CommandType.PLACE,
                new ArrayList<String>() { {add("3"); add("3"); add("WEST");} } ));
        Assert.assertEquals("ToyRobot should be started", true, toyRobot.isStarted());
    }
}
