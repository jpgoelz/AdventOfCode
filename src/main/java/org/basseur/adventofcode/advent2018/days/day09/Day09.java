package org.basseur.adventofcode.advent2018.days.day09;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Implementation for <i>Day 9: Marble Mania</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day09 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day09/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The marble game string */
    private final String marbleGameString;

    /**
     * Constructor of Day09.
     * Causes the input file to be stored in the marble game string.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day09(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.marbleGameString = String.join("", fileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 9;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The winning Elf's score: " + calculateScore();
    }

    @Override
    public String secondPart() {
        return "Part 2 - : " + primaryForPartTwo();
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary method for Day 5, Part 1.
     * <p>
     *
     * @return the score of the winning Elf
     */
    private int calculateScore() {
        return 0;
    }

    /**
     * Primary method for Day 5, Part 2.
     * <p>
     *
     * @return unknown
     */
    private int primaryForPartTwo() {
        return 0;
    }
}
