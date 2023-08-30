package org.amskbs.easy.n26_remove_duplicates_from_sorted_array;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<int[]> inputs = List.of(
                new int[]{1, 1, 2},
                new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

        for (int[] input : inputs) {
            int k = main.removeDuplicates(input);
            System.out.println(k);
            System.out.println(Arrays.toString(input));
        }
    }

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
