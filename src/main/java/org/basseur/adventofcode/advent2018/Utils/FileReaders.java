package org.basseur.adventofcode.advent2018.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileReaders {

    public static Integer[] readFileIntoArrayOfIntegers(String filename) {
        // Opens file specified and returns lines as array of integers.
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        List<Integer> frequencies = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNext()) {
            frequencies.add(Integer.parseInt(scanner.next()));
        }
        scanner.close();
        return frequencies.toArray(new Integer[0]);
    }

}
