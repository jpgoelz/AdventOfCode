package org.basseur.adventofcode.advent2018.days.day08;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
    private final Integer[] treeData;

    /**
     * Constructor of Day08.
     * Causes the input file to be stored in the {@link #treeData} array.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day08(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.treeData = fileReaders.readFileIntoArrayOfIntegers(FILE_LOCATION);
    }

    @Override
    public int getDay() {
        return 8;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Sum of all metadata entries: " + getSumAndLengthOfNodes(treeData).sum;
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
     * It calculates the sum of all metadata entries. For this purpose in a while loop all sub nodes are processed
     * recursively. If there is no sub node left to process, the metadata is calculated and added to the sum returned
     * from the sub nodes. The length of the nodes is tracked to know, where the next sub node starts.
     *
     * @param nodes an array of integers that represent a tree data structure
     * @return a result object containing the sum of all metadata entries and the length of the node
     */
    private Result getSumAndLengthOfNodes(Integer[] nodes) {
        final int headerLength = 2;

        int amountOfUnprocessedSubNodes = nodes[0];
        int metadataLength = nodes[1];

        Result result = new Result();
        result.length = headerLength + metadataLength;

        int currentSubNodeStart = headerLength;

        while (amountOfUnprocessedSubNodes > 0) {
            Result resultOfSubNode = getSumAndLengthOfNodes(Arrays.copyOfRange(nodes, currentSubNodeStart, nodes.length));

            result.sum += resultOfSubNode.sum;
            result.length += resultOfSubNode.length;

            currentSubNodeStart += resultOfSubNode.length;

            amountOfUnprocessedSubNodes--;
        }

        int metadataStart = currentSubNodeStart;

        for (int i = 0; i < metadataLength; i++) {
            result.sum += nodes[metadataStart + i];
        }

        return result;
    }

    /** A POJO (plain old java object) class to return the length and sum of a sub node. */
    private class Result {
        int sum = 0;
        int length = 0;
    }
}
