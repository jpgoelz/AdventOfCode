package org.basseur.adventofcode.advent2018.days.day07;

import java.util.ArrayList;

public class Step {
    /** Letter of this step */
    public final char id;
    /** List of previous steps */
    private ArrayList<Character> previousSteps = new ArrayList<>();

    /**
     * Constructs Step with id.
     *
     * @param id the id of this Step
     */
    public Step(Character id) {
        this.id = id;
    }

    /**
     * Constructs Step with id and previousSteps.
     *
     * @param id the id for this Step
     * @param previousSteps the previous Steps for this Step
     */
    public Step(Character id, ArrayList<Character> previousSteps) {
        this.id = id;
        this.previousSteps.addAll(previousSteps);
    }

    /**
     * Constructs Step as copy of another Step
     *
     * @param other the other Step to be copied
     */
    public Step(Step other) {
        this(other.id, other.previousSteps);
    }

    /**
     * Returns {@code true} if this step has previous steps
     *
     * @return {@code true} if this Step has previous steps, {@code false} otherwise
     */
    public boolean hasPrevious() {
        return previousSteps.size() > 0;
    }

    /**
     * Adds an id to the {@link Step#previousSteps} ArrayList.
     *
     * @param prevId id of the previous step to be added
     */
    public void addPrevious(Character prevId) {
        previousSteps.add(prevId);
    }

    /**
     * Removes an id to the {@link Step#previousSteps} ArrayList.
     *
     * @param prevId id of the previous step to be removed
     */
    public void removePrevious(Character prevId) {
        previousSteps.remove(prevId);
    }
}
