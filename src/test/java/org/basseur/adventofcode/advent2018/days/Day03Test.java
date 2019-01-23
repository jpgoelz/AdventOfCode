package org.basseur.adventofcode.advent2018.days;

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
public class Day03Test {

    private List<String> claimsStringList = new ArrayList<>();

    @Test
    public void testGetDay() {
        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        int expectedResult = 3;
        int actualResult = day03.getDay();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testInputFile() {
        try {
            new Day03();
        } catch (IllegalArgumentException e) {
            Assert.fail("There seems to be something wrong with the input file or input file handling.");
        }
    }

    @Test
    public void testFirstPartOneSimpleOverlap() {
        /*  ........
         *  ...2222.
         *  ...2222.
         *  .11XX22.
         *  .11XX22.
         *  .111133.
         *  .111133.
         *  ........
         */
        claimsStringList.add("#1 @ 1,3: 4x4"); // intersects with #2 by 4
        claimsStringList.add("#2 @ 3,1: 4x4"); // intersects with #1 by 4
        claimsStringList.add("#3 @ 5,5: 2x2"); // does not intersection

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 4 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPartTwoSimpleOverlaps() {
        /*  .........
         *  .11X2X33.
         *  .11X2X33.
         *  .11XxX33.
         *  .........
         */
        claimsStringList.add("#1 @ 1,1: 3x3"); // intersects #2 by 3
        claimsStringList.add("#2 @ 3,1: 3x3"); // intersects #1 by 3 and #3 by 3
        claimsStringList.add("#3 @ 5,1: 3x3"); // intersects #2 by 3

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 6 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPartDoubleOverlap1() {
        /*  .......
         *  .11X22.
         *  .11X22.
         *  .1XXX2.
         *  ..333..
         *  ..333..
         *  .......
         */
        claimsStringList.add("#1 @ 1,1: 3x3"); // intersects #2 by 3 and #3 by 2
        claimsStringList.add("#2 @ 3,1: 3x3"); // intersects #1 by 3 and #3 by 2
        claimsStringList.add("#3 @ 2,3: 3x3"); // intersects #1 by 2 and #2 by 2

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 5 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPartDoubleOverlap2() {
        /*  .......
         *  ...222.
         *  .11X22.
         *  .11X22.
         *  .111...
         *  .......
         */
        claimsStringList.add("#1 @ 1,2: 3x3"); // intersects #2 by 3 and #3 by 2
        claimsStringList.add("#2 @ 3,1: 3x3"); // intersects #1 by 3 and #3 by 2
        claimsStringList.add("#3 @ 3,3: 1x1"); // intersects #1 by 2 and #2 by 2

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 2 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPartDoubleOverlap3() {
        /*  .........
         *  .111111..
         *  .1XXX11..
         *  .1XXXXX3.
         *  .1XXX11..
         *  .111111..
         *  .111111..
         *  .........
         */
        claimsStringList.add("#1 @ 1,1: 6x6"); // intersects #2 by 9 and #3 by 3
        claimsStringList.add("#2 @ 2,2: 3x3"); // intersects #1 by 9 and #3 by 1
        claimsStringList.add("#3 @ 4,3: 4x1"); // intersects #1 by 3 and #2 by 1

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 11 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstPartComplexOverlaps() {
        /*  ......5...
         *  .111..X33.
         *  .11X22X33.
         *  .11X2XXX3.
         *  ...22XX4..
         *  .....4X4..
         *  .....444..
         *  ..........
         */
        claimsStringList.add("#1 @ 1,1: 3x3"); // intersects #2 by 2
        claimsStringList.add("#2 @ 3,2: 4x3"); // intersects #1 by 2, #3 by 2, #4 by 4, #5 by 3
        claimsStringList.add("#3 @ 6,1: 3x3"); // intersects #2 by 2, #4 by 2, #5 by 3
        claimsStringList.add("#4 @ 5,3: 3x4"); // intersects #2 by 4, #3 by 2, #5 by 3
        claimsStringList.add("#5 @ 6,0: 1x6"); // intersects #2 by 3, #3 by 3, #4 by 3

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsStringList);
        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim intersection: 10 square inches";
        String actualResult = day03.firstPart();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSecondPart() {
    }
}
