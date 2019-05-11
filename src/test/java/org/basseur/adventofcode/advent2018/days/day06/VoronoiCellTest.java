package org.basseur.adventofcode.advent2018.days.day06;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VoronoiCellTest {

    private VoronoiCell voronoiCell;

    @Before
    public void setUp() {

        voronoiCell = new VoronoiCell(10, 10);

        voronoiCell.addCoordinate(1, 1);
        voronoiCell.addCoordinate(1, 2);
        voronoiCell.addCoordinate(1, 3);
    }

    @Test
    public void voronoiArea() {
        int expectedResult = 3;
        int actualResult = voronoiCell.voronoiArea();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void distanceTo() {
        Coordinate coordinate = new Coordinate(4, 5);
        int expectedResult = 11;
        int actualResult = voronoiCell.distanceTo(coordinate);

        Assert.assertEquals(expectedResult, actualResult);
    }
}