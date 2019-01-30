package org.basseur.adventofcode.advent2018.days.day04;

import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class Day04Test {

    @MockBean
    private FileReaders fileReaders;
    private List<String> guardRecords = new ArrayList<>();
    private Days day04;

    @Before
    public void setUp() {
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

        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(guardRecords);
        day04 = new Day04(fileReaders);
    }

    @Test
    public void testGetDay() {
        int expectedResult = 4;
        int actualResult = day04.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPart() {
        String expectedResult = "Part 1 - The ID of the guard multiplied by the minute: 240";
        String actualResult = day04.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSecondPart() {
        String expectedResult = "Part 2 - The ID of the guard multiplied by the minute: 4455";
        String actualResult = day04.secondPart();

        Assert.assertEquals(expectedResult, actualResult);
    }
}