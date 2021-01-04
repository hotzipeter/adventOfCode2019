package hu.adventofcode2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Day01Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("day01.txt");
        FileReader inputReader = new FileReader(input);
        BufferedReader bufferedReader = new BufferedReader(inputReader);
        List<Module> modules = bufferedReader.lines().map(Module::new).collect(Collectors.toList());
        int allRequiredFuel = modules.stream().map(Module::getRequiredFuel).reduce(Integer::sum).get();
        System.out.println("Task1: " + allRequiredFuel);
        int allRequiredFuelWithFuelMass = modules.stream().map(Module::getRequiredFuelWithFuelMass).reduce(Integer::sum).get();
        System.out.println("Task2: "+allRequiredFuelWithFuelMass);

    }
}
