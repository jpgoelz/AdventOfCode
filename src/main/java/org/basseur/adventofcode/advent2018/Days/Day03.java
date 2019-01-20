package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.Utils.Claim;
import org.basseur.adventofcode.advent2018.Utils.FileReaders;

import java.util.HashMap;
import java.util.List;

public class Day03 implements Days {

    private static String fileLocation = "src/main/java/org/basseur/adventofcode/advent2018/Days/Day03Input.txt";
    private List<String> claimsList;
    private Claim[] claims;

    private HashMap<String, ProblemStatusEnum> problemStatus;

    public Day03() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.IN_PROGRESS);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.claimsList = FileReaders.readFileIntoStringList(fileLocation);
        int claimsListSize = claimsList.size();
        this.claims = new Claim[claimsListSize];
        for (int i = 0; i < claimsListSize; i++) {
            this.claims[i] = new Claim(claimsList.get(i));
        }
    }

    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Fabric claim overlap: " + calculateAreaOfFabric() + " square inches";
    }

    @Override
    public String secondPart() {
        return null;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    private int calculateAreaOfFabric() {
        return Claim.getNumberOfMultipleClaims();
    }
}
