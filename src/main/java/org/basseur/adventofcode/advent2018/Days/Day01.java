package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.Utils.FileReaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01 extends Days {

    private static String fileLocation = "src/main/java/org/basseur/adventofcode/advent2018/Days/Day01Input.txt";

    public String firstPart(){
        return "Part 1 - Frequency: " + calculateFrequency();
    }
    public String secondPart(){
        return "Part 2 - Frequency reached twice: " + calculateDoubleFrequency();
    }

    private static int calculateDoubleFrequency() {
        /* Gets array of integers from file. Uses HashSet (which can only contain unique values) to see if new calculated
        integer is unique. If not, it is returned. If end of array is reached, we go back to i=0. */
        Integer[] frequencies = FileReaders.readFileIntoArrayOfIntegers(fileLocation);
        Set<Integer> uniqueFrequencies = new HashSet<>();
        int frequency = 0;
        int i = 0;
        while (true) {
            if (!uniqueFrequencies.add(frequency)) return frequency;
            if (i == (frequencies.length)) i = 0;
            frequency += frequencies[i];
            i++;
        }
    }

    private static int calculateFrequency() {
        // Gets array of integers from file and uses stream to calculate and return the sum.
        Integer[] frequencies = FileReaders.readFileIntoArrayOfIntegers(fileLocation);
        return Arrays.stream(frequencies).mapToInt(a -> a).sum();
    }

}
