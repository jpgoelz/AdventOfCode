package org.basseur.adventofcode.advent2018.days.day08;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Implementation for <i>Day 8: Memory Maneuver</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day08 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day08/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The string of nodes */
    private final String nodeString;

    /**
     * Constructor of Day08.
     * Causes the input file to be stored in the nodeString.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day08(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.IN_PROGRESS);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.nodeString = String.join("", fileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 8;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Sum of all metadata entries: " + calculateSumOfAllMetadataEntries();
    }

    @Override
    public String secondPart() {
        return "Part 2 - ";
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary method for Day 8, Part 1.
     * <p>
     *
     * @return the sum of all metadata entries.
     */
    private int calculateSumOfAllMetadataEntries() {
        return 0;
    }
}
