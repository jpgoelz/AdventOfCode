package org.basseur.adventofcode.advent2018.days.day04;

/**
 * A class that defines Guards to be used in {@link Day04}.
 *
 * @author Jan Philipp G&ouml;lz
 */
class Guard {
    /** ID of this guard */
    private final int id;

    /**
     * A constructor setting the ID
     *
     * @param id the ID of the new guard
     */
    public Guard(int id) {
        this.id = id;
    }

    /**
     * Getter for {@code id }
     *
     * @return the ID of this guard
     */
    int getID() {
        return this.id;
    }
}
