package org.basseur.adventofcode.advent2018.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClaimTest {

    @Test
    public void Claim() {
        Claim claim = new Claim("#1 @ 2,3: 4x5");
        int[] expectedResult = new int[]{1, 2, 3, 4, 5};
        int[] actualResult = new int[]{claim.getId(), claim.getX1(), claim.getY1(), claim.getWidth(), claim.getHeight()};

        Assert.assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * claim1 is on top of claim2, no overlap.
     * claim3 is on the right of claim1, no overlap.
     * claim4 overlaps claim1 on the lower right corner.
     * claim4 overlaps claim2 on the upper right corner.
     * claim5 completely surrounds claim1 (overlaps).
     * Gute Ideen zum testen: https://www.baeldung.com/java-check-if-two-rectangles-overlap
     */
    @Test
    public void overlaps() {
        Claim claim1 = new Claim("#1 @ 2,2: 4x3");
        Claim claim2 = new Claim("#2 @ 2,6: 4x3");
        Claim claim3 = new Claim("#3 @ 7,2: 4x3");
        Claim claim4 = new Claim("#4 @ 4,4: 4x3");
        Claim claim5 = new Claim("#5 @ 1,1: 6x5");

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

//    @Test
//    public void addOverlapping() {
//        claims[0].addOverlapping(claims[1]);
//
//        actualResult
//    }
}