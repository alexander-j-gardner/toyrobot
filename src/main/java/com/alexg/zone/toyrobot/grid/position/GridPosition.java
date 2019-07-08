package com.alexg.zone.toyrobot.grid.position;

public class GridPosition {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GridPosition clonePosition() {
        GridPosition newPosn = new GridPosition();
        newPosn.setX(x);
        newPosn.setY(y);

        return newPosn;
    }

    public void moveNorth() {
        y++;
    }

    public void moveSouth() {
        y--;
    }

    public void moveEast() {
        x++;
    }

    public void moveWest() {
        x--;
    }
}
