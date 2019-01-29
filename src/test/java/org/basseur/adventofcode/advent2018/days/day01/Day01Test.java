package org.basseur.adventofcode.advent2018.days.day01;

import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Day01Test {

    private Integer[] frequencies;

    @MockBean
    private FileReaders fileReaders;

    @Test
    public void testGetDay() {
        Day01 day01 = new Day01(fileReaders);
        int expectedResult = 1;
        int actualResult = day01.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForFirstExample() {
        //arrange
        frequencies = new Integer[4];
        frequencies[0] = 1;
        frequencies[1] = -2;
        frequencies[2] = 3;
        frequencies[3] = 1;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 2 - Frequency reached twice: 2";

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForSecondExample() {
        //arrange
        frequencies = new Integer[2];
        frequencies[0] = 1;
        frequencies[1] = -1;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 2 - Frequency reached twice: 0";

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForThirdExample() {
        //arrange
        frequencies = new Integer[5];
        frequencies[0] = 3;
        frequencies[1] = 3;
        frequencies[2] = 4;
        frequencies[3] = -2;
        frequencies[4] = -4;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 2 - Frequency reached twice: " + 10;

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForFourthExample() {
        //arrange
        frequencies = new Integer[5];
        frequencies[0] = -6;
        frequencies[1] = 3;
        frequencies[2] = 8;
        frequencies[3] = 5;
        frequencies[4] = -6;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 2 - Frequency reached twice: " + 5;

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForFifthExample() {
        //arrange
        frequencies = new Integer[5];
        frequencies[0] = 7;
        frequencies[1] = 7;
        frequencies[2] = -2;
        frequencies[3] = -7;
        frequencies[4] = -4;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 2 - Frequency reached twice: " + 14;

        //act
        String actualResult = day01.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForFirstExample() {
        //arrange
        frequencies = new Integer[4];
        frequencies[0] = 1;
        frequencies[1] = -2;
        frequencies[2] = 3;
        frequencies[3] = 1;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 1 - Frequency: " + 3;

        //act
        String actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForSecondExample() {
        //arrange
        frequencies = new Integer[3];
        frequencies[0] = 1;
        frequencies[1] = 1;
        frequencies[2] = 1;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 1 - Frequency: " + 3;

        //act
        String actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForThirdExample() {
        //arrange
        frequencies = new Integer[3];
        frequencies[0] = 1;
        frequencies[1] = 1;
        frequencies[2] = -2;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 1 - Frequency: " + 0;

        //act
        String actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForFourthExample() {
        //arrange
        frequencies = new Integer[3];
        frequencies[0] = -1;
        frequencies[1] = -2;
        frequencies[2] = -3;

        Mockito.when(fileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);
        Day01 day01 = new Day01(fileReaders);

        String expectedResult = "Part 1 - Frequency: " + -6;

        //act
        String actualResult = day01.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
