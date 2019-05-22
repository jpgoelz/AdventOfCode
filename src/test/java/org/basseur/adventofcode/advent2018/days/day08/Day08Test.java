package org.basseur.adventofcode.advent2018.days.day08;

import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class Day08Test {

    @MockBean
    private FileReaders fileReaders;
    private Days day08;
    private List<String> nodeString = new ArrayList<>();

    @Before
    public void setUp() {
        nodeString.add("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2");
        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(nodeString);
        day08 = new Day08(fileReaders);
    }

    @Test
    public void getDay() {
        int expectedResult = 8;
        int actualResult = day08.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPart() {
        String expectedResult = "Part 1 - Sum of all metadata entries: 138";
        String actualResult = day08.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Ignore
    @Test
    public void secondPart() {
        String expectedResult = "Part 2 - ";
        String actualResult = day08.secondPart();

        Assert.assertEquals(expectedResult, actualResult);
    }
}