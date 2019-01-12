package org.basseur.adventofcode.advent2018.Days;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class Day02Test {

    /**
     * abcdef contains no letters that appear exactly two or three times.
     * bababc contains two a and three b, so it counts for both.
     * abbcde contains two b, but no letter appears exactly three times.
     * abcccd contains three c, but no letter appears exactly two times.
     * aabcdd contains two a and two d, but it only counts once.
     * abcdee contains two e.
     * ababab contains three a and three b, but it only counts once.
     *
     * Of these box IDs, four of them contain a letter which appears exactly
     * twice, and three of them contain a letter which appears exactly three
     * times. Multiplying these together produces a checksum of 4 * 3 = 12.
     */

    String testBoxIDs = "abcdef\n" +
            "bababc\n" +
            "abbcde\n" +
            "abcccd\n" +
            "aabcdd\n" +
            "abcdee\n" +
            "ababab";

    Day02 subjectToTest = new Day02();

    @Test
    public void countsLettersPerBoxIdThatAppearTwiceAndThreeTimes() {
        //arrange

        //act

        //assert
    }

    @Test
    public void calculateChecksumForBoxIds() {
        //arrange

        //act
        int actualResult = subjectToTest.calculateChecksum(testBoxIDs);

        //assert
        Assert.assertEquals(12, actualResult);
    }

    @Test
    public void producesTheCorrectOutput() {
        //arrange
        subjectToTest.testBoxIDs = testBoxIDs;
        String expectedResult = "Part 1 - Checksum: " + 12;

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}