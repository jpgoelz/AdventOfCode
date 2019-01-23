package org.basseur.adventofcode.advent2018.utils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim extends Rectangle {
    private int id;
    private Rectangle rectangle;

    public Claim(String claimsListItem) {
        Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(claimsListItem);
        if (matcher.find()) {
            this.id = Integer.parseInt(matcher.group(1));
            this.x = Integer.parseInt(matcher.group(2));
            this.y = Integer.parseInt(matcher.group(3));
            this.width = Integer.parseInt(matcher.group(4));
            this.height = Integer.parseInt(matcher.group(5));
            this.rectangle = new Rectangle(x, y, width, height);
        } else {
            throw new IllegalArgumentException(claimsListItem + " does not match Pattern");
        }
    }

    public int getId() {
        return id;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean intersects(Claim other) {
        return this.rectangle.intersects(other.rectangle);
    }

    public Rectangle intersection(Claim other) {
        return this.rectangle.intersection(other.rectangle);
    }
}