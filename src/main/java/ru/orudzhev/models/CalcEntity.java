package ru.orudzhev.models;

import ru.orudzhev.constants.Const;
import ru.orudzhev.enums.OperandType;
import ru.orudzhev.utilities.Validation;

/**
 * Класс для хранения сущности для расчета
 */
public class CalcEntity {

    private Integer firstOperand;

    private Integer secondOperand;

    private String arithmeticOperation;

    private OperandType operandType;

    public Integer getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Integer firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Integer getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Integer secondOperand) {
        this.secondOperand = secondOperand;
    }

    public String getArithmeticOperation() {
        return arithmeticOperation;
    }

    public void setArithmeticOperation(String arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public OperandType getOperandType() {
        return operandType;
    }

    public void setOperandType(OperandType operandType) {
        this.operandType = operandType;
    }

    public CalcEntity() {
        String[] operands = Validation.getOperands();
        this.arithmeticOperation = Validation.getArithmeticOperation();
        if (Validation.isRomans()) {
            firstOperand = Const.ROMAN_NUMBERS.get(operands[0].trim());
            secondOperand = Const.ROMAN_NUMBERS.get(operands[1].trim());
            operandType = OperandType.ROMAN;
        } else {
            firstOperand = Integer.parseInt(operands[0].trim());
            secondOperand = Integer.parseInt(operands[1].trim());
            operandType = OperandType.ARABIC;
        }
    }
}
