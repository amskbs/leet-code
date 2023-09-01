package org.amskbs.easy.n14_longest_common_prefix;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String[]> inputs = List.of(
                new String[]{"flower", "flow", "flight"},
                new String[]{"dog", "racecar", "car"}
        );
        for (String[] input : inputs) {
            System.out.println(main.longestCommonPrefix(input));
        }
    }

    public String longestCommonPrefix(String[] strs) {
        int currentIndex = 0;
        StringBuilder prefix = new StringBuilder();
        while (true) {
            char currentChar;
            if (strs[0].length() >= currentIndex + 1) {
                currentChar = strs[0].charAt(currentIndex);
            } else {
                break;
            }
            boolean equal = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < currentIndex + 1) {
                    equal = false;
                    break;
                }

                if (strs[i].charAt(currentIndex) != currentChar) {
                    equal = false;
                    break;
                }
            }
            if (equal) {
                prefix.append(currentChar);
                currentIndex++;
            } else {
                break;
            }
        }
        return prefix.toString();
    }
}
