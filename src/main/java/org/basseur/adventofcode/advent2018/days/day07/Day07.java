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
    /** The difference between the integer value of a char and seconds to finish a step, e.g. `(int)char 'A' = 65`, but A takes 1 extra second. */
    private static int DIFFERENCE_BETWEEN_CHAR_AND_SECONDS = 64;
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;
    /** A list containing the instructions */
    private final List<String> instructions;
    /** A {@code Map} containing all the {@link Step}s mapped to their IDs */
    private Map<Character, Step> stepHashMap = new HashMap<>();
    /** Number of available Workers in Part 2 */
    private int workers = 5;
    /** Minimum time per Task */
    private int minTimePerTask = 60;

    /**
     * Constructor for Day07.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day07(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

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
        return "Part 2 - Time required to complete all of the steps: " + determineTime() + " seconds";
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary Method for Day 7, Part 1.
     * <p>
     * Determines the order, in which the instructions should be completed.
     * For this purpose {@link #stepHashMap} is copied. The new HashMap is
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
        List<Character> availableStepsIds = new ArrayList<>();
        Map<Character, Step> steps = getCopyOfStepHashMap();
        StringBuilder order = new StringBuilder();

        while (!steps.isEmpty()) {
            steps.forEach((id, step) -> {
                if (!step.hasPrevious() && !availableStepsIds.contains(id)) {
                    availableStepsIds.add(id);
                }
            });

            Collections.sort(availableStepsIds);
            Character currentStepId = availableStepsIds.get(0);
            order.append(currentStepId);

            steps.forEach((id, step) -> step.removePrevious(currentStepId));
            steps.remove(currentStepId);
            availableStepsIds.remove(currentStepId);
        }

        return order.toString();
    }

    /**
     * Primary method for Day 7, Part 2.
     * <p>
     * Determines the time it takes to complete all tasks with the number of workers given in {@link #workers}.
     * For this purpose, {@link #stepHashMap} is copied. In a while loop, first the available steps are determined.
     * Secondly, each available step is given to a worker, if one is available. The time it takes for the step to
     * be completed is calculated in this step and stored with the respective ID. In the third step, the time left
     * is reduced. If there is just one second left, the step is removed from the map of Steps, from the list of
     * previous steps in each other step and from the list of steps in progress. Lastly the time taken is increased
     * by 1. If there are no more steps left, the while loop ends and the total time taken is returned.
     *
     * @return time it takes to complete all the tasks
     */
    private int determineTime() {
        Map<Character, Step> steps = getCopyOfStepHashMap();
        int availableWorkers = workers;

        List<Character> availableSteps = new ArrayList<>();
        Map<Character, Integer> stepsInProgress = new HashMap<>();

        int timeTaken = 0;

        while (!steps.isEmpty()) {
            steps.forEach((id, step) -> {
                if (!(step.hasPrevious() || availableSteps.contains(id) || stepsInProgress.containsKey(id))) {
                    availableSteps.add(id);
                }
            });

            List<Character> stepsToRemoveFromAvailable = new ArrayList<>();
            for (Character id : availableSteps) {
                if (availableWorkers > 0) {
                    int timeForThisId = id - DIFFERENCE_BETWEEN_CHAR_AND_SECONDS;
                    int timeToFinish = minTimePerTask + timeForThisId;

                    stepsInProgress.put(id, timeToFinish);
                    availableWorkers--;

                    stepsToRemoveFromAvailable.add(id);
                }
            }
            availableSteps.removeAll(stepsToRemoveFromAvailable);

            List<Character> stepsToRemoveFromInProgress = new ArrayList<>();
            for (Map.Entry<Character, Integer> stepInProgress : stepsInProgress.entrySet()) {
                int timeLeft = stepInProgress.getValue();
                char currentStepId = stepInProgress.getKey();

                if (timeLeft > 1) {
                    --timeLeft;
                    stepInProgress.setValue(timeLeft);
                } else {
                    steps.remove(currentStepId);
                    steps.forEach((id, step) -> step.removePrevious(currentStepId));
                    stepsToRemoveFromInProgress.add(currentStepId);
                    availableWorkers++;
                }
            }
            stepsInProgress.keySet().removeAll(stepsToRemoveFromInProgress);

            timeTaken++;
        }

        return timeTaken;
    }

    /**
     * Parses the {@link #instructions} to create {@link Step}s and add previous IDs.
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
     * Creates and returns a deep copy of the {@link #stepHashMap}
     *
     * @return a copy of the {@link #stepHashMap}
     */
    private HashMap<Character, Step> getCopyOfStepHashMap() {
        HashMap<Character, Step> copyOfStepHashMap = new HashMap<>();

        stepHashMap.forEach((id, step) -> copyOfStepHashMap.put(id, new Step(step)));

        return copyOfStepHashMap;
    }
}