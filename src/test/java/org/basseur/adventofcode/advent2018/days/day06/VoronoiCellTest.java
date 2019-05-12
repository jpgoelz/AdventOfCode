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
        voronoiCell = new VoronoiCell(13, 37);
        voronoiCell.voronoiArea = 1337;
    }

    @Test
    public void distanceTo() {
        int expectedResult = 25;
        int actualResult = voronoiCell.distanceTo(20, 19);

        Assert.assertEquals(expectedResult, actualResult);
    }
}