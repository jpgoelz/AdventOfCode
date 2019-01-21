package org.basseur.adventofcode.advent2018.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {
    private static HashSet<Point> coordinatesWithClaims;
    private static HashSet<Point> coordinatesWithMultipleClaims;
    private int id;
    private int posX;
    private int posY;
    private int width;
    private int height;
    private List<Point> claimCoordinates;

    public Claim(String claimsListItem) {
        Pattern pattern = Pattern.compile("#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(claimsListItem);
        while (matcher.find()) {
            this.id = Integer.parseInt(matcher.group(1));
            this.posX = Integer.parseInt(matcher.group(2));
            this.posY = Integer.parseInt(matcher.group(3));
            this.width = Integer.parseInt(matcher.group(4));
            this.height = Integer.parseInt(matcher.group(5));
        }
        fillClaimCoordinates();
        addClaimCoordinatesToStaticLists();
    }

    public static int getNumberOfMultipleClaims() {
        return coordinatesWithMultipleClaims.size();
    }

    private void fillClaimCoordinates() {
        claimCoordinates = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                claimCoordinates.add(new Point(posX + i, posY + j));
            }
        }
    }

    private void addClaimCoordinatesToStaticLists() {
        for (Point claimCoordinate : this.claimCoordinates) {
            if (!Claim.coordinatesWithClaims.add(claimCoordinate)) {
                Claim.coordinatesWithMultipleClaims.add(claimCoordinate);
            }
        }
    }
}
