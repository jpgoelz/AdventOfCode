package org.basseur.adventofcode.advent2018.days.day09;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
    private static final String FILE_LOCATION = "/puzzleInputs/Input09.txt";
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
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.marbleGameString = String.join("", fileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 9;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The winning Elf's score: " + calculateScore(1);
    }

    @Override
    public String secondPart() {
        return "Part 2 - The winning Elf's score: " + calculateScore(100);
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary method for Day 5, both parts.
     * <p>
     * Calculates the winning elf's points using a circular deque. This allows to rotate the circle clockwise
     * or counterclockwise and perform an action on the current position.
     * <p>
     * First, the input String is parsed to get the number of players and the last marble.
     * Second, all the marbles are added to the circle rotating two steps clockwise first each step.
     * Every 23rd marble, however, the circle is rotatet by seven steps counterclockwise. The marble on that position
     * is added to the players score as well as the current marble, which is not added to the circle.
     * Finally, the highest player score is determined and returned.
     *
     * @param factor factor by which the number of marbles is multiplied
     * @return the highest player score
     */
    private long calculateScore(int factor) {

        int players = 0;
        int lastMarble = 0;
        long[] playerScores;
        long playerScoresMax = 0;
        CircleDeque<Integer> marbleCircle = new CircleDeque<>();

        Matcher matcher = Pattern.compile("(\\d+) players; last marble is worth (\\d+) points").matcher(marbleGameString);
        if (matcher.find()) {
            players = Integer.parseInt(matcher.group(1));
            lastMarble = Integer.parseInt(matcher.group(2)) * factor;

        }

        playerScores = new long[players];

        for (int marble = 0; marble <= lastMarble; marble++) {
            if (marble % 23 != 0 || marble == 0) {
                marbleCircle.rotate(2);
                marbleCircle.add(marble);
            } else {
                marbleCircle.rotate(-7);
                playerScores[marble % players] += marble + marbleCircle.removeLast();
            }
        }

        for (long playerScore : playerScores) {
            if (playerScore > playerScoresMax) {
                playerScoresMax = playerScore;
            }
        }

        return playerScoresMax;
    }
}