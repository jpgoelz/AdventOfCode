package org.basseur.adventofcode.advent2018.days;

import org.basseur.adventofcode.advent2018.utils.Claim;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FileReaders.class, Claim.class})
public class Day03Test {

    @Test
    public void testGetDay() {
        Day03 day03 = new Day03();
        int expectedResult = 3;
        int actualResult = day03.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPart() {
    }

    @Test
    public void testSecondPart() {
    }
}
