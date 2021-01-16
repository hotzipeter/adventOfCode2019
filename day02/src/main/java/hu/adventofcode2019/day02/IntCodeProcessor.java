package hu.adventofcode2019.day02;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntCodeProcessor {
    @Getter
    private List<Integer> commands;

    public IntCodeProcessor(String programCommands) {
        commands = Arrays.stream(programCommands.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int processCommands() {
        int cursor = 0;
        List<Integer> commandsCopy = new ArrayList<>(commands);
        while (commandsCopy.get(cursor) != 99) {
            cursor = processCommand(cursor);
        }
        int returnValue = commands.get(0);
        commands = new ArrayList<>(commandsCopy);
        return returnValue;
    }

    public void modifyFirstAndSecondCommand(int firstValue, int secondValue) {
        modifyCommand(1, firstValue);
        modifyCommand(2, secondValue);
    }

    public void modifyCommand(int index, int value) {
        commands.set(index, value);
    }

    public int processCommand(int cursor) {
        int command = commands.get(cursor);
        List<Integer> params = getParamForCommand(command, cursor);
        switch (command) {
            case 1:
                commands.set(params.get(2), params.get(0) + params.get(1));
                return cursor + 4;
            case 2:
                commands.set(params.get(2), params.get(0) * params.get(1));
                return cursor + 4;
            default:
                return 0;
        }
    }

    public List<Integer> getParamForCommand(int command, int cursor) {
        List<Integer> params = new ArrayList<>();
        switch (command) {
            case 1:
            case 2:
                params.add(commands.get(commands.get(cursor + 1)));
                params.add(commands.get(commands.get(cursor + 2)));
                params.add(commands.get(cursor + 3));
        }

        return params;
    }

    public int modifyFirstAndSecondAndProcessCommands(int first, int second) {
        modifyFirstAndSecondCommand(first, second);
        return processCommands();
    }

    public int searchResultWithRange(int rangeBottom, int rangeTop, int searchResult) {
        for (int firstValue = rangeBottom; firstValue <= rangeTop; firstValue++) {
            for (int secondValue = rangeBottom; secondValue <= rangeTop; secondValue++) {
                int result = modifyFirstAndSecondAndProcessCommands(firstValue, secondValue);
                if (result == searchResult) {
                    return Integer.parseInt(String.valueOf(firstValue) + secondValue);
                }
            }
        }
        return 0;
    }
}
