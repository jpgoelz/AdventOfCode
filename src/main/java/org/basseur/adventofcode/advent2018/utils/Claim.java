package org.basseur.adventofcode.advent2018.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    //    HashMap<Integer, Claim> overlappingClaims;
    private int id;
    private int x1;
    private int y1;
    private int width;
    private int height;

    private int x2;
    private int y2;

    public Claim(String claimsListItem) {
        Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(claimsListItem);
        while (matcher.find()) {
            this.id = Integer.parseInt(matcher.group(1));
            this.x1 = Integer.parseInt(matcher.group(2));
            this.y1 = Integer.parseInt(matcher.group(3));
            this.width = Integer.parseInt(matcher.group(4));
            this.height = Integer.parseInt(matcher.group(5));
        }
        x2 = x1 + width;
        y2 = y1 + height;
    }

    int getId() {
        return id;
    }

    int getX1() {
        return x1;
    }

    int getY1() {
        return y1;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void addOverlapping(Claim claim) {
    }

    boolean overlaps(Claim other) {
        if (this.x2 < other.x1 || this.x1 > other.x2) {
            return false;
        }
        if (this.y2 < other.y1 || this.y1 > other.y2) {
            return false;
        } else {
            return true;
        }
    }
//    HashMap
}