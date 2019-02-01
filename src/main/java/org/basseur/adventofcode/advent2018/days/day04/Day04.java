package org.basseur.adventofcode.advent2018.days.day04;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Collator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Implementation for <i>Day 4: Repose Record</i>.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class Day04 implements Days {

    /** The location of the puzzle input file */
    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day04/Input.txt";
    /** A list containing all the guard records */
    private final List<String> guardRecords;
    /** A {@code Map} containing all the {@link Guard}s mapped to their IDs */
    private final Map<Integer, Guard> guardHashMap = new HashMap<>();

    /** The puzzle status {@code HashMap} */
    private final HashMap<String, ProblemStatusEnum> problemStatus;

    /**
     * Constructor of Day04.
     * Causes the input file to be parsed into the {@code guardRecords} and sorts it.
     * Then the guards are parsed and then the whole record is parsed.
     *
     * @param fileReaders {@code @Autowired} fileReader
     */
    @Autowired
    Day04(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.guardRecords = fileReaders.readFileIntoStringList(FILE_LOCATION);
        this.guardRecords.sort(Collator.getInstance());
        parseGuards();
        parseRecords();
    }

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The ID of the guard multiplied by the minute: " + idMultipliedByMinute(1);
    }

    @Override
    public String secondPart() {
        return "Part 2 - The ID of the guard multiplied by the minute: " + idMultipliedByMinute(2);
    }

    /**
     * Primary method for Day 4, both Parts.
     * Multiplies the ID of the chosen guard by the chosen minute.
     *
     * @return product of the <u>ID</u> of the chosen guard and the chosen <u>minute</u>.
     */
    private int idMultipliedByMinute(int part) {
        int max = 0;
        int chosenGuardId = 0;
        int chosenMinute = 0;

        for (Map.Entry<Integer, Guard> entry : guardHashMap.entrySet()) {
            Guard currentGuard = entry.getValue();
            int possibleMax = 0;

            if (part == 1) {
                possibleMax = currentGuard.getTotalSleep();
            } else if (part == 2) {
                possibleMax = currentGuard.getAmountOfSleepForMaxSleepMinute();
            }

            if (possibleMax > max) {
                max = possibleMax;
                chosenGuardId = currentGuard.getID();
                chosenMinute = currentGuard.getMinuteOfMaximumSleep();
            }
        }
        return chosenGuardId * chosenMinute;
    }

    /**
     * Parses all the Guards from the {@code guardRecords} and adds them to {@code HashMap<Integer, Guard> guardHashMap}.
     */
    private void parseGuards() {
        for (String guardRecord : guardRecords) {
            Matcher matcher = Pattern.compile(".+Guard #(\\d+) begins shift").matcher(guardRecord);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                guardHashMap.put(id, new Guard(id));
            }
        }
    }

    /**
     * Parses all the Minutes of Sleep and adds them to the corresponding {@link Guard}s.
     */
    private void parseRecords() {
        int[] minutesOfSleep = new int[60];
        int asleepFrom = 0;
        int id = 0;

        for (String guardRecord : guardRecords) {
            Matcher matcher = Pattern.compile(".+Guard #(\\d+) begins shift").matcher(guardRecord);

            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));

            } else if (guardRecord.toLowerCase().contains("falls asleep")) {
                asleepFrom = Integer.valueOf(guardRecord.substring(15, 17));

            } else if (guardRecord.toLowerCase().contains("wakes up")) {
                int asleepUntil = Integer.valueOf(guardRecord.substring(15, 17));

                IntStream.range(asleepFrom, asleepUntil).forEach(minute -> minutesOfSleep[minute] += 1);
                guardHashMap.get(id).addSleep(minutesOfSleep);
                Arrays.fill(minutesOfSleep, 0);
            }
        }
    }
}
