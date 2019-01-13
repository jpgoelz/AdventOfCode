package org.basseur.adventofcode.advent2018.Days;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Day02 implements Days {

    List<String> boxIDs = new ArrayList<>();

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String firstPart() {
        return "Part 1 - Checksum: " + calculateChecksum(boxIDs);
    }

    @Override
    public String secondPart() {
        return "Part 2: ";
    }

    private int calculateChecksum(List<String> boxIDs) {
        return 0;
    }

    private int countDoubleLetterIDs(List<String> boxIDs) {
        return 0;
    }

    private int countTripleLetterIDs(List<String> boxIDs) {
        return 0;
    }

    private boolean containsDoubleLetters(String boxID) {
        return false;
    }

    private boolean containsTripleLetters(String boxID) {
        return false;
    }
}
