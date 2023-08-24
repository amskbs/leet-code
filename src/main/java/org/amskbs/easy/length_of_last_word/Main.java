package org.amskbs.easy.length_of_last_word;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> strings = List.of("Hello World", "   fly me   to   the moon  ", "luffy is still joyboy");
        for (String string : strings) {
            System.out.println(main.lengthOfLastWord(string));
        }
    }

    public int lengthOfLastWord(String s) {
        int index = 0;
        int wordLength = 0;
        boolean wordStarted = false;
        int stringLength = s.length();
        while (true) {
            if (index + 1 > stringLength) {
                break;
            }
            if (s.charAt(stringLength - index - 1) == ' ') {
                if (wordStarted) {
                    return wordLength;
                } else {
                    index++;
                    continue;
                }
            }
            wordStarted = true;
            wordLength++;
            index++;
        }
        return wordLength;
    }
}
