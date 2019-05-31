package org.basseur.adventofcode.advent2018.days.day10;

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
public class Day10Test {

    @MockBean
    private FileReaders fileReaders;
    private List<String> pointStrings = new ArrayList<>();
    private Days day10;

    @Before
    public void setUp() {
        pointStrings.add("position=< 9,  1> velocity=< 0,  2>");
        pointStrings.add("position=< 7,  0> velocity=<-1,  0>");
        pointStrings.add("position=< 3, -2> velocity=<-1,  1>");
        pointStrings.add("position=< 6, 10> velocity=<-2, -1>");
        pointStrings.add("position=< 2, -4> velocity=< 2,  2>");
        pointStrings.add("position=<-6, 10> velocity=< 2, -2>");
        pointStrings.add("position=< 1,  8> velocity=< 1, -1>");
        pointStrings.add("position=< 1,  7> velocity=< 1,  0>");
        pointStrings.add("position=<-3, 11> velocity=< 1, -2>");
        pointStrings.add("position=< 7,  6> velocity=<-1, -1>");
        pointStrings.add("position=<-2,  3> velocity=< 1,  0>");
        pointStrings.add("position=<-4,  3> velocity=< 2,  0>");
        pointStrings.add("position=<10, -3> velocity=<-1,  1>");
        pointStrings.add("position=< 5, 11> velocity=< 1, -2>");
        pointStrings.add("position=< 4,  7> velocity=< 0, -1>");
        pointStrings.add("position=< 8, -2> velocity=< 0,  1>");
        pointStrings.add("position=<15,  0> velocity=<-2,  0>");
        pointStrings.add("position=< 1,  6> velocity=< 1,  0>");
        pointStrings.add("position=< 8,  9> velocity=< 0, -1>");
        pointStrings.add("position=< 3,  3> velocity=<-1,  1>");
        pointStrings.add("position=< 0,  5> velocity=< 0, -1>");
        pointStrings.add("position=<-2,  2> velocity=< 2,  0>");
        pointStrings.add("position=< 5, -2> velocity=< 1,  2>");
        pointStrings.add("position=< 1,  4> velocity=< 2,  1>");
        pointStrings.add("position=<-2,  7> velocity=< 2, -2>");
        pointStrings.add("position=< 3,  6> velocity=<-1, -1>");
        pointStrings.add("position=< 5,  0> velocity=< 1,  0>");
        pointStrings.add("position=<-6,  0> velocity=< 2,  0>");
        pointStrings.add("position=< 5,  9> velocity=< 1, -2>");
        pointStrings.add("position=<14,  7> velocity=<-2,  0>");
        pointStrings.add("position=<-3,  6> velocity=< 2, -1>");

        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(pointStrings);
        day10 = new Day10(fileReaders);
    }

    @Test
    public void getDay() {
        int expectedResult = 10;
        int actualResult = day10.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPart() {
        String expectedResult = "Part 1 - The message in the sky reads: Hi";
        String actualResult = day10.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Ignore("Not implemented yet.")
    @Test
    public void secondPart() {
        String expectedResult = "Part 2";
        String actualResult = day10.secondPart();

        Assert.assertEquals(expectedResult, actualResult);
    }
}