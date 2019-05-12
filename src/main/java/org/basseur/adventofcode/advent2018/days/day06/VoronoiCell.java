package org.basseur.adventofcode.advent2018.days.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that defines Voronoi cells to be used in {@link Day06}.
 * A Voronoi cell is the region of coordinates closest to the corresponding
 * Voronoi seed but not of equal distance to other seeds.
 *
 * @author Jan Philipp G&ouml;lz
 */
public class VoronoiCell {
    /** Set to true if it has member coordinates on the outer border */
    public boolean isInfinite;
    /** x coordinate of the Voronoi seed of this cell */
    public int x;
    /** y coordinate of the Voronoi seed of this cell */
    public int y;
    /** A list of all coordinates closest to the Voronoi seed of this cell */
    private List<Coordinate> coordinateList = new ArrayList<>();

    /**
     * A constructor setting the coordinates for the Voronoi seed of this cell.
     *
     * @param x the x coordinate of this cell's Voronoi seed
     * @param y the y coordinate of this cell's Voronoi seed
     */
    public VoronoiCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isInfinite = false;
    }

    /**
     * Adds coordinates to this Voronoi cell.
     * The coordinates should correspond to a point that is closest only to this cell's Voronoi seed.
     *
     * @param x the coordinates x coordinate
     * @param y the coordinates y coordinate
     */
    public void addCoordinate(int x, int y) {
        coordinateList.add(new Coordinate(x, y));
    }

    /**
     * Returns the total area of this Voronoi cell.
     * It is calculated as the amount of points, that are closest only to this Voronoi cell's seed.
     *
     * @return the area of this cell
     */
    public int voronoiArea() {
        return coordinateList.size();
    }

    /**
     * Returns the distance of this Voronoi cell's seed to the given coordinate
     *
     * @param coordinate the coordinate to calculate the distance to
     * @return Manhattan distance between this Voronoi cell's seed and the coordinate given
     */
    public int distanceTo(Coordinate coordinate) {
        Integer distanceX = Math.abs(this.x - coordinate.x);
        Integer distanceY = Math.abs(this.y - coordinate.y);

        return distanceX + distanceY;
    }
}
