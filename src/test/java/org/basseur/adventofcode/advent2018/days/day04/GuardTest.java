package org.basseur.adventofcode.advent2018.days.day04;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
public class GuardTest {

    @Test
    public void testGetMinuteOfMaximumSleep() {
        int[] minutesOfSleep = new int[60];
        minutesOfSleep[15] = 13;
        minutesOfSleep[30] = 42;
        minutesOfSleep[45] = 1337;

        Guard guard = new Guard(1);
        guard.addSleep(minutesOfSleep);

        int expectedResult = 45;
        int actualResult = guard.getMinuteOfMaximumSleep();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetTotalSleep() {
        int[] minutesOfSleep = new int[60];
        IntStream.range(0, 30).forEach(minute -> minutesOfSleep[minute] = 1);

        Guard guard = new Guard(1);
        guard.addSleep(minutesOfSleep);

        int expectedResult = 30;
        int actualResult = guard.getTotalSleep();

        Assert.assertEquals(expectedResult, actualResult);
    }
}