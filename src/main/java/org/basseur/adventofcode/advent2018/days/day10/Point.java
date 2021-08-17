package org.basseur.adventofcode.advent2018.days.day10;

public class Point {

    /** position of this point on the x-axis */
    private final int velX;
    /** position of this point on the y-axis */
    private final int velY;
    /** velocity of this point on the x-axis */
    private int x;
    /** velocity of this point on the y-axis */
    private int y;

    /**
     * Constructor for this point.
     *
     * @param x position of this point on the x-axis
     * @param y position of this point on the y-axis
     * @param velX velocity of this point on the x-axis
     * @param velY velocity of this point on the y-axis
     */
    public Point(int x, int y, int velX, int velY) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
    }

    /**
     * Getter for x.
     *
     * @return the position of this point on the x-axis
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y.
     *
     * @return position of this point on the y-axis
     */
    public int getY() {
        return y;
    }

    /**
     * Moves this point forwards.
     */
    public void move() {
        this.x += velX;
        this.y += velY;
    }

    /**
     * Moves this point backwards.
     */
    public void undoMove() {
        this.x -= velX;
        this.y -= velY;
    }

    /**
     * Checks, if this point is at the given position.
     *
     * @param x x coordinate to be compared
     * @param y y coordinate to be compared
     * @return true if this point is on the given coordinates, false otherwise
     */
    public boolean isOnCoordinate(int x, int y) {
        return (x == this.x) && (y == this.y);
    }
}
