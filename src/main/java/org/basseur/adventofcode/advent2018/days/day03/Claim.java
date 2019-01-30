package org.basseur.adventofcode.advent2018.days.day03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that defines Claims to be used in {@link Day03}.
 *
 * @author Jan Philipp G&ouml;lz
 */
class Claim {
    /** ID of this claim */
    private final int id;
    /** width of this claim */
    private final int width;
    /** height of this claim */
    private final int height;
    /** position of this claim on the x-axis */
    private int x;
    /** position of this claim on the y-axis */
    private int y;

    /**
     * A constructor that parses a {@code String} into the correct fields.
     * Because claims should only be created, if the pattern is matched,
     * an exception is thrown if they don't.
     *
     * @param claimsListItem a {@code String} in the format
     * #<u>id</u> @ <u>x</u>,<u>y</u>: <u>width</u>x<u>height</u>
     * @throws IllegalArgumentException in case {@code claimsListItem} does not match the pattern
     */
    Claim(String claimsListItem) {
        Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(claimsListItem);
        if (matcher.find()) {
            this.id = Integer.parseInt(matcher.group(1));
            this.x = Integer.parseInt(matcher.group(2));
            this.y = Integer.parseInt(matcher.group(3));
            this.width = Integer.parseInt(matcher.group(4));
            this.height = Integer.parseInt(matcher.group(5));
        } else {
            throw new IllegalArgumentException(claimsListItem + " does not match Pattern");
        }
    }

    /**
     * Returns the ID of this claim.
     *
     * @return ID of this claim
     */
    int getId() {
        return id;
    }

    /**
     * Returns x of this claim.
     *
     * @return x of this claim
     */
    int getX() {
        return x;
    }

    /**
     * Returns y of this claim.
     *
     * @return y of this claim
     */
    int getY() {
        return y;
    }

    /**
     * Returns the width of this claim.
     *
     * @return width of this claim
     */
    int getWidth() {
        return width;
    }

    /**
     * Returns the height of this claim.
     *
     * @return height of this claim
     */
    int getHeight() {
        return height;
    }

    /**
     * Checks, if the passed {@code Claim} intersects with this claim.
     * <p>
     * Claims are basically rectangles, which may be defined by two opposing points,
     * ({@code x} , {@code y}) and ({@code x2}={@code x+width} , {@code y2}={@code y+height}).
     * Rectangles don't overlap if {@code x2} of one is smaller than {@code x} of the other.
     * The same goes for {@code y} and {@code y2}. To check for overlaps, the opposite is checked.
     * All statements must be true (or else no overlap).
     *
     * @param other another {@code Claim} to compare this Claim to
     * @return wether the compared {@code Claim}s overlap or not.
     */
    boolean intersects(Claim other) {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.height;
        int otherX2 = other.x + other.width;
        int otherY2 = other.y + other.height;

        return (this.x < otherX2) && (thisX2 > other.x) && (this.y < otherY2) && (thisY2 > other.y);
    }

    /**
     * Moves this claim to the new specified positions on the x- and y-axis.
     *
     * @param newX new position on the x-axis
     * @param newY new position on the y-axis
     */
    void moveTo(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}