package hu.adventofcode2019.day01;

import hu.adventofcode2019.common.FileProcessor;

import java.io.FileNotFoundException;
import java.util.List;

public class Day01Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<Module> modules = FileProcessor.processFileByPath("day01/src/main/resources/day01.txt", Module::new);
        int allRequiredFuel = modules.stream().map(Module::getRequiredFuel).reduce(Integer::sum).orElse(0);
        System.out.println("Task1: " + allRequiredFuel);
        int allRequiredFuelWithFuelMass = modules.stream().map(Module::getRequiredFuelWithFuelMass).reduce(Integer::sum).orElse(0);
        System.out.println("Task2: "+allRequiredFuelWithFuelMass);

    }
}
