package ru.orudzhev.utilities;

import ru.orudzhev.enums.OperandType;
import ru.orudzhev.models.CalcEntity;

/**
 * Класс для проведения арифметический действий над числами
 */
public class Calc {

    private CalcEntity calcEntity;

    public Calc(CalcEntity calcEntity) {
        this.calcEntity = calcEntity;
    }

    public void calculate() {
        switch (calcEntity.getArithmeticOperation()) {
            case "+":
                int result = calcEntity.getFirstOperand() + calcEntity.getSecondOperand();
                if (calcEntity.getOperandType().equals(OperandType.ARABIC)) {
                    System.out.println(result);
                } else {
                    System.out.println(RomanConverter.arabicToRoman(result));
                }
                break;
            case "-":
                result = calcEntity.getFirstOperand() - calcEntity.getSecondOperand();
                if (calcEntity.getOperandType().equals(OperandType.ARABIC)) {
                    System.out.println(result);
                } else {
                    System.out.println(RomanConverter.arabicToRoman(result));
                }
                break;
            case "*":
                result = calcEntity.getFirstOperand() * calcEntity.getSecondOperand();
                if (calcEntity.getOperandType().equals(OperandType.ARABIC)) {
                    System.out.println(result);
                } else {
                    System.out.println(RomanConverter.arabicToRoman(result));
                }
                break;
            case "/":
                if (calcEntity.getOperandType().equals(OperandType.ARABIC)) {
                    double res = Double.valueOf(calcEntity.getFirstOperand()) / calcEntity.getSecondOperand();
                    System.out.println(res);
                } else {
                    result = calcEntity.getFirstOperand() / calcEntity.getSecondOperand();
                    System.out.println(RomanConverter.arabicToRoman(result));
                }
                break;
        }
    }
}
