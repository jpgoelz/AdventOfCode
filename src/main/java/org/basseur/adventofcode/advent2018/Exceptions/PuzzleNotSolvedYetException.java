package org.basseur.adventofcode.advent2018.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "This puzzle has not been solved yet. Please contact your local nerd to implement a solution for that first.")
public class PuzzleNotSolvedYetException extends RuntimeException {
    public PuzzleNotSolvedYetException(Throwable e) {
        super(e);
    }
}