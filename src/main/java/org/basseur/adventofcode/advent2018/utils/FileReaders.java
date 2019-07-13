package org.basseur.adventofcode.advent2018.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.InputStream;
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

    @Autowired
    ResourceLoader resourceloader;

    /**
     * Parses the input file line by line into an array of {@code Integer}s and returns it.
     *
     * @param filename path to the input file
     * @return an array of integers
     */
    public Integer[] readFileIntoArrayOfIntegers(String filename) {
        InputStream fileInputStream = FileReaders.class.getResourceAsStream(filename);
        Scanner scanner = openFileReturnScanner(fileInputStream);
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
        InputStream fileInputStream = FileReaders.class.getResourceAsStream(filename);
        Scanner scanner = openFileReturnScanner(fileInputStream);
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
     * @param fileInputStream path to the file
     * @return a {@code Scanner} of the input file
     */
    private Scanner openFileReturnScanner(InputStream fileInputStream) {
        return new Scanner(fileInputStream);
    }

}
