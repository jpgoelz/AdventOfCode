package org.basseur.adventofcode.advent2018.Days;

import org.basseur.adventofcode.advent2018.ProblemStatusEnum;

import java.util.HashMap;

public interface Days {

    String firstPart();

    String secondPart();

    int getDay();

    HashMap<String, ProblemStatusEnum> getProblemStatus();
}
