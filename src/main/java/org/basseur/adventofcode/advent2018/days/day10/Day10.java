package org.basseur.adventofcode.advent2018.days.day10;

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
 * Implementation for <i>Day 10: The Stars Align</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day10 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day10/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /** The list of pointStrings */
    private final List<String> pointsStringList;

    /** The list of points */
    private List<Point> points = new ArrayList<>();
    /** The message that appears */
    private String message;
    /** The time it takes for the message to appear */
    private int seconds;

    /**
     * Constructor of Day10.
     * Causes the input file to be stored in the marble game string.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day10(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.pointsStringList = fileReaders.readFileIntoStringList(FILE_LOCATION);

        parsePoints();
        movePoints();
    }

    @Override
    public int getDay() {
        return 10;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The message in the sky reads: " + message;
    }

    @Override
    public String secondPart() {
        return "Part 2 - Seconds, the elves would have needed to wait: " + seconds;
    }

    /**
     * Creates the list of points by parsing the coordinates and velocities from the {@link #pointsStringList}.
     */
    private void parsePoints() {

        for (String pointString : pointsStringList) {

            Matcher matcher = Pattern.compile("position=<\\s*(-*\\d+), \\s*(-*\\d+)> velocity=<\\s*(-*\\d+), \\s*(-*\\d+)>").matcher(pointString);
            if (matcher.find()) {
                int posX = Integer.parseInt(matcher.group(1));
                int posY = Integer.parseInt(matcher.group(2));
                int velX = Integer.parseInt(matcher.group(3));
                int velY = Integer.parseInt(matcher.group(4));

                points.add(new Point(posX, posY, velX, velY));
            }
        }
    }

    /**
     * Determines the {@link #message} for part 1 and the {@link #seconds} for part 2.
     * <p>
     * For this purpose, all x and y coordinates are each added to a corresponding list to determine the minimum and
     * maximum values. Then all the points are moved once and {@link #seconds} is increased. Subsequently, the new x and
     * y coordinates are again added to lists and again minimum and maximum values are determined. If the difference
     * between maximum and minimum values increased after the move, the message should have appeared, as the text should
     * have appeared at a minimum difference. At that point, the last move is undone, seconds decreased and the message
     * is parsed.
     */
    private void movePoints() {

        int seconds = 0;

        int minX, maxX;
        int minY, maxY;

        int spanX;
        int spanY;

        int nextSpanX;
        int nextSpanY;

        do {
            List<Integer> allX = new ArrayList<>();
            List<Integer> allY = new ArrayList<>();

            for (Point point : points) {
                allX.add(point.getX());
                allY.add(point.getY());
            }

            minX = Collections.min(allX);
            maxX = Collections.max(allX);
            minY = Collections.min(allY);
            maxY = Collections.max(allY);

            spanX = maxX - minX;
            spanY = maxY - minY;

            for (Point point : points) {
                point.move();
            }

            seconds++;

            List<Integer> nextAllX = new ArrayList<>();
            List<Integer> nextAllY = new ArrayList<>();

            for (Point point : points) {
                nextAllX.add(point.getX());
                nextAllY.add(point.getY());
            }

            int nextMinX = Collections.min(nextAllX);
            int nextMaxX = Collections.max(nextAllX);
            int nextMinY = Collections.min(nextAllY);
            int nextMaxY = Collections.max(nextAllY);

            nextSpanX = nextMaxX - nextMinX;
            nextSpanY = nextMaxY - nextMinY;

        } while ((nextSpanX < spanX) && (nextSpanY < spanY));


        for (Point point : points) {
            point.undoMove();
        }

        this.seconds = --seconds;
        this.message = parseText(minX, maxX, minY, maxY);
    }

    /**
     * Parsed the Points to create the message.
     *
     * @param minX minimum x value
     * @param maxX maximum x value
     * @param minY minimum y value
     * @param maxY maximum y value
     * @return the String of the parsed text
     */
    private String parseText(int minX, int maxX, int minY, int maxY) {

        StringBuilder message = new StringBuilder();

        message.append(System.lineSeparator());

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                boolean hasPoint = false;
                for (Point point : points) {
                    hasPoint = hasPoint || point.isOnCoordinate(x, y);
                }
                if (hasPoint) {
                    message.append("▓"); // black block
                } else {
                    message.append("░"); // white block
                }
            }
            message.append(System.lineSeparator());
        }

        return message.toString();
    }
}