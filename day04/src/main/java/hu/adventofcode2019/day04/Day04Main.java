package hu.adventofcode2019.day04;

public class Day04Main {
    public static void main(String[] args) {
        int validPasswordsByTask1Rules = PasswordValidator
                .countValidPasswordsByRuleFunctionAndIntervall(PasswordValidator::validateByTask1Rules,236491,713787);
        System.out.println("Task1: "+ validPasswordsByTask1Rules);
        int validPasswordsByTask2Rules = PasswordValidator
                .countValidPasswordsByRuleFunctionAndIntervall(PasswordValidator::validateByTask2Rules,236491,713787);
        System.out.println("Task2: "+ validPasswordsByTask2Rules);
    }
}
