package org.basseur.adventofcode.advent2018.days.day09;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.marbleGameString = String.join("", fileReaders.readFileIntoStringList(FILE_LOCATION));
    }

    @Override
    public int getDay() {
        return 9;
    }

    @Override
    public String firstPart() {
//        long start = System.currentTimeMillis();
        long score = calculateScore(1);
//        long end = System.currentTimeMillis();
//        System.out.println("Duration: " + (end - start) + " ms");
        return "Part 1 - The winning Elf's score: " + score;
    }

    @Override
    public String secondPart() {
//        long start = System.currentTimeMillis();
        long score = calculateScore(100);
//        long end = System.currentTimeMillis();
//        System.out.println("Duration: " + (end - start) + " ms");
        return "Part 2 - The winning Elf's score: " + score;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    /**
     * Primary method for Day 5, both parts.
     * <p>
     * Adds all the marbles to the circle, increasing the position by 2.
     * Every 23rd marble is not added to the circle but to the player on turns score.
     * At the same time the marble 7 positions before the last addition is added to
     * the score as well and removed from the circle.
     *
     * @param factor factor by which the number of marbles is multiplied
     * @return the score of the winning Elf
     */
    private Long calculateScore(int factor) {

        int players = 0;
        int finalMarble = 0;
        List<Integer> circleOfMarbles = new ArrayList<>();

        Matcher matcher = Pattern.compile("(\\d+) players; last marble is worth (\\d+) points").matcher(marbleGameString);
        if (matcher.find()) {
            players = Integer.parseInt(matcher.group(1));
            finalMarble = Integer.parseInt(matcher.group(2)) * factor;
        }

        int[] playerPoints = new int[players];

        int currentPlayer = 0;
        int lastPosition = 0;
        circleOfMarbles.add(0);
        for (int marble = 1; marble <= finalMarble; marble++) {

            int circleSize = circleOfMarbles.size();
            int position;

            if (marble % 23 != 0) {

                position = lastPosition + 2;

                if (position > circleSize) {
                    position -= circleSize;
                }

                circleOfMarbles.add(position, marble);

            } else {

                position = lastPosition - 7;

                if (position < 0) {
                    position += circleSize;
                }

                playerPoints[currentPlayer] += marble + circleOfMarbles.remove(position);

            }

            lastPosition = position;

            currentPlayer++;
            if (currentPlayer == players) {
                currentPlayer = 0;
            }
        }

        Arrays.sort(playerPoints);

        return (long) playerPoints[playerPoints.length - 1];
    }
}
