package org.basseur.adventofcode.advent2018;

import org.basseur.adventofcode.advent2018.Days.Days;
import org.basseur.adventofcode.advent2018.Exceptions.PuzzleNotSolvedYetException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class AdventOfCodeController {

    private final List<Days> daysSolutions;

    public AdventOfCodeController(List<Days> daysSolutions) {
        this.daysSolutions = Objects.requireNonNull(daysSolutions);
    }

    @RequestMapping("/adventOfCode")
    public String result(@RequestParam(value="day", defaultValue="") String day, @RequestParam(value="part", defaultValue="") String part) {
        Days thisDaysClass = findDayForDay(Integer.parseInt(day));
        if (("1").equals(part)) {
            return thisDaysClass.firstPart();
        } else if (("2").equals(part)) {
            return thisDaysClass.secondPart();
        } else {
            throw new PuzzleNotSolvedYetException(new Throwable());
        }
    }

    private Days findDayForDay(int day) {
        return daysSolutions.stream()
                .filter(solution -> solution.getDay() == day)
                .findFirst()
                .orElseThrow(() -> new PuzzleNotSolvedYetException(new Throwable()));
    }
}
