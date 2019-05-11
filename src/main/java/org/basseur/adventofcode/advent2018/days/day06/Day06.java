package org.basseur.adventofcode.advent2018.days.day06;

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
 * Implementation for <i>Day 6: Chronal Coordinates</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day06 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day06/Input.txt";
    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;
    /** The list of coordinate Strings */
    private List<String> coordinateStringList;
    /** The list of VoronoiCells */
    private List<VoronoiCell> voronoiCellList = new ArrayList<>();

    /** Minimum of all X values */
    private int minX = Integer.MAX_VALUE;
    /** Maximum of all X values */
    private int maxX = Integer.MIN_VALUE;
    /** Minimum of all Y values */
    private int minY = Integer.MAX_VALUE;
    /** Maximum of all Y values */
    private int maxY = Integer.MIN_VALUE;

    /**
     * Constructor of Day06.
     * Causes the input file to be stored in coordinateStringList.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day06(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.coordinateStringList = fileReaders.readFileIntoStringList(FILE_LOCATION);

        generateVoronoiCells();
        setPlaneBoundries();

    }


    @Override
    public int getDay() {
        return 6;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        Coordinate coordinate = new Coordinate(0, 0);

        for (int x = minX; x <= maxX; x++) {
            coordinate.x = x;

            for (int y = minY; y <= maxY; y++) {
                coordinate.y = y;
                int minimalDistance = Integer.MAX_VALUE;
                VoronoiCell closestVoronoiCell = null;

                for (VoronoiCell voronoiCell : voronoiCellList) {
                    int currentDistance = voronoiCell.distanceTo(coordinate);

                    if (x == minX || x == maxX || y == minY || y == maxY) {
                        voronoiCell.isInfinite = true;
                    }

                    if (currentDistance == minimalDistance) {
                        closestVoronoiCell = null;
                    }

                    if (currentDistance < minimalDistance) {
                        minimalDistance = currentDistance;
                        closestVoronoiCell = voronoiCell;
                    }

                }

                if (closestVoronoiCell != null) {
                    closestVoronoiCell.addCoordinate(x, y);
                }
            }
        }

        int[] areaSizes = new int[voronoiCellList.size()];
        for (int i = 0; i < voronoiCellList.size(); i++) {
            areaSizes[i] = voronoiCellList.get(i).voronoiArea();
        }

        Arrays.sort(areaSizes);

        return "Size of the largest area that isn't infinite: " + areaSizes[areaSizes.length - 1];
    }

    @Override
    public String secondPart() {
        return null;
    }

    private void generateVoronoiCells() {
        for (String coordinateSting : coordinateStringList) {
            Matcher matcher = Pattern.compile("(\\d+), (\\d+)").matcher(coordinateSting);
            if (matcher.find()) {
                voronoiCellList.add(new VoronoiCell(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
            }
        }
    }

    private void setPlaneBoundries() {
        for (VoronoiCell voronoiCell : voronoiCellList) {
            minX = Math.min(voronoiCell.x, minX);
            maxX = Math.max(voronoiCell.x, maxX);
            minY = Math.min(voronoiCell.y, minY);
            maxY = Math.max(voronoiCell.y, maxY);
        }
    }


}
