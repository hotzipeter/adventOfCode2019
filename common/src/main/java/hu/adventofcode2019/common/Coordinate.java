package hu.adventofcode2019.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordinate) {
        this.x = coordinate.x;
        this.y = coordinate.y;
    }

    public static Coordinate multiply(Coordinate baseCoordinate, int amount) {
        return new Coordinate(baseCoordinate.getX() * amount, baseCoordinate.getY() * amount);
    }

    public static Coordinate add(Coordinate coordinate1, Coordinate coordinate2) {
        return new Coordinate(coordinate1.getX() + coordinate2.getX(), coordinate1.getY() + coordinate2.getY());
    }

    public int getManhattamDistanceFromCentre() {
        return Math.abs(this.x) + Math.abs(this.y);
    }

    public static int getClosestDistanceFromCentre(List<Coordinate> coordinates) {
        int minDistance = Integer.MAX_VALUE;
        for (Coordinate coordinate : coordinates) {
            int distance = coordinate.getManhattamDistanceFromCentre();
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        return minDistance;
    }
}
