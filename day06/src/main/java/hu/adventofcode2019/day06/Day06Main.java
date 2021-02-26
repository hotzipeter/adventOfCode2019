package hu.adventofcode2019.day06;

import hu.adventofcode2019.common.FileProcessor;

import java.io.FileNotFoundException;

public class Day06Main {
    public static void main(String[] args) {
        try {
            OrbitMap orbitMap = FileProcessor.processFileByPathWithListOfStringProcessFunction("day06/src/main/resources/day06.txt", OrbitMap::new);
            int sumOfOrbits = orbitMap.getSumOfOrbits();
            System.out.println("Task1: "+sumOfOrbits);
            int distance = orbitMap.getDistanceBetweenObjects("YOU", "SAN");
            System.out.println("Task2: "+distance);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Fájl nem található");
        }
    }
}
