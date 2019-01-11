package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.Utils.FileReaders;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FileReaders.class })
public class Day01Test {

    Day01 subjectToTest = new Day01();
    Integer[] frequencies;

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForFirstExample() {
        //arrange
        frequencies = new Integer[4];
        frequencies[0] = 1;
        frequencies[1] = -2;
        frequencies[2] = 3;
        frequencies[3] = 1;

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 2 - Frequency reached twice: " + 2;

        //act
        String actualResult = subjectToTest.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateDoubleFrequencyFindsFirstDoubleFrequencyForSecondExample() {
        //arrange
        frequencies = new Integer[2];
        frequencies[0] = 1;
        frequencies[1] = -1;

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 2 - Frequency reached twice: " + 0;

        //act
        String actualResult = subjectToTest.secondPart();

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

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 2 - Frequency reached twice: " + 10;

        //act
        String actualResult = subjectToTest.secondPart();

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

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 2 - Frequency reached twice: " + 5;

        //act
        String actualResult = subjectToTest.secondPart();

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

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 2 - Frequency reached twice: " + 14;

        //act
        String actualResult = subjectToTest.secondPart();

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
        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 1 - Frequency: " + 3;

        //act
        String actualResult = subjectToTest.firstPart();

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
        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 1 - Frequency: " + 3;

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForThirdxample() {
        //arrange
        frequencies = new Integer[3];
        frequencies[0] = 1;
        frequencies[1] = 1;
        frequencies[2] = -2;
        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 1 - Frequency: " + 0;

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateFrequencyAddsFrequenciesCorrectlyForFourthxample() {
        //arrange
        frequencies = new Integer[3];
        frequencies[0] = -1;
        frequencies[1] = -2;
        frequencies[2] = -3;
        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoArrayOfIntegers(Mockito.anyString())).thenReturn(frequencies);

        String expectedResult = "Part 1 - Frequency: " + -6;

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}