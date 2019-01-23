package org.basseur.adventofcode.advent2018.days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.utils.Claim;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Day03 implements Days {

    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/Day03Input.txt";
    private List<Claim> claimList;

    private HashMap<String, ProblemStatusEnum> problemStatus;

    public Day03() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.claimList = claimStringListToClaimArrayList(FileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Fabric claim intersection: " + calculateAreaWithMultipleClaims() + " square inches";
    }

    @Override
    public String secondPart() {
        return null;
    }

    private List<Claim> claimStringListToClaimArrayList(List<String> claimsStringList) {
        List<Claim> claimListFromStrings = new ArrayList<>();
        for (String claimsStingListItem : claimsStringList) {
            claimListFromStrings.add(new Claim(claimsStingListItem));
        }
        return claimListFromStrings;
    }

    private int calculateAreaWithMultipleClaims() {
        int areaWithMultipleClaims = 0;
        int maxX = getMaxX(claimList);
        int maxY = getMaxY(claimList);
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                Rectangle scanRect = new Rectangle(x, y, 1, 1);
                int claimsPerScanRect = 0;
                for (Claim claim : claimList) {
                    if (claim.intersects(scanRect)) {
                        claimsPerScanRect++;
                    }
                }
                if (claimsPerScanRect > 1) {
                    areaWithMultipleClaims++;
                }
            }
        }
        return areaWithMultipleClaims;
    }

    private int getMaxX(List<Claim> claims) {
        int maxX = 0;
        for (Claim claim : claims) {
            maxX = (int) Double.max(maxX, claim.x + claim.width);
        }
        return maxX;
    }

    private int getMaxY(List<Claim> claims) {
        int maxY = 0;
        for (Claim claim : claims) {
            maxY = (int) Double.max(maxY, claim.y + claim.height);
        }
        return maxY;
    }
}