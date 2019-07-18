package org.basseur.adventofcode.advent2018.days.day09;

import java.util.ArrayDeque;
import java.util.Collection;

/**
 * Implementation of a circular ArrayDeque which adds a method to rotate the Deque.
 *
 * @param <E> the type of elements held in this collection
 * @author Jan Philipp G&ouml;lz
 */
public class CircleDeque<E> extends ArrayDeque<E> {

    /**
     * Calls the Constructor of {@link ArrayDeque}.
     */
    public CircleDeque() {
        super();
    }

    /**
     * Calls the Constructor of {@link ArrayDeque} with Collection argument.
     *
     * @param c the collection whose elements are to be placed into the circle deque
     */
    public CircleDeque(Collection<? extends E> c) {
        super(c);
    }

    /**
     * Rotates this CircleDeque by the number of steps given as an argument.
     * A positive value means clockwise, a negative value means counterclockwise.
     * For this purpose, the last (resp. first) element is removed and added again as the first (resp. last) element
     * depending on the direction of rotation.
     *
     * @param steps number of steps to rotate the circle. Positive is clockwise, negative is counterclockwise.
     */
    public void rotate(int steps) {

        if (this.isEmpty()) {
            return;
        }

        if (steps > 0) {
            for (int i = 0; i < steps; i++) {
                E element = this.removeLast();
                this.addFirst(element);
            }
        }

        if (steps < 0) {
            for (int i = 0; i < Math.abs(steps); i++) {
                E element = this.removeFirst();
                this.addLast(element);
            }
        }
    }
}
