package hu.adventofcode2019.day05;

import hu.adventofcode2019.common.FileProcessor;
import hu.adventofcode2019.intcode.IntCodeProcessor;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day05Main {
    public static void main(String[] args) {
        try {
            IntCodeProcessor intCodeProcessor = FileProcessor.processFileByPathWithStringProcessFunction("day05/src/main/resources/day05.txt", IntCodeProcessor::new).get(0);
            ArrayList<Integer> inputsForTask1  = new ArrayList<>();
            inputsForTask1.add(1);
            int task1Result = intCodeProcessor.getFirstNotNullOutputByInputs(inputsForTask1);
            System.out.println("Task1: " + task1Result);

            intCodeProcessor.resetInputsAndOutputs();
            ArrayList<Integer> inputsForTask2  = new ArrayList<>();
            inputsForTask2.add(5);
            int task2Result = intCodeProcessor.getFirstNotNullOutputByInputs(inputsForTask2);
            System.out.println("Task2: " + task2Result);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Fájl nem található");
        }
    }
}
