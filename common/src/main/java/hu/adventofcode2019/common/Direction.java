package hu.adventofcode2019.common;

import lombok.Getter;

public enum Direction {
    R(new Coordinate(1,0)),D(new Coordinate(0,-1)),L(new Coordinate(-1, 0)),U(new Coordinate(0,1));
    @Getter
    private final Coordinate base;

    Direction(Coordinate base) {
        this.base = base;
    }
}
