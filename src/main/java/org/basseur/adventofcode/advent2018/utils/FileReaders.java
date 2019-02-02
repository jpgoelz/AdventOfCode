package org.basseur.adventofcode.advent2018.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * File readers to load and parse input files for the puzzles.
 *
 * @author Jan Philipp G&ouml;lz
 */
@Component
public class FileReaders {

    /**
     * Parses the input file line by line into an array of {@code Integer}s and returns it.
     *
     * @param filename path to the input file
     * @return an array of integers
     */
    public Integer[] readFileIntoArrayOfIntegers(String filename) {
        Scanner scanner = openFileReturnScanner(filename);
        List<Integer> integerList = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNext()) {
            integerList.add(Integer.parseInt(scanner.next()));
        }
        scanner.close();
        return integerList.toArray(new Integer[0]);
    }

    /**
     * Parses the input file line by line into a {@code List} of {@code String}s and returns it.
     *
     * @param filename path to the input file
     * @return a {@code List} of {@code String}s
     */
    public List<String> readFileIntoStringList(String filename) {
        Scanner scanner = openFileReturnScanner(filename);
        List<String> stringList = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNextLine()) {
            stringList.add(scanner.nextLine());
        }
        scanner.close();
        return stringList;
    }


    /**
     * Opens a file and returns a {@code Scanner}.
     *
     * @param filename path to the file
     * @return a {@code Scanner} of the input file
     */
    private Scanner openFileReturnScanner(String filename) {
        File file = new File(filename);
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!", e);
        }
    }

}
