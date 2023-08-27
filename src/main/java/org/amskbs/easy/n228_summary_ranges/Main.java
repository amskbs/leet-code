package org.amskbs.easy.n228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<int[]> inputs = List.of(
                new int[]{0, 1, 2, 4, 5, 7},
                new int[]{0, 2, 3, 4, 6, 8, 9},
                new int[]{0},
                new int[]{}
        );
        for (int[] input : inputs) {
            System.out.println(main.summaryRanges(input));
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int currentIntervalStart = nums[0];
        int currentIntervalEnd = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == nums[i - 1] + 1) {
                currentIntervalEnd = num;
                continue;
            } else {
                result.add(constructInterval(currentIntervalStart, currentIntervalEnd));
                currentIntervalStart = num;
                currentIntervalEnd = num;
            }
        }
        result.add(constructInterval(currentIntervalStart, currentIntervalEnd));
        return result;
    }

    private String constructInterval(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(start);
        stringBuilder.append("->");
        stringBuilder.append(end);
        return stringBuilder.toString();
    }
}
