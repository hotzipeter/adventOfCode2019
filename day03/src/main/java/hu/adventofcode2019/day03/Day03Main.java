package hu.adventofcode2019.day03;

import hu.adventofcode2019.common.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class Day03Main {
    public static void main(String[] args) {
        try {
            List<Wire> wires = FileProcessor.processFileByPathWithStringProcessFunction("day03/src/main/resources/day03.txt", Wire::new);
            Wire firstWire = wires.get(0);
            Wire secondWire = wires.get(1);
            int minDistance = Wire.getClosestManhattamDistanceOfIntersectPoint(firstWire, secondWire);
            System.out.println("Task1: " + minDistance);
            int minStepDistance = Wire.getClosestStepNumberOfIntersecPoint(firstWire, secondWire);
            System.out.println("Task2: " + minStepDistance);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Fájl nem található");
        }
    }
}
