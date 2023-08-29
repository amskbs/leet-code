package org.amskbs.easy.n13_roman_to_integer;


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
        System.out.println(main.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<Character, Integer> letters = new HashMap<>();
        letters.put('I', 1);
        letters.put('V', 5);
        letters.put('X', 10);
        letters.put('L', 50);
        letters.put('C', 100);
        letters.put('D', 500);
        letters.put('M', 1000);
        int index = 0;
        int result = 0;
        while (true) {
            if (index > s.length() - 1) {
                break;
            }

            Integer thisValue = letters.get(s.charAt(index));

            if (index < s.length() - 1) {
                int nextValue = letters.get(s.charAt(index + 1));
                if (nextValue > thisValue) {
                    index += 2;
                    result += nextValue - thisValue;
                    continue;
                }
            }

            result += thisValue;
            index++;
        }
        return result;
    }
}
