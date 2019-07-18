package org.basseur.adventofcode.advent2018.days.day06;

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
    /** The area of coordinates closest only to the Voronoi seed of this cell */
    public int voronoiArea;

    /**
     * A constructor setting the coordinates for the Voronoi seed of this cell.
     *
     * @param x the x coordinate of this cell's Voronoi seed
     * @param y the y coordinate of this cell's Voronoi seed
     */
    public VoronoiCell(int x, int y) {
        this.x = x;
        this.y = y;
        this.voronoiArea = 0;
        this.isInfinite = false;
    }

    /**
     * Returns the distance of this Voronoi cell's seed to the given coordinate
     *
     * @param x the x coordinate to calculate the distance to
     * @param y the y coordinate to calculate the distance to
     * @return Manhattan distance between this Voronoi cell's seed and the coordinate given
     */
    public int distanceTo(int x, int y) {
        Integer distanceX = Math.abs(this.x - x);
        Integer distanceY = Math.abs(this.y - y);

        return distanceX + distanceY;
    }
}
