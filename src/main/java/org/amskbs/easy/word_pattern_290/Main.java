package org.amskbs.easy.word_pattern_290;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Input> inputs = List.of(
                new Input("abba", "dog cat cat dog"),
                new Input("abba", "dog dog dog dog"),
                new Input("abba", "dog cat cat fish"),
                new Input("aaaa", "dog cat cat dog"),
                new Input("aaa", "aa aa aa aa"),
                new Input("aaaa", "aa aa aa")
        );
        for (Input input : inputs) {
            System.out.println(main.wordPattern(input.pattern, input.s));
        }
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        int lastWordEndIndex = 0;
        for (char patternChar : pattern.toCharArray()) {
            int wordEndIndex = s.indexOf(' ', lastWordEndIndex + 1);
            String word = s.substring(lastWordEndIndex == 0 ? 0: lastWordEndIndex + 1, wordEndIndex == -1 ? s.length() : wordEndIndex);
            lastWordEndIndex = wordEndIndex;
            String mappedWord = charToWord.get(patternChar);
            Character mappedChar = wordToChar.get(word);
            if (mappedWord == null && mappedChar == null) {
                charToWord.put(patternChar, word);
                wordToChar.put(word, patternChar);
            } else if (!Character.valueOf(patternChar).equals(mappedChar) || !word.equals(mappedWord)) {
                return false;
            }
        }
        // word number is greater than char number
        if (lastWordEndIndex != -1) {
            return false;
        }
        return true;
    }

    private static class Input {
        final String pattern;
        final String s;

        public Input(String pattern, String s) {
            this.pattern = pattern;
            this.s = s;
        }
    }
}
