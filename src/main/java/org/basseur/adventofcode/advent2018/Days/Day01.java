package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.Utils.FileReaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Component
public class Day01 implements Days {

    private static String fileLocation = "src/main/java/org/basseur/adventofcode/advent2018/Days/Day01Input.txt";

    private HashMap<String, ProblemStatusEnum> problemStatus;

    public Day01() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Frequency: " + calculateFrequency();
    }

    @Override
    public String secondPart() {
        return "Part 2 - Frequency reached twice: " + calculateDoubleFrequency();
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    private int calculateFrequency() {
        Integer[] frequencies = FileReaders.readFileIntoArrayOfIntegers(fileLocation);
        return Arrays.stream(frequencies).mapToInt(a -> a).sum();
    }

    private int calculateDoubleFrequency() {
        Integer[] frequencies = FileReaders.readFileIntoArrayOfIntegers(fileLocation);
        Set<Integer> uniqueFrequencies = new HashSet<>();
        int frequency = 0;

        for (int i = 0; true; i++) {
            if (!uniqueFrequencies.add(frequency)) {
                return frequency;
            }
            if (i == (frequencies.length)) {
                i = 0;
            }
            frequency += frequencies[i];
        }
    }
}