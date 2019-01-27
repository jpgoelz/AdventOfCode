package org.basseur.adventofcode.advent2018;

import org.basseur.adventofcode.advent2018.service.AdventOfCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/adventOfCode", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdventOfCodeController {

    private static final Logger logger = LoggerFactory.getLogger(AdventOfCodeController.class);

    private AdventOfCodeService adventOfCodeService;

    @Autowired
    public AdventOfCodeController(AdventOfCodeService adventOfCodeService) {
        this.adventOfCodeService = adventOfCodeService;
    }

    /**
     * Handles a GET-Request with the day of the advent calendar and the part to be solved and returns a HATEOAS
     * {@code Resource<>} with the corresponding solution.
     *
     * @param day the simple day of the advent calendar to be solved
     * @param part the part of the puzzle for that day
     * @return a HATEOAS-{@code Resource<>} with the corresponding solution
     */
    @GetMapping
    public Resource getResultForASpecificDayAndPuzzlePart(@RequestParam(value = "day", defaultValue = "") String day, @RequestParam(value = "part", defaultValue = "") String part) {

        logger.info("The results for day " + day + ", part " + part + " have been requested.");

        return new Resource<>(adventOfCodeService.getResultsForASpecificDayAndPuzzlePart(day, part),
                linkTo(methodOn(AdventOfCodeController.class).getResultForASpecificDayAndPuzzlePart(day, part)).withSelfRel()
        );
    }
}