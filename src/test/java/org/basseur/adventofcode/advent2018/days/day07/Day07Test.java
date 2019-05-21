package org.basseur.adventofcode.advent2018.days.day07;

import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class Day07Test {

    @MockBean
    private FileReaders fileReaders;
    private List<String> instructions = new ArrayList<>();
    private Days day07;

    @Before
    public void setUp() {
        instructions.add("Step C must be finished before step A can begin.");
        instructions.add("Step C must be finished before step F can begin.");
        instructions.add("Step A must be finished before step B can begin.");
        instructions.add("Step A must be finished before step D can begin.");
        instructions.add("Step B must be finished before step E can begin.");
        instructions.add("Step D must be finished before step E can begin.");
        instructions.add("Step F must be finished before step E can begin.");

        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(instructions);
        day07 = new Day07(fileReaders);
    }

    @Test
    public void getDay() {
        int expectedResult = 7;
        int actualResult = day07.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPart() {
        String expectedResult = "Part 1 - Order in which the steps in the instructions should be completed: CABDFE";
        String actualResult = day07.firstPart();
        String actualResult2 = day07.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedResult, actualResult2);
    }

    @Test
    public void secondPart() {
        ReflectionTestUtils.setField(day07, "workers", 2);
        ReflectionTestUtils.setField(day07, "minTimePerTask", 0);

        String expectedResult = "Part 2 - Time required to complete all of the steps: 15 seconds";
        String actualResult = day07.secondPart();

        Assert.assertEquals(expectedResult, actualResult);
    }
}