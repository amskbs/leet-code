package org.amskbs.easy.roman_to_integer;


import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    */
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.romanToInt1("MCMXCIV"));
        System.out.println(main.romanToInt2("MCMXCIV"));
    }

    public int romanToInt1(String s) {
        Map<Character, Integer> regulars = new HashMap<>();
        regulars.put('I', 1);
        regulars.put('V', 5);
        regulars.put('X', 10);
        regulars.put('L', 50);
        regulars.put('C', 100);
        regulars.put('D', 500);
        regulars.put('M', 1000);
        Map<String, Integer> exceptions = new HashMap<>();
        exceptions.put("IV", 4);
        exceptions.put("IX", 9);
        exceptions.put("XL", 40);
        exceptions.put("XC", 90);
        exceptions.put("CD", 400);
        exceptions.put("CM", 900);
        int index = 0;
        int result = 0;
        while (true) {
            if (index > s.length() - 1) {
                break;
            }

            if (index < s.length() - 1) {
                //check on exception
                String mayBeException = s.substring(index, index + 2);
                Integer exceptionValue = exceptions.get(mayBeException);
                if (exceptionValue != null) {
                    index += 2;
                    result += exceptionValue;
                    continue;
                }
            }

            result += regulars.get(s.charAt(index));
            index++;
        }
        return result;
    }

    private static class RomanLetter {
        public int value;
        Map<Character, Integer> exceptions;

        public static RomanLetter of(int value) {
            RomanLetter romanLetter = new RomanLetter();
            romanLetter.value = value;
            return romanLetter;
        }

        public static RomanLetter of(int value, Map<Character, Integer> exceptions) {
            RomanLetter romanLetter = new RomanLetter();
            romanLetter.value = value;
            romanLetter.exceptions = exceptions;
            return romanLetter;
        }
    }

    public int romanToInt2(String s) {
        Map<Character, RomanLetter> letters = new HashMap<>();
        letters.put('I', RomanLetter.of(1, new HashMap<Character, Integer>() {{
            put('V', 4);
            put('X', 9);
        }}));
        letters.put('V', RomanLetter.of(5));
        letters.put('X', RomanLetter.of(10, new HashMap<Character, Integer>() {{
            put('L', 40);
            put('C', 90);
        }}));
        letters.put('L', RomanLetter.of(50));
        letters.put('C', RomanLetter.of(100, new HashMap<Character, Integer>() {{
            put('D', 400);
            put('M', 900);
        }}));
        letters.put('D', RomanLetter.of(500));
        letters.put('M', RomanLetter.of(1000));
        int index = 0;
        int result = 0;
        while (true) {
            if (index > s.length() - 1) {
                break;
            }

            RomanLetter romanLetter = letters.get(s.charAt(index));
            if (index < s.length() - 1 && romanLetter.exceptions != null) {
                //check on exception
                char nextChar = s.charAt(index + 1);
                Integer exceptionValue = romanLetter.exceptions.get(nextChar);
                if (exceptionValue != null) {
                    index += 2;
                    result += exceptionValue;
                    continue;
                }
            }

            result += romanLetter.value;
            index++;
        }
        return result;
    }
}
