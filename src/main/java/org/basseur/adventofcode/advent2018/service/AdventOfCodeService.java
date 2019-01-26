package org.basseur.adventofcode.advent2018.service;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.exceptions.PuzzleNotSolvedYetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AdventOfCodeService {

    private final List<Days> daysSolutions;

    @Autowired
    public AdventOfCodeService(List<Days> daysSolutions) {
        this.daysSolutions = Objects.requireNonNull(daysSolutions);
    }

    public String getResultsForASpecificDayAndPuzzlePart(String day, String part) {
        Days thisDaysClass = findDayForDay(Integer.parseInt(day));
        if (!isProblemSolvedForPart(thisDaysClass, part)) {
            throw new PuzzleNotSolvedYetException(new Throwable());
        } else if (("1").equals(part)) {
            return thisDaysClass.firstPart();
        } else if (("2").equals(part)) {
            return thisDaysClass.secondPart();
        } else {
            return "This puzzle has not been solved yet.";
        }
    }

    private boolean isProblemSolvedForPart(Days thisDaysClass, String part) {
        return thisDaysClass.getProblemStatus().containsKey(part) && thisDaysClass.getProblemStatus().get(part) == ProblemStatusEnum.SOLVED;
    }

    private Days findDayForDay(int day) {
        return daysSolutions.stream()
                .filter(solution -> solution.getDay() == day)
                .findFirst()
                .orElseThrow(() -> new PuzzleNotSolvedYetException(new Throwable()));
    }
}
