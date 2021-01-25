package hu.adventofcode2019.day03;

import hu.adventofcode2019.common.Coordinate;
import hu.adventofcode2019.common.Direction;
import hu.adventofcode2019.common.Vector;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Wire {
    private final List<Vector> wireParts;

    public Wire(String wireDirections) {
        wireParts = new ArrayList<>();
        String[] wireDirectionArray = wireDirections.split(",");
        Coordinate actualCoordinate = new Coordinate(0, 0);
        for (String wireDirection : wireDirectionArray) {
            Direction direction = Direction.valueOf(String.valueOf(wireDirection.charAt(0)));
            int amount = Integer.parseInt(wireDirection.substring(1));
            Coordinate modifyCoordinate = Coordinate.multiply(direction.getBase(), amount);
            Coordinate newCoordinate = Coordinate.add(actualCoordinate, modifyCoordinate);
            wireParts.add(new Vector(new Coordinate(actualCoordinate), newCoordinate));
            actualCoordinate = newCoordinate;
        }
    }

    public static List<Coordinate> getIntersectCoordinates(Wire firstWire, Wire secondWire) {
        List<Coordinate> intersectList = new ArrayList<>();
        for (Vector firstVector : firstWire.getWireParts()) {
            for (Vector secondVector : secondWire.getWireParts()) {
                Coordinate intersectCoodinate = firstVector.getIntersectIfHas(secondVector);
                if (intersectCoodinate != null && intersectCoodinate.getX() != 0 && intersectCoodinate.getY() != 0) {
                    intersectList.add(intersectCoodinate);
                }
            }
        }
        return intersectList;
    }

    public static int getClosestManhattamDistanceOfIntersectPoint(Wire firstWire, Wire secondWire) {
        List<Coordinate> intersectCoordinateList = getIntersectCoordinates(firstWire, secondWire);
        return Coordinate.getClosestDistanceFromCentre(intersectCoordinateList);
    }

    public static Map<Coordinate, Integer> getStepNumbersToIntesectPoints(Wire firstWire, Wire secondWire) {
        int firstWireSteps = 0;
        Map<Coordinate, Integer> stepNumberMap = new LinkedHashMap<>();
        for (Vector firstVector : firstWire.getWireParts()) {
            int secondWireSteps = 0;
            for (Vector secondVector : secondWire.getWireParts()) {
                Coordinate intersectCoodinate = firstVector.getIntersectIfHas(secondVector);
                if (intersectCoodinate != null && intersectCoodinate.getX() != 0 && intersectCoodinate.getY() != 0
                        && !stepNumberMap.containsKey(intersectCoodinate)) {
                    int secondWireStepNumber = secondWireSteps + secondVector.getDiffBetweenFirstPiointAndCoordinate(intersectCoodinate);
                    int firstWireStepNumber = firstWireSteps + firstVector.getDiffBetweenFirstPiointAndCoordinate(intersectCoodinate);
                    stepNumberMap.put(intersectCoodinate,firstWireStepNumber + secondWireStepNumber);
                }
                secondWireSteps += secondVector.getDiffBetweenFirstAndSecondPoint();
            }
            firstWireSteps += firstVector.getDiffBetweenFirstAndSecondPoint();
        }
        return stepNumberMap;
    }

    public static int getClosestStepNumberOfIntersecPoint(Wire firstWire, Wire secondWire) {
        Map<Coordinate, Integer> stepNumberMap = getStepNumbersToIntesectPoints(firstWire, secondWire);
        return stepNumberMap.values().stream().min(Integer::compareTo).get();
    }
}
