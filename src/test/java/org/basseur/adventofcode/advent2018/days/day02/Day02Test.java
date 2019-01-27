package org.basseur.adventofcode.advent2018.days.day02;

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
public class Day02Test {

    private final List<String> boxIds = new ArrayList<>();

    @Test
    public void testGetDay() {
        Day02 day02 = new Day02();
        int expectedResult = 2;
        int actualResult = day02.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateChecksumCorrectly() {
        //arrange
        boxIds.add("abcdef");
        boxIds.add("bababc");
        boxIds.add("abbcde");
        boxIds.add("abcccd");
        boxIds.add("aabcdd");
        boxIds.add("abcdee");
        boxIds.add("ababab");

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(boxIds);
        Day02 day02 = new Day02();

        String expectedResult = "Part 1 - Checksum: 12";

        //act
        String actualResult = day02.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findCorrectCommonLettersBetweenBoxIds() {
        //arrange
        boxIds.add("abcde");
        boxIds.add("fghij");
        boxIds.add("klmno");
        boxIds.add("pqrst");
        boxIds.add("fguij");
        boxIds.add("axcye");
        boxIds.add("wvxyz");

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(boxIds);
        Day02 day02 = new Day02();

        String expectedResult = "Part 2 - Common letters: fgij";

        //act
        String actualResult = day02.secondPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
