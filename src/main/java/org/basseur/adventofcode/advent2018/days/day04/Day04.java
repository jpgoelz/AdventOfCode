package org.basseur.adventofcode.advent2018.days.day04;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.Collator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Day04 implements Days {

    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/day04/Input.txt";
    private final List<String> guardRecords;
    private final Map<Integer, Guard> guardHashMap = new HashMap<>();

    private final HashMap<String, ProblemStatusEnum> problemStatus;

    @Autowired
    Day04(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.IN_PROGRESS);
        this.problemStatus.put("2", ProblemStatusEnum.UNSOLVED);

        this.guardRecords = fileReaders.readFileIntoStringList(FILE_LOCATION);
        this.guardRecords.sort(Collator.getInstance());
    }

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public String firstPart() {
        return "Part 1 - The ID of the guard multiplied by the minute: " + getIdMultipliedByMinute();
    }

    @Override
    public String secondPart() {
        return null;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }


    /**
     * Parses all the Guards from the {@code guardRecords} and adds them to {@code HashMap<Integer, Guard> guardHashMap}.
     */
    private void parseGuards() {
        for (String guardRecord : guardRecords) {
            Pattern pattern = Pattern.compile("\\[\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}\\] Guard #(\\d+) begins shift");
            Matcher matcher = pattern.matcher(guardRecord);
            int id = 0;
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
                guardHashMap.put(id, new Guard(id));
            }
        }
    }

    /**
     * Primary method for Day 4, Part 1.
     * Multiplies the ID of the guard who slept the longest by the minute he slept the most.
     *
     * @return product of the <u>ID</u> of the guard who slept the longest and the <u>minute</u> he slept the most.
     */
    private int getIdMultipliedByMinute() {
        parseGuards();
        return 0;
    }
}
