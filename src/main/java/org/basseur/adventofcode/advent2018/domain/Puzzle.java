package org.basseur.adventofcode.advent2018.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String day;
    private String part;


    public Puzzle(String day, String part) {
        this.day = day;
        this.part = part;
    }
}
