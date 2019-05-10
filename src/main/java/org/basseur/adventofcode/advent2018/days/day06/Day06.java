package org.basseur.adventofcode.advent2018.days.day06;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

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
    private List<VoronoiCell> voronoiCellList;

    /**
     * Constructor of Day06.
     * Causes the input file to be stored in coordinateStringList.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day06(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.IN_PROGRESS);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.coordinateStringList = fileReaders.readFileIntoStringList(FILE_LOCATION);

//        generateVoronoiCells();
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
        return null;
    }

    @Override
    public String secondPart() {
        return null;
    }

//    private void generateVoronoiCells() {
//        for (String coordinateSting : coordinateStringList) {
//            Matcher matcher = Pattern.compile("(\\d+), (\\d+)").matcher(coordinateSting);
//            if (matcher.find()) {
//                voronoiCellList.add(new VoronoiCell(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2))));
//            }
//        }
//    }
}
