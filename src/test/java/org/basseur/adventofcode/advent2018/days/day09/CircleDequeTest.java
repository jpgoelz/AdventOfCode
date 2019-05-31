package org.basseur.adventofcode.advent2018.days.day09;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CircleDequeTest {

    @Test
    public void rotateClockwise() {

        CircleDeque<Integer> actualResult = new CircleDeque<>(Arrays.asList(1, 2, 3, 4));

        actualResult.rotate(1);

        assertThat(actualResult).containsSequence(4, 1, 2, 3);

    }

    @Test
    public void rotateCounterclockwise() {

        CircleDeque<Integer> actualResult = new CircleDeque<>(Arrays.asList(1, 2, 3, 4));

        actualResult.rotate(-1);

        assertThat(actualResult).containsSequence(2, 3, 4, 1);

    }
}