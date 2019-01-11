package org.basseur.adventofcode.advent2018.Days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Day02 extends Days {

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
        Integer[] frequencies = readFileIntoArrayOfIntegers(fileLocation);
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
        Integer[] frequencies = readFileIntoArrayOfIntegers(fileLocation);
        return Arrays.stream(frequencies).mapToInt(a -> a).sum();
    }

    private static Integer[] readFileIntoArrayOfIntegers(String filename) {
        // Opens file specified and returns lines as array of integers.
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        List<Integer> frequencies = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNext()) frequencies.add(Integer.parseInt(scanner.next()));
        scanner.close();
        return frequencies.toArray(new Integer[0]);
    }
}
