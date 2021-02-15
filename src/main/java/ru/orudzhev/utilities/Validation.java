package ru.orudzhev.utilities;

import ru.orudzhev.constants.Const;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс для проверки строки на валидность и дальнейших действий с ней
 */
public class Validation {

    private static boolean romans;

    private static String[] operands;

    private static String arithmeticOperation;

    public static String[] getOperands() {
        return operands;
    }

    public static String getArithmeticOperation() {
        return arithmeticOperation;
    }

    public static boolean isRomans() {
        return romans;
    }

    /**
     * Проверка на валидность входящей строки
     *
     * @param inputString - входящая строка
     * @return - true если валидна, false если не валидна
     */
    public static boolean validationCheck(String inputString) {
        operands = inputString.replaceAll("\\s", "").split("\\W");
        arithmeticOperation = inputString.replaceAll("[^\\W]", "").trim();

        Optional<String> tempArithmeticOperation = Const.ARITHMETIC_OPERATIONS
                .stream()
                .filter(operation -> operation.equals(arithmeticOperation))
                .findAny();

        if (!tempArithmeticOperation.isPresent()) {
            return false;
        }

        romans = checkRoman(Arrays.asList(operands));
        boolean arabic = checkArabic(Arrays.asList(operands));
        return (romans || arabic);
    }

    private static boolean checkRoman(List<String> operands) {
        List<Integer> tempOperands = new ArrayList<>();
        operands.forEach(operand -> {
            if (Const.ROMAN_NUMBERS.get(operand) != null) {
                tempOperands.add(Const.ROMAN_NUMBERS.get(operand));
            }
        });
        return tempOperands.size() == 2;
    }

    private static boolean checkArabic(List<String> operands) {
        List<Integer> tempOperands;
        try {
            tempOperands = operands
                    .stream()
                    .map(operand -> Integer.parseInt(operand.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (tempOperands.size() == 2) {
            return tempOperands.get(0) >= 1 &&
                    tempOperands.get(0) <= 10 &&
                    tempOperands.get(1) >= 1 &&
                    tempOperands.get(1) <= 10;
        }
        return false;
    }
}
