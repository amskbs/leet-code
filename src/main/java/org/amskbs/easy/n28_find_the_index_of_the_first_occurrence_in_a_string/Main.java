package org.amskbs.easy.n28_find_the_index_of_the_first_occurrence_in_a_string;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        List<Input> inputs = List.of(
                new Input("sadbutsad", "sad"),
                new Input("leetcode", "leeto")
        );

        for (Input input : inputs) {
            System.out.println(main.strStr(input.haystack, input.needle));
        }
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) {
            return 0;
        }
        if (needle.length() == 0) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            boolean equal = true;
            for (int j = 1; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                return i;
            }
        }
        return -1;
    }

    private record Input(String haystack, String needle) {
    }
}
