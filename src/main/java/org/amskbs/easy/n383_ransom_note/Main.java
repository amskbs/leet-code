package org.amskbs.easy.n383_ransom_note;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Input> inputs = List.of(
                new Input("a", "b"),
                new Input("aa", "ab"),
                new Input("aa", "aab")
        );

        for (Input input : inputs) {
            System.out.println(main.canConstruct(input.ransomNote, input.magazine));
        }
    }

    /*
    Given two strings ransomNote and magazine
    Return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
    Each letter in magazine can only be used once in ransomNote.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteIndex = createRansomNoteLettersIndex(ransomNote);

        Map<Character, Integer> magazineIndex = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            Integer ransomNoteLetterCount = ransomNoteIndex.get(c);
            if (ransomNoteLetterCount != null) {
                Integer mergedValue = magazineIndex.merge(c, 1, (oldValue, newValue) -> oldValue + 1);
                if (mergedValue >= ransomNoteLetterCount) {
                    ransomNoteIndex.remove(c);
                    magazineIndex.remove(c);
                }
            }
        }
        return ransomNoteIndex.isEmpty();
    }

    private Map<Character, Integer> createRansomNoteLettersIndex(String ransomNote) {
        Map<Character, Integer> index = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            index.merge(c, 1, (oldValue, newValue) -> oldValue + 1);
        }
        return index;
    }

    private static class Input {
        final String ransomNote;
        final String magazine;

        public Input(String ransomNote, String magazine) {
            this.ransomNote = ransomNote;
            this.magazine = magazine;
        }
    }
}
