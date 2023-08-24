package org.amskbs.easy.valid_palindrome;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> strings = List.of("A man, a plan, a canal: Panama", "race a car", " ");
        for (String string : strings) {
            System.out.println(main.isPalindrome(string));
        }
    }

    public boolean isPalindrome(String s) {
        int pointer1 = 0;
        Character character1 = sanitizeIfValid(s.charAt(pointer1));

        int pointer2 = s.length() - 1;
        Character character2 = sanitizeIfValid(s.charAt(pointer2));

        while (pointer1 < pointer2) {
            if (character1 == null) {
                character1 = sanitizeIfValid(s.charAt(pointer1));
            }
            if (character1 == null) {
                pointer1++;
                continue;
            }

            if (character2 == null) {
                character2 = sanitizeIfValid(s.charAt(pointer2));
            }
            if (character2 == null) {
                pointer2--;
                continue;
            }

            if (!character1.equals(character2)) {
                return false;
            } else {
                pointer1++;
                pointer2--;
                character1 = null;
                character2 = null;
            }
        }

        return true;
    }

    private Character sanitizeIfValid(char ch) {
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch)) {
                return Character.toLowerCase(ch);
            } else {
                return ch;
            }
        }
        if (Character.isDigit(ch)) {
            return ch;
        }
        return null;
    }
}
