package org.basseur.adventofcode.advent2018.days.day05;

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
public class Day05Test {

    @MockBean
    private FileReaders fileReaders;
    private Days day05;
    private List<String> polymerString = new ArrayList<>();

    @Before
    public void setUp() {
        polymerString.add("dabAcCaCBAcCcaDA");
        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(polymerString);
        day05 = new Day05(fileReaders);
    }

    @Test
    public void getDay() {
        int expectedResult = 5;
        int actualResult = day05.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPart() {
        String expectedResult = "Part 1 - Length of remaining polymer: 10";
        String actualResult = day05.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondPart() {
        String expectedResult = "Part 2 - Length of the shortest polymer: 4";
        String actualResult = day05.secondPart();

        Assert.assertEquals(expectedResult, actualResult);
    }
}