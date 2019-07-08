package com.alexg.zone.toyrobot.grid.direction;

import java.util.LinkedList;

public class RotationalDirectionTracker implements DirectionTracker {
    private final LinkedList<Facing> directions = new LinkedList<>();

    public RotationalDirectionTracker() {
        directions.add(Facing.NORTH);
        directions.add(Facing.EAST);
        directions.add(Facing.SOUTH);
        directions.add(Facing.WEST);
    }

    @Override
    public void setPlacedDirection(Facing placedDirection) {
        while (!directions.getFirst().equals(placedDirection)) {
            left();
        }
    }

    @Override
    public void left() {
        directions.addFirst(directions.removeLast());
    }

    @Override
    public void right() {
        directions.addLast(directions.removeFirst());
    }

    @Override
    public Facing getCurrentDirection() {
        return directions.getFirst();
    }
}
