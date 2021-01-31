package hu.adventofcode2019.intcode;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntCodeProcessor {
    @Getter
    private List<Integer> commands;
    @Getter
    private List<Integer> inputs;
    @Getter
    private List<Integer> outputs;

    public IntCodeProcessor(String programCommands) {
        commands = Arrays.stream(programCommands.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
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

    public int getFirstNotNullOutputByInputs(List<Integer> inputs) {
        this.inputs = inputs;
        processCommands();
        return outputs.stream().filter(integer -> integer != 0).findFirst().orElse(0);
    }

    public void resetInputsAndOutputs() {
        inputs.clear();
        outputs.clear();
    }

    public void modifyFirstAndSecondCommand(int firstValue, int secondValue) {
        modifyCommand(1, firstValue);
        modifyCommand(2, secondValue);
    }

    public void modifyCommand(int index, int value) {
        commands.set(index, value);
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

    private int processCommand(int cursor) {
        int command = commands.get(cursor);
        List<Integer> params = getParamsForCommand(command, cursor);
        switch (command % 100) {
            case 1:
                commands.set(params.get(2), params.get(0) + params.get(1));
                return cursor + 4;
            case 2:
                commands.set(params.get(2), params.get(0) * params.get(1));
                return cursor + 4;
            case 3:
                commands.set(params.get(0), inputs.remove(0));
                return cursor + 2;
            case 4:
                outputs.add(params.get(0));
                return cursor + 2;
            case 5:
                if (params.get(0) != 0) {
                    return params.get(1);
                } else {
                    return cursor + 3;
                }
            case 6:
                if (params.get(0) == 0) {
                    return params.get(1);
                } else {
                    return cursor + 3;
                }
            case 7:
                int lessThan = params.get(0) < params.get(1) ? 1 : 0;
                commands.set(params.get(2), lessThan);
                return cursor + 4;
            case 8:
                int equals = params.get(0).equals(params.get(1)) ? 1 : 0;
                commands.set(params.get(2), equals);
                return cursor + 4;
            default:
                System.out.println(command);
                throw new UnsupportedOperationException();
        }
    }

    private List<Integer> getParamsForCommand(int command, int cursor) {
        List<Integer> params = new ArrayList<>();
        switch (command % 100) {
            case 1:
            case 2:
            case 7:
            case 8:
                params.add(getParamForCommand(command, cursor, 1));
                params.add(getParamForCommand(command, cursor, 2));
                params.add(commands.get(cursor + 3));
                break;
            case 3:
                params.add(commands.get(cursor + 1));
                break;
            case 4:
                params.add(getParamForCommand(command, cursor, 1));
                break;
            case 5:
            case 6:
                params.add(getParamForCommand(command, cursor, 1));
                params.add(getParamForCommand(command, cursor, 2));
                break;
        }

        return params;
    }

    private int getParamForCommand(int command, int cursor, int position) {
        String commandString = getCommandStringByCommand(command);
        char mode = commandString.charAt(3 - position);
        switch (mode) {
            case '0':
                return commands.get(commands.get(cursor + position));
            case '1':
                return commands.get(cursor + position);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private String getCommandStringByCommand(int command) {
        StringBuilder commandString = new StringBuilder(String.valueOf(command));
        while (commandString.length() < 5) {
            commandString.insert(0, '0');
        }
        return commandString.toString();
    }
}
