package ru.orudzhev.utilities;

import ru.orudzhev.exceptions.InvalidStringException;
import ru.orudzhev.models.CalcEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс для чтения данных с консоли
 */
public class Reader {

    public static void read() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean doNotStopReading = true;
            while (doNotStopReading) {
                String inputString = reader.readLine();
                doNotStopReading = Validation.validationCheck(inputString);
                if (doNotStopReading) {
                    Calc calc = new Calc(new CalcEntity());
                    calc.calculate();
                    System.out.println();
                }
            }
            throw new InvalidStringException("Invalid input string");
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }
}
