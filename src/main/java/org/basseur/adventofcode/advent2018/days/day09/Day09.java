package org.basseur.adventofcode.advent2018.days.day09;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
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
     *
     * @return the score of the winning Elf
     */
    private int calculateScore() {
        int players = 0;
        int finalMarble = 0;

        List<Integer> playerPoints = new ArrayList<>();
        List<Integer> circleOfMarbles = new ArrayList<>();

        Matcher matcher = Pattern.compile("(\\d+) players; last marble is worth (\\d+) points").matcher(marbleGameString);
        if (matcher.find()) {
            players = Integer.parseInt(matcher.group(1));
            finalMarble = Integer.parseInt(matcher.group(2));
        }

        // Initialize all players
        for (int i = 0; i < players; i++) {
            playerPoints.add(0);
        }

        int currentPlayer = 0;
        int lastPosition = 0;
        circleOfMarbles.add(0);
        for (int marble = 1; marble <= finalMarble; marble++) {
            int nextPosition;

            if (marble % 23 != 0) {
                nextPosition = lastPosition + 2;

                if (nextPosition > circleOfMarbles.size()) {
                    nextPosition = nextPosition - circleOfMarbles.size();
                }

                circleOfMarbles.add(nextPosition, marble);

                lastPosition = nextPosition;
            } else {
                playerPoints.set(currentPlayer, playerPoints.get(currentPlayer) + marble);
                nextPosition = lastPosition - 7;

                if (nextPosition < 0) {
                    nextPosition = nextPosition + circleOfMarbles.size();
                }

                playerPoints.set(currentPlayer, playerPoints.get(currentPlayer) + circleOfMarbles.get(nextPosition));
                circleOfMarbles.remove(nextPosition);

                lastPosition = nextPosition;
            }

            currentPlayer++;
            if (currentPlayer == players) {
                currentPlayer = 0;
            }

        }

        return Collections.max(playerPoints);
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
