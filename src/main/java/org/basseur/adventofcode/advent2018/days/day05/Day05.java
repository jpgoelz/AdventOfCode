package org.basseur.adventofcode.advent2018.days.day05;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation for <i>Day 5: Alchemical Reduction</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day05 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day05/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;
    /** The polymer string */
    private final String polymerString;

    /**
     * Constructor of Day05.
     * Causes the input file to be stored in the polymerString.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day05(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.polymerString = String.join("", fileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 5;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Length of remaining polymer: " + unitsRemaining(polymerString);
    }

    @Override
    public String secondPart() {
        return "Part 2 - Length of the shortest polymer: " + shortestPossiblePolymer();
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary method for Day 5, Part 1 and helper method for Part 2.
     * <p>
     * Finds and returns the number of units remaining after fully reacting the polymer.
     * For this purpose each letter combination of e.g. <i>aA</i> and <i>Aa</i> is removed.
     * Removal results in a shorter string. In that case the for-loop is reset to {@code 'A'-1},
     * because it will get incremented to {@code 'A'} by the loop. If no letters have
     * been removed, {@code replaced} stays at {@code false} and the length of the String
     * can be returned.
     *
     * @param inputPolymer the polymer string which is supposed to be reacted
     * @return the number of units remaining
     */
    private int unitsRemaining(String inputPolymer) {
        String resultingPolymerString = inputPolymer;
        boolean replaced = true;

        while (replaced)
            for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                int initialLength = resultingPolymerString.length();

                String lowerUpper = alphabet + Character.toString(alphabet).toUpperCase();
                String upperLower = Character.toString(alphabet).toUpperCase() + alphabet;

                resultingPolymerString = resultingPolymerString.replaceAll(upperLower, "");
                resultingPolymerString = resultingPolymerString.replaceAll(lowerUpper, "");

                if (resultingPolymerString.length() == initialLength) {
                    replaced = false;
                } else {
                    replaced = true;
                    alphabet = 'a' - 1;
                }
            }
        return resultingPolymerString.length();
    }

    /**
     * Primary method for Day 5, Part 2.
     * <p>
     * The method runs through all letters of the alphabet and removes them from the {@code polymerString}
     * case-insensitive. The result is added to a {@code List<Integer>} that returns the minimum at the end.
     *
     * @return the length of the shortest producible polymer
     */
    private int shortestPossiblePolymer() {
        List<Integer> finalLengths = new ArrayList<>();

        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            finalLengths.add(unitsRemaining(polymerString
                    .replaceAll("(?i)" + alphabet, "")
            ));
        }
        return Collections.min(finalLengths);
    }
}
