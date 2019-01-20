package org.basseur.adventofcode.advent2018.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PuzzleRepository extends CrudRepository<Puzzle, Long> {

    List<Puzzle> findAll();

    List<Puzzle> findAllByDay(String day);

    Puzzle save(Puzzle puzzle);

}
