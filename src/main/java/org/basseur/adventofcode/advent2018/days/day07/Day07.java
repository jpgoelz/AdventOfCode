package org.basseur.adventofcode.advent2018.days.day07;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 7: The Sum of Its Parts</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day07 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day07/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** A list containing the instructions */
    private final List<String> instructions;

    /**
     * Constructor for Day07.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day07(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.UNSOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.instructions = fileReaders.readFileIntoStringList(FILE_LOCATION);
    }

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Order in which the steps in the instructions should be completed: " + determineOrder();
    }

    @Override
    public String secondPart() {
        return "";
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary Method for Day 7, Part 1.
     * <p>
     * Determines the order, in which the instructions should be completed.
     *
     * @return the ordered String of instructions
     */
    private String determineOrder() {
        return "";
    }
}