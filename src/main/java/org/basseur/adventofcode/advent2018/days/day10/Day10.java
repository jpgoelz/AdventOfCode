package org.basseur.adventofcode.advent2018.days.day10;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 10: The Stars Align</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day10 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day10/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The list of pointStrings */
    private final List<String> pointsStringList;

    /**
     * Constructor of Day10.
     * Causes the input file to be stored in the marble game string.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day10(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.pointsStringList = fileReaders.readFileIntoStringList(FILE_LOCATION);
    }

    @Override
    public int getDay() {
        return 10;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The message in the sky reads: " + determineMessage();
    }

    @Override
    public String secondPart() {
        return "Part 2";
    }

    private String determineMessage() {
        return "";
    }
}