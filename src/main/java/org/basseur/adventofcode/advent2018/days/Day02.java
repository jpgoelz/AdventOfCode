package org.basseur.adventofcode.advent2018.days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.utils.FileReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class Day02 implements Days {

    private static final String FILE_LOCATION = "src/main/java/org/basseur/adventofcode/advent2018/days/Day02Input.txt";
    private List<String> boxIds;

    private HashMap<String, ProblemStatusEnum> problemStatus;

    @Autowired
    public Day02(FileReaders fileReaders) {
        this.problemStatus = new HashMap<>();
        this.problemStatus.put("1", ProblemStatusEnum.SOLVED);
        this.problemStatus.put("2", ProblemStatusEnum.SOLVED);

        this.boxIds = fileReaders.readFileIntoStringList(FILE_LOCATION);
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public HashMap<String, ProblemStatusEnum> getProblemStatus() {
        return problemStatus;
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

    private int calculateChecksum() {
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
        StringBuilder commonLetters = new StringBuilder();
        int lengthOfListElements = boxIds.size();

        for (int i = 0; i < lengthOfListElements; i++) {
            String boxId = boxIds.get(i);

            for (int j = i + 1; j < lengthOfListElements; j++) {
                String otherBoxId = boxIds.get(j);
                commonLetters.delete(0, commonLetters.length());
                int breakCounter = 0;

                for (int k = 0; k < boxId.length(); k++) {
                    if (boxId.substring(k, k + 1).equals(otherBoxId.substring(k, k + 1))) {
                        commonLetters.append(boxId, k, k + 1);
                    } else {
                        breakCounter++;
                        if (breakCounter > 1) {
                            break;
                        }
                    }
                }

                if (breakCounter == 1) {
                    return commonLetters.toString();
                }
            }
        }
        return commonLetters.toString();
    }
}
