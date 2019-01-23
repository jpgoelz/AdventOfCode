package org.basseur.adventofcode.advent2018.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private final int id;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public Claim(String claimsListItem) {
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

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean intersects(Claim other) {
        int thisX2 = this.x + this.width;
        int thisY2 = this.y + this.height;
        int otherX2 = other.x + other.width;
        int otherY2 = other.y + other.height;

        return (this.x < otherX2) && (thisX2 > other.x) && (this.y < otherY2) && (thisY2 > other.y);
    }
}