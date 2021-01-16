package hu.adventofcode2019.day02;

import hu.adventofcode2019.common.FileProcessor;

import java.io.FileNotFoundException;

public class Day02Main {
    public static void main(String[] args) throws FileNotFoundException {
        IntCodeProcessor intCodeProcessor = FileProcessor.processFileByPath("day02/src/main/resources/day02.txt", IntCodeProcessor::new).get(0);
        int task1Result = intCodeProcessor.modifyFirstAndSecondAndProcessCommands(12,2);
        System.out.println("Task1: " + task1Result);
        int task2Result = intCodeProcessor.searchResultWithRange(0,99, 19690720);
        System.out.println("Task2: " + task2Result);
    }
}
