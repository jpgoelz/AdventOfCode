package org.basseur.adventofcode.advent2018.utils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private int id;
    private Rectangle rectangle;

    public Claim(String claimsListItem) {
        Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(claimsListItem);
        while (matcher.find()) {
            this.id = Integer.parseInt(matcher.group(1));
            int x = Integer.parseInt(matcher.group(2));
            int y = Integer.parseInt(matcher.group(3));
            int width = Integer.parseInt(matcher.group(4));
            int height = Integer.parseInt(matcher.group(5));
            this.rectangle = new Rectangle(x, y, width, height);
        }
    }

    public int getId() {
        return id;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public Rectangle overlap(Claim other) {
        return this.rectangle.intersection(other.rectangle);
    }

    public boolean overlaps(Claim other) {
        return this.rectangle.intersects(other.rectangle);
    }
}