package hu.adventofcode2019.day04;

import java.util.function.Function;

public class PasswordValidator {
    public static boolean validateByTask1Rules(String password) {
        char[] passwordArray = password.toCharArray();
        boolean isIncreasing = true;
        boolean hasDuplicate = false;

        for (int index = 1; index < passwordArray.length; index++) {
            if (passwordArray[index] < passwordArray[index - 1]) {
                isIncreasing = false;
            }
            if (passwordArray[index] == passwordArray[index - 1]) {
                hasDuplicate = true;
            }
        }

        return  isIncreasing && hasDuplicate;
    }

    public static boolean validateByTask2Rules(String password) {
        char[] passwordArray = password.toCharArray();
        boolean isIncreasing = true;
        String regexp = "[1-9]*(.)(?!\\1)(.)\\2(?!\\2)[1-9]*";
        String regexp2 = "[1-9]*(.)(?!\\1)(.)\\2$";
        String regexp3 = "^(.)\\1(?!\\1)[1-9]*";

        for (int index = 1; index < passwordArray.length && isIncreasing; index++) {
            if (passwordArray[index] < passwordArray[index - 1]) {
                isIncreasing = false;
            }
        }

        return  isIncreasing && ((password.matches(regexp)) || password.matches(regexp2) || password.matches(regexp3));
    }

    public static int countValidPasswordsByRuleFunctionAndIntervall(Function<String, Boolean> ruleFunction, int start, int end) {
        int counter = 0;
        for (int index = start; index<=end; index++) {
            if (ruleFunction.apply(String.valueOf(index))) {
                counter ++;
            }
        }
        return counter;
    }
}
