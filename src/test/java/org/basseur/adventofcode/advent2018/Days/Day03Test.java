package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.Utils.FileReaders;
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

    private Day03 subjectToTest = new Day03();

    @Test
    public void calculateAreaOfFabricCorrectly() {
        //arrange
        List<String> claims = new ArrayList<>();
        claims.add("#1 @ 1,3: 4x4");
        claims.add("#2 @ 3,1: 4x4");
        claims.add("#3 @ 5,5: 2x2");

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claims);

        String expectedResult = "Part 1 - Fabric claim overlap: " + 4 + " square inches";

        //act
        String actualResult = subjectToTest.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
