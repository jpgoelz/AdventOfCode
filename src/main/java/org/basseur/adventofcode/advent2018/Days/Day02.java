package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.Utils.FileReaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Day02 implements Days {

    private static String fileLocation = "src/main/java/org/basseur/adventofcode/advent2018/Days/Day02Input.txt";

    private HashMap<String, ProblemStatusEnum> problemStatus;

    public Day02() {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.IN_PROGRESS);
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Checksum: " + calculateChecksum();
    }

    //TODO: implement solution
    @Override
    public String secondPart() {
        return "Part 2 - Common letters: " + findCommonLettersBetweenCorrectBoxIds();
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
    }

    private int calculateChecksum() {
        List<String> boxIds = FileReaders.readFileIntoStringList(fileLocation);

        int tripleLetters = 0;
        int doubleLetters = 0;

        for (String boxId : boxIds) {
            boolean containsDoubleLetters = false;
            boolean containsTripleLetters = false;

            for (int i = 0; i < boxId.length(); i++) {
                String currentLetter = boxId.substring(i, i + 1);

                if (boxId.replace(currentLetter, "").length() == boxId.length() - 2) {
                    containsDoubleLetters = true;
                } else if (boxId.replace(currentLetter, "").length() == boxId.length() - 3) {
                    containsTripleLetters = true;
                }
            }

            if (containsDoubleLetters) {
                doubleLetters++;
            }
            if (containsTripleLetters) {
                tripleLetters++;
            }
        }

        return doubleLetters * tripleLetters;
    }

    private String findCommonLettersBetweenCorrectBoxIds() {
        return "";
    }
}





