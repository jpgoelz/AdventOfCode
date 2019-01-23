package org.basseur.adventofcode.advent2018;

import io.swagger.annotations.ApiOperation;
import org.basseur.adventofcode.advent2018.days.Days;
import org.basseur.adventofcode.advent2018.exceptions.PuzzleNotSolvedYetException;
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

    @ApiOperation("blablubb")
    @GetMapping
    public Resource getResult(@RequestParam(value = "day", defaultValue = "") String day, @RequestParam(value = "part", defaultValue = "") String part) {

        logger.info("controller logging");

        return new Resource<>(getResultsForASpecificDayAndPuzzlePart(day, part),
                linkTo(methodOn(AdventOfCodeController.class).getResult(day, part)).withSelfRel()
        );
    }

    private String getResultsForASpecificDayAndPuzzlePart(String day, String part) {
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