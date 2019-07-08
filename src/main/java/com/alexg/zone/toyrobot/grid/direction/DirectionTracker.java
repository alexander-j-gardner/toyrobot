package com.alexg.zone.toyrobot.grid.direction;

public interface DirectionTracker {
    void setPlacedDirection(Facing placedDirection);
    void left();
    void right();
    Facing getCurrentDirection();
}
