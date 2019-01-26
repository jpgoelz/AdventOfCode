package org.basseur.adventofcode.advent2018.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ClaimTest {

    @Test
    public void testConstructor() {
        Claim claim = new Claim("#1 @ 2,3: 4x5");

        Assert.assertEquals(1, claim.getId());
        Assert.assertEquals(2, claim.getX());
        Assert.assertEquals(3, claim.getY());
        Assert.assertEquals(4, claim.getWidth());
        Assert.assertEquals(5, claim.getHeight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInputFormat() {
        new Claim("This is wrong!");
    }

    @Test
    public void testIntersects() {
        /* These are the possible cases for intersection:
         * claim1 is on top of claim2, no intersection.
         * claim3 is on the right of claim1, no intersection.
         * claim4 intersects claim1 on the lower right corner.
         * claim4 intersects claim2 on the upper right corner.
         * claim5 completely surrounds claim1 (intersects).
         */
        Claim claim1 = new Claim("#1 @ 2,2: 4x3");
        Claim claim2 = new Claim("#2 @ 2,6: 4x3");
        Claim claim3 = new Claim("#3 @ 7,2: 4x3");
        Claim claim4 = new Claim("#4 @ 4,4: 4x3");
        Claim claim5 = new Claim("#5 @ 1,1: 6x5");

        boolean result1 = claim1.intersects(claim2);
        boolean result2 = claim1.intersects(claim3);
        boolean result3 = claim1.intersects(claim4);
        boolean result4 = claim2.intersects(claim4);
        boolean result5 = claim1.intersects(claim5);

        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
        Assert.assertTrue(result3);
        Assert.assertTrue(result4);
        Assert.assertTrue(result5);
    }

    @Test
    public void testMove() {
        Claim claim = new Claim("#0 @ 1,2: 3x4");

        claim.moveTo(13, 37);

        Assert.assertEquals(13, claim.getX());
        Assert.assertEquals(37, claim.getY());
    }
}