package org.basseur.adventofcode.advent2018.Days;

import org.springframework.stereotype.Component;

@Component
public class Day02 implements Days {

    String testBoxIDs;

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String firstPart(){
        return "Part 1 - Checksum: " + calculateChecksum(testBoxIDs);
    }

    @Override
    public String secondPart(){
        return "Part 2: ";
    }

    public int calculateChecksum(String testBoxIDs) {
        return 0;
    }
}
