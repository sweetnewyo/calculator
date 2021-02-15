package ru.orudzhev.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Const {

    public static final List<String> ARITHMETIC_OPERATIONS = new ArrayList<>() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public static final Map<String, Integer> ROMAN_NUMBERS = new HashMap<>() {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};
}
