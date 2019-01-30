package org.basseur.adventofcode.advent2018.days.day04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GuardTest {

    private Guard guard;

    @Before
    public void setUp() {
        int[] minutesOfSleep = new int[60];
        minutesOfSleep[15] = 13;
        minutesOfSleep[30] = 42;
        minutesOfSleep[45] = 1337;

        guard = new Guard(1);
        guard.addSleep(minutesOfSleep);
    }

    @Test
    public void testGetMinuteOfMaximumSleep() {
        int expectedResult = 45;
        int actualResult = guard.getMinuteOfMaximumSleep();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetAmountOfSleepForMaxSleepMinute() {
        int expectedResult = 1337;
        int actualResult = guard.getAmountOfSleepForMaxSleepMinute();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetTotalSleep() {
        int expectedResult = 1392;
        int actualResult = guard.getTotalSleep();

        Assert.assertEquals(expectedResult, actualResult);
    }
}