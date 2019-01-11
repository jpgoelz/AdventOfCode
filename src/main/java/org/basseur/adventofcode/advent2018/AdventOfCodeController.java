package org.basseur.adventofcode.advent2018;

import org.basseur.adventofcode.advent2018.Days.Days;
import org.basseur.adventofcode.advent2018.Exceptions.PuzzleNotSolvedYetException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdventOfCodeController {

    @RequestMapping("/day")
    public String result(@RequestParam(value="day", defaultValue="1") String day, @RequestParam(value="part", defaultValue="1") String part) {
        String result = "";
        String dayString = "";
        if (day.length() == 1) {
            dayString = "0" + day;
        } else {
            dayString = day;
        }

        ClassLoader classLoader = Application.class.getClassLoader();
        try {
            Class adventOfCodeClass = classLoader.loadClass("org.basseur.adventofcode.advent2018.Days.Day" + dayString);
            try {
                Days thisDaysClass = (Days) adventOfCodeClass.newInstance();
                if (part.equals("1")) {
                    result = thisDaysClass.firstPart();
                } else if (part.equals("2")) {
                    result = thisDaysClass.secondPart();
                } else {
                    throw new PuzzleNotSolvedYetException(new Throwable());
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new PuzzleNotSolvedYetException(e);
        }

        return result;
    }
}
