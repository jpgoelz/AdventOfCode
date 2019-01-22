package org.basseur.adventofcode.advent2018.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;

@RunWith(SpringRunner.class)
public class ClaimTest {

    /*
     * claim1 is on top of claim2, no overlap.
     * claim3 is on the right of claim1, no overlap.
     * claim4 overlaps claim1 on the lower right corner.
     * claim4 overlaps claim2 on the upper right corner.
     * claim5 completely surrounds claim1 (overlaps).
     */
    private Claim claim1 = new Claim("#1 @ 2,2: 4x3");
    private Claim claim2 = new Claim("#2 @ 2,6: 4x3");
    private Claim claim3 = new Claim("#3 @ 7,2: 4x3");
    private Claim claim4 = new Claim("#4 @ 4,4: 4x3");
    private Claim claim5 = new Claim("#5 @ 1,1: 6x5");

    @Test
    public void Claim() {
        int expectedId = 3;
        Rectangle expectedRectangle = new Rectangle(7, 2, 4, 3);

        Assert.assertEquals(expectedId, claim3.getId());
        Assert.assertEquals(expectedRectangle, claim3.getRectangle());
    }

    @Test
    public void overlaps() {
        boolean result1 = claim1.overlaps(claim2);
        boolean result2 = claim1.overlaps(claim3);
        boolean result3 = claim1.overlaps(claim4);
        boolean result4 = claim2.overlaps(claim4);
        boolean result5 = claim1.overlaps(claim5);

        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertTrue(result3);
        Assert.assertTrue(result4);
        Assert.assertTrue(result5);
    }

    @Test
    public void overlap() {
        Rectangle expectedOverlap1 = new Rectangle(2, 6, 4, -1);
        Rectangle expectedOverlap2 = new Rectangle(7, 2, -1, 3);
        Rectangle expectedOverlap3 = new Rectangle(4, 4, 2, 1);
        Rectangle expectedOverlap4 = new Rectangle(4, 6, 2, 1);
        Rectangle expectedOverlap5 = new Rectangle(2, 2, 4, 3);

        Rectangle actualOverlap1 = claim1.overlap(claim2);
        Rectangle actualOverlap2 = claim1.overlap(claim3);
        Rectangle actualOverlap3 = claim1.overlap(claim4);
        Rectangle actualOverlap4 = claim2.overlap(claim4);
        Rectangle actualOverlap5 = claim1.overlap(claim5);

        Assert.assertEquals(expectedOverlap1, actualOverlap1);
        Assert.assertEquals(expectedOverlap2, actualOverlap2);
        Assert.assertEquals(expectedOverlap3, actualOverlap3);
        Assert.assertEquals(expectedOverlap4, actualOverlap4);
        Assert.assertEquals(expectedOverlap5, actualOverlap5);
    }
}