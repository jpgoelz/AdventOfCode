package org.basseur.adventofcode.advent2018.days.day06;

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
public class Day06Test {

    @MockBean
    private FileReaders fileReaders;
    private Days day06;
    private List<String> coordinatesStringList = new ArrayList<>();

    @Before
    public void setUp() {
        coordinatesStringList.add("1, 1");
        coordinatesStringList.add("1, 6");
        coordinatesStringList.add("8, 3");
        coordinatesStringList.add("3, 4");
        coordinatesStringList.add("5, 5");
        coordinatesStringList.add("8, 9");

        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(coordinatesStringList);

        day06 = new Day06(fileReaders);
    }

    @Test
    public void getDay() {
        int expectedResult = 6;
        int actualResult = day06.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPart() {
        String expectedResult = "Size of the largest area that isn't infinite: 17";
        String actualResult = day06.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Ignore
    @Test
    public void secondPart() {
    }
}