package org.basseur.adventofcode.advent2018.days;

import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FileReaders.class})
public class Day04Test {

    private List<String> guardRecords = new ArrayList<>();

    @Test
    public void testGetDay() {
        Day04 day04 = new Day04();

        int expectedResult = 4;
        int actualResult = day04.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPart() {
        guardRecords.add("[1518-11-05 00:03] Guard #99 begins shift");
        guardRecords.add("[1518-11-01 00:00] Guard #10 begins shift");
        guardRecords.add("[1518-11-03 00:29] wakes up");
        guardRecords.add("[1518-11-05 00:55] wakes up");
        guardRecords.add("[1518-11-05 00:45] falls asleep");
        guardRecords.add("[1518-11-04 00:46] wakes up");
        guardRecords.add("[1518-11-01 00:55] wakes up");
        guardRecords.add("[1518-11-02 00:40] falls asleep");
        guardRecords.add("[1518-11-03 00:24] falls asleep");
        guardRecords.add("[1518-11-04 00:02] Guard #99 begins shift");
        guardRecords.add("[1518-11-01 23:58] Guard #99 begins shift");
        guardRecords.add("[1518-11-01 00:25] wakes up");
        guardRecords.add("[1518-11-04 00:36] falls asleep");
        guardRecords.add("[1518-11-03 00:05] Guard #10 begins shift");
        guardRecords.add("[1518-11-01 00:30] falls asleep");
        guardRecords.add("[1518-11-01 00:05] falls asleep");
        guardRecords.add("[1518-11-02 00:50] wakes up");

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(guardRecords);
        Day04 day04 = new Day04();

        String expectedResult = "Part 1 - The ID of the guard multiplied by the minute: 240";
        String actualResult = day04.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSecondPart() {
    }
}