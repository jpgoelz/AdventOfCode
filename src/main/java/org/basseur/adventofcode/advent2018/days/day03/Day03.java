package org.basseur.adventofcode.advent2018.days.day03;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 3: No Matter How You Slice It</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day03 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "/puzzleInputs/Input03.txt";
    private final List<Claim> claimList;

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /**
     * Causes the input file to be parsed into the claim list.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day03(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.claimList = claimStringListToClaimArrayList(fileReaders.readFileIntoStringList(FILE_LOCATION));
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
        return "Part 1 - Fabric area claimed by multiple Elves: " + calculateAreaWithMultipleClaims() + " square inches";
    }

    @Override
    public String secondPart() {
        return "Part 2 - The only non-overlapping claim has ID #" + findIdOfClaimWithoutOverlaps() + ".";
    }

    /**
     * Returns a {@code List<Claim>}, which contains all claims from {@code claimsStringList}.
     * Each line is passed as a parameter to the constructor of {@code Claim}, which parses it.
     *
     * @param claimsStringList requires a {@code List<String>} of claims in the format
     * #<u>id</u> @ <u>x</u>,<u>y</u>: <u>width</u>x<u>height</u>
     * @return a {@code List<Claim>} containing all parsed claims
     */
    private List<Claim> claimStringListToClaimArrayList(List<String> claimsStringList) {
        List<Claim> claimListFromStrings = new ArrayList<>();
        for (String claimsStingListItem : claimsStringList) {
            claimListFromStrings.add(new Claim(claimsStingListItem));
        }
        return claimListFromStrings;
    }

    /**
     * Primary method for Day 3, Part 1.
     * Calculates the area of fabric that is claimed more than once.
     * <p>
     * A "scanning-claim" ({@code Claim scanRect}) of size 1x1 is used that scans
     * the entire fabric and checks whether it overlaps with other claims. For each
     * overlapping claim, the counter is increased by 1. If this counter is greater
     * than 1, another counter for the area of multiple overlaps is incremented and
     * returned at the end.
     *
     * @return area of fabric claimed more than once
     */
    private int calculateAreaWithMultipleClaims() {
        int areaWithMultipleClaims = 0;
        int maxX = getMaxX(claimList);
        int maxY = getMaxY(claimList);
        Claim scanRect = new Claim("#0 @ 0,0: 1x1");
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                scanRect.moveTo(x, y);
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

    /**
     * Primary method for the Day 3, Part 2.
     * It finds the ID of the first claim that does not overlap with others.
     * <p>
     * All claims are checked against each other. Unless claims are the same,
     * the method checks whether they overlap. If so, a Boolean flag is set.
     * As soon as a claim without overlap is found, the ID is returned.
     *
     * @return the ID of the first claim without overlaps
     */
    private int findIdOfClaimWithoutOverlaps() {
        for (int i = 0; i < claimList.size(); i++) {
            Claim currentClaim = claimList.get(i);
            boolean overlaps = false;
            for (int j = 0; j < claimList.size(); j++) {
                if (i == j) {
                    continue;
                }
                Claim otherClaim = claimList.get(j);
                if (currentClaim.intersects(otherClaim)) {
                    overlaps = true;
                    break;
                }
            }
            if (!overlaps) {
                return currentClaim.getId();
            }
        }
        return 0;
    }

    /**
     * Finds the maximum extent of all claims in x-direction.
     *
     * @param claims a {@code List<Claim>}
     * @return the maximum extent of all claims in x-direction
     */
    private int getMaxX(List<Claim> claims) {
        int maxX = 0;
        for (Claim claim : claims) {
            maxX = Integer.max(maxX, claim.getX() + claim.getWidth());
        }
        return maxX;
    }

    /**
     * Finds the maximum extent of all claims in y-direction.
     *
     * @param claims a {@code List<Claim>}
     * @return the maximum extent of all claims in y-direction
     */
    private int getMaxY(List<Claim> claims) {
        int maxY = 0;
        for (Claim claim : claims) {
            maxY = (int) Double.max(maxY, claim.getY() + claim.getHeight());
        }
        return maxY;
    }
}