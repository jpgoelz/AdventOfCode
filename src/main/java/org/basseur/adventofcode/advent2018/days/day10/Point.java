package org.basseur.adventofcode.advent2018.days.day10;

public class Point {

    private final int velX, velY;
    public int x, y;

    public Point(int x, int y, int velX, int velY) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
    }

    public void move() {
        this.x += velX;
        this.y += velY;
    }
}
