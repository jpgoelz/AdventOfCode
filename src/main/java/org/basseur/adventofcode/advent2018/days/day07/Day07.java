package org.basseur.adventofcode.advent2018.days.day07;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    /** A {@code Map} containing all the {@link Step}s mapped to their IDs */
    private Map<Character, Step> stepHashMap = new HashMap<>();

    /**
     * Constructor for Day07.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day07(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.instructions = fileReaders.readFileIntoStringList(FILE_LOCATION);

        parseSteps();
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
     * Primary Method for Day 7, Part 1 and helper for Part 2.
     * <p>
     * Determines the order, in which the instructions should be completed.
     * For this purpose {@link Day07#stepHashMap} is copied. The new HashMap is
     * scanned for all {@link Step}s that have no previous steps in them. These
     * are added to an ArrayList which then gets sorted alphabetically. The first
     * item is the current step, which gets added to the output. Subsequently, this
     * step gets removed from all {@link Step#previousSteps} and from the HashMap,
     * as well as from the available Steps. This process gets repeated until the
     * HashMap is empty.
     *
     * @return the ordered String of instructions
     */
    private String determineOrder() {
        List<Character> availableSteps = new ArrayList<>();
        Map<Character, Step> steps = getCopyOfStepHashMap();
        StringBuilder order = new StringBuilder();

        while (!steps.isEmpty()) {
            steps.forEach((id, step) -> {
                if (!step.hasPrevious()) {
                    availableSteps.add(id);
                }
            });

            Collections.sort(availableSteps);
            Character currentStep = availableSteps.get(0);
            order.append(currentStep);

            steps.forEach((id, step) -> step.removePrevious(currentStep));
            steps.remove(currentStep);
            availableSteps.removeAll(Collections.singleton(currentStep));
        }

        return order.toString();
    }

    /**
     * Parses the {@link Day07#instructions} to create {@link Step}s and add previous IDs.
     */
    private void parseSteps() {
        for (String instruction : instructions) {
            Matcher matcher = Pattern.compile("Step (\\w) must be finished before step (\\w) can begin\\.").matcher(instruction);

            if (matcher.find()) {
                char firstId = matcher.group(1).charAt(0);
                char secondId = matcher.group(2).charAt(0);

                stepHashMap.putIfAbsent(firstId, new Step(firstId));
                stepHashMap.putIfAbsent(secondId, new Step(secondId));
                stepHashMap.get(secondId).addPrevious(firstId);
            }
        }
    }

    /**
     * Creates and returns a deep copy of the {@link Day07#stepHashMap}
     *
     * @return a copy of the {@link Day07#stepHashMap}
     */
    private HashMap<Character, Step> getCopyOfStepHashMap() {
        HashMap<Character, Step> copyOfStepHashMap = new HashMap<>();

        stepHashMap.forEach((id, step) -> copyOfStepHashMap.put(id, new Step(step)));

        return copyOfStepHashMap;
    }
}