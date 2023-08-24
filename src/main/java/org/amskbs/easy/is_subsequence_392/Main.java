package org.amskbs.easy.is_subsequence_392;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Input> inputs = List.of(
                new Input("abc", "ahbgdc"),
                new Input("axc", "ahbgdc")
        );
        for (Input input : inputs) {
            System.out.println(main.isSubsequence(input.s, input.t));
        }
    }

    public boolean isSubsequence(String s, String t) {
        int pointer1 = 0;
        int pointer2 = 0;
//        int smallStringLength = s.length();
//        int bigStringLength = t.length();
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() > t.length()) {
            return false;
        }
        while (pointer1 < s.length() && pointer2 < t.length()) {
            char ch1 = s.charAt(pointer1);
            char ch2 = t.charAt(pointer2);

            if (ch1 == ch2) {
                if (pointer1 == s.length() - 1) {
                    return true;
                }
                pointer1++;
                pointer2++;
            } else {
                pointer2++;
            }
        }
        return false;
    }

    private static class Input {
        final String s;
        final String t;

        public Input(String s, String t) {
            this.s = s;
            this.t = t;
        }
    }
}
