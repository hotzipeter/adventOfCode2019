package hu.adventofcode2019.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vector {
    private Coordinate firstPoint;
    private Coordinate secondPoint;

    public Vector(Coordinate firstPoint, Coordinate secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public boolean isHorizontal() {
        return firstPoint.getY() == secondPoint.getY();
    }

    public Coordinate getIntersectIfHas(Vector vector) {
        if (isHorizontal() && !vector.isHorizontal()) {
            int unchangedX = vector.getFirstPoint().getX();
            int unchangedY = firstPoint.getY();
            int minX = Math.min(firstPoint.getX(), secondPoint.getX());
            int maxX = Math.max(firstPoint.getX(), secondPoint.getX());
            int minY = Math.min(vector.getFirstPoint().getY(), vector.getSecondPoint().getY());
            int maxY = Math.max(vector.getFirstPoint().getY(), vector.getSecondPoint().getY());
            if (minX <= unchangedX && maxX >= unchangedX &&  unchangedY >= minY && unchangedY <= maxY) {
                return new Coordinate(unchangedX, unchangedY);
            } else {
                return null;
            }
        } else if (!isHorizontal() && vector.isHorizontal()){
            int unchangedX = firstPoint.getX();
            int unchangedY = vector.getFirstPoint().getY();
            int minX = Math.min(vector.getFirstPoint().getX(), vector.getSecondPoint().getX());
            int maxX = Math.max(vector.getFirstPoint().getX(), vector.getSecondPoint().getX());
            int minY = Math.min(firstPoint.getY(), secondPoint.getY());
            int maxY = Math.max(firstPoint.getY(), secondPoint.getY());
            if (minX <= unchangedX && maxX >= unchangedX &&  unchangedY >= minY && unchangedY <= maxY) {
                return new Coordinate(firstPoint.getX(), unchangedY);
            } else {
                return null;
            }
        }
        return null;
    }

    public int getDiffBetweenFirstAndSecondPoint() {
        if (isHorizontal()) {
            return Math.abs(firstPoint.getX() - secondPoint.getX());
        } else {
            return Math.abs(firstPoint.getY() - secondPoint.getY());
        }
    }

    public int getDiffBetweenFirstPiointAndCoordinate(Coordinate coordinate) {
        if (isHorizontal()) {
            return Math.abs(firstPoint.getX() - coordinate.getX());
        } else {
            return Math.abs(firstPoint.getY() - coordinate.getY());
        }
    }
}
