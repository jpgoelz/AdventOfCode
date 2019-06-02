package org.basseur.adventofcode.advent2018.days.day10;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    private Point point = new Point(1, 1, 1, 1);

    @Test
    public void isOnCoordinate() {
        Assert.assertTrue(point.isOnCoordinate(1, 1));
    }


    @Test
    public void move() {
        point.move();

        int actualX = point.getX();
        int actualY = point.getY();

        Assert.assertEquals(2, actualX);
        Assert.assertEquals(2, actualY);
    }

    @Test
    public void undoMove() {
        point.undoMove();

        int actualX = point.getX();
        int actualY = point.getY();

        Assert.assertEquals(0, actualX);
        Assert.assertEquals(0, actualY);
    }
}