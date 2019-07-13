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
    private static final String FILE_LOCATION = "/puzzleInputs/Input08.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The array of nodes */
    private final Integer[] treeData;

    /** The main node */
    private Node mainNode;

    /**
     * Constructor of Day08.
     * Causes the input file to be stored in the {@link #treeData} array.
     * Then creates the main node which recursively creates all its child nodes.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day08(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.treeData = fileReaders.readFileIntoArrayOfIntegers(FILE_LOCATION);

        mainNode = new Node(treeData);
    }

    @Override
    public int getDay() {
        return 8;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Sum of all metadata entries: " + mainNode.getSumOfMetadata();
    }

    @Override
    public String secondPart() {
        return "Part 2 - The value of the root node is: " + mainNode.getNodeValue();
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }
}
