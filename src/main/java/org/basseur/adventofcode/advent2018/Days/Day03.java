package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;

import java.util.HashMap;

public class Day03 implements Days {

    private static String fileLocation = "src/main/java/org/basseur/adventofcode/advent2018/Days/Day03Input.txt";

    private HashMap<String, ProblemStatusEnum> problemStatus;

    public Day03() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);
    }

    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public String firstPart() {
        return null;
    }

    @Override
    public String secondPart() {
        return null;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }
}
