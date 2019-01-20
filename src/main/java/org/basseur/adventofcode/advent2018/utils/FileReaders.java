package org.basseur.adventofcode.advent2018.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileReaders {

    public static Integer[] readFileIntoArrayOfIntegers(String filename) {
        Scanner scanner = openFileReturnScanner(filename);
        List<Integer> integerList = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNext()) {
            integerList.add(Integer.parseInt(scanner.next()));
        }
        scanner.close();
        return integerList.toArray(new Integer[0]);
    }

    public static List<String> readFileIntoStringList(String filename) {
        Scanner scanner = openFileReturnScanner(filename);
        List<String> stringList = new ArrayList<>();
        while (Objects.requireNonNull(scanner).hasNext()) {
            stringList.add(scanner.next());
        }
        scanner.close();
        return stringList;
    }

    private static Scanner openFileReturnScanner(String filename) {
        File file = new File(filename);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return scanner;
    }

}
