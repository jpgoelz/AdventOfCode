package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.Utils.Claim;
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
@PrepareForTest({FileReaders.class, Claim.class})
public class Day03Test {

    private List<String> claimsList = new ArrayList<>();

    @Test
    public void testCalculateAreaOfFabric() {
        //arrange
        claimsList.add("#1 @ 1,3: 4x4");
        claimsList.add("#2 @ 3,1: 4x4");
        claimsList.add("#3 @ 5,5: 2x2");

        int claimsListSize = claimsList.size();
        Claim[] claims = new Claim[claimsListSize];
        for (int i = 0; i < claimsListSize; i++) {
            claims[i] = new Claim(claimsList.get(i));
        }

        PowerMockito.mockStatic(FileReaders.class);
        PowerMockito.when(FileReaders.readFileIntoStringList(Mockito.anyString())).thenReturn(claimsList);

//        PowerMockito.mockStatic(Claim.class);
//        PowerMockito.when(Claim.getNumberOfMultipleClaims()).thenReturn(4);

        Day03 day03 = new Day03();

        String expectedResult = "Part 1 - Fabric claim overlap: " + 4 + " square inches";

        //act
        String actualResult = day03.firstPart();

        //assert
        Assert.assertEquals(expectedResult, actualResult);
    }
}
