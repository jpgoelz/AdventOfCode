package org.basseur.adventofcode.advent2018;

import org.basseur.adventofcode.advent2018.Days.Days;
import org.basseur.adventofcode.advent2018.Exceptions.PuzzleNotSolvedYetException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/adventOfCode", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdventOfCodeController {

    private static final Logger logger = LoggerFactory.getLogger(AdventOfCodeController.class);
    private final List<Days> daysSolutions;

    @Autowired
    public AdventOfCodeController(List<Days> daysSolutions) {
        this.daysSolutions = Objects.requireNonNull(daysSolutions);
    }

    @GetMapping
    public Resource getResult(@RequestParam(value = "day", defaultValue = "") String day, @RequestParam(value = "part", defaultValue = "") String part) {

        logger.info("controller logging");

        return new Resource<>(getResultsForASpecificDayAndPuzzlePart(day, part),
                linkTo(methodOn(AdventOfCodeController.class).getResult(day, part)).withSelfRel()
        );
    }

    private String getResultsForASpecificDayAndPuzzlePart(String day, String part) {
        Days thisDaysClass = findDayForDay(Integer.parseInt(day));
        switch (part) {
            case "1":
                if (thisDaysClass.firstPart() == null) {
                    throw new PuzzleNotSolvedYetException(new Throwable());
                }
                return thisDaysClass.firstPart();
            case "2":
                if (thisDaysClass.secondPart() == null) {
                    throw new PuzzleNotSolvedYetException(new Throwable());
                }
                return thisDaysClass.secondPart();
            default:
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