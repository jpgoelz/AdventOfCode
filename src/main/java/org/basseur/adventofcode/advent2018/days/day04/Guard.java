package org.basseur.adventofcode.advent2018.days.day04;

import java.util.stream.IntStream;

/**
 * A class that defines Guards to be used in {@link Day04}.
 *
 * @author Jan Philipp G&ouml;lz
 */
class Guard {
    /** ID of this guard */
    private final int id;
    /** An array of size 60 to store the amount of sleep per minute */
    private final int[] sleepPerMinute = new int[60];

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

    /**
     * Adds sleep to th internal {@code sleepPerMinute} array.
     * Each element of the array in the argument  is added to each element in the internal array.
     *
     * @param minutesSlept {@code int[]} of minutes slept
     */
    void addSleep(int[] minutesSlept) {
        IntStream.range(0, 60).forEach(minute -> this.sleepPerMinute[minute] += minutesSlept[minute]);
    }

    /**
     * Returns the total amount of sleep in minutes
     *
     * @return total amount of sleep in minutes
     */
    int getTotalSleep() {
        return IntStream.of(sleepPerMinute).sum();
    }

    /**
     * Returns the minute of maximum sleep
     *
     * @return minute of maximum sleep
     */
    int getMinuteOfMaximumSleep() {
        int minuteOfMaximumSleep = 0;
        int currentMaxSleepPerMinute = 0;

        for (int minute = 0; minute < 60; minute++) {
            if (sleepPerMinute[minute] > currentMaxSleepPerMinute) {
                minuteOfMaximumSleep = minute;
                currentMaxSleepPerMinute = sleepPerMinute[minute];
            }
        }
        return minuteOfMaximumSleep;
    }
}
