package org.basseur.adventofcode.advent2018.days.day07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class StepTest {

    private Step step;

    @Before
    public void setUp() {
        step = new Step('A');
    }

    @Test
    public void testAddRemoveAndHasPrevious() {
        step.addPrevious('B');
        Assert.assertTrue(step.hasPrevious());

        step.removePrevious('B');
        Assert.assertFalse(step.hasPrevious());
    }

    @Test
    public void testRemoveFromEmptyPreviousSteps() {
        step.removePrevious('Z');
        Assert.assertFalse(step.hasPrevious());
    }
}