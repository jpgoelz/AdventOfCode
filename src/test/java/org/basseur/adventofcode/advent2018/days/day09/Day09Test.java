package org.basseur.adventofcode.advent2018.days.day09;

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
public class Day09Test {

    @MockBean
    private FileReaders fileReaders;
    private Days day09;
    private List<String> marbleGameStringList = new ArrayList<>();

    @Before
    public void setUp() {
        Mockito.when(fileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(marbleGameStringList);
    }

    @Test
    public void getDay() {
        day09 = new Day09(fileReaders);

        int expectedResult = 9;
        int actualResult = day09.getDay();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample1() {
        marbleGameStringList.add("9 players; last marble is worth 25 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 32";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample2() {
        marbleGameStringList.add("10 players; last marble is worth 1618 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 8317";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample3() {
        marbleGameStringList.add("13 players; last marble is worth 7999 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 146373";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample4() {
        marbleGameStringList.add("17 players; last marble is worth 1104 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 2764";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample5() {
        marbleGameStringList.add("21 players; last marble is worth 6111 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 54718";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void firstPartExample6() {
        marbleGameStringList.add("30 players; last marble is worth 5807 points");
        day09 = new Day09(fileReaders);

        String expectedResult = "Part 1 - The winning Elf's score: 37305";
        String actualResult = day09.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void secondPart() {
    }

    @Test
    public void getProblemStatus() {
    }
}