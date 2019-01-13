package org.basseur.adventofcode.advent2018.Days;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class Day02Test {

    /*
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

    private Day02 subjectToTest = new Day02();

    private List<String> boxIDs = new ArrayList<>();

    @Before
    public void initialize() {
        boxIDs.add("abcdef");
        boxIDs.add("bababc");
        boxIDs.add("abbcde");
        boxIDs.add("abcccd");
        boxIDs.add("aabcdd");
        boxIDs.add("abcdee");
        boxIDs.add("ababab");
    }

    @Test
    public void calculateChecksumCorrectly() {
        //arrange
        subjectToTest.boxIDs = boxIDs;
        String expectedResult = "Part 1 - Checksum: " + 12;

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}