package org.amskbs.easy.n88_merge_sorted_array;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        List<Input> inputs = List.of(
                new Input(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3),
                new Input(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3),
                new Input(new int[]{1}, 1, new int[]{}, 0),
                new Input(new int[]{0}, 0, new int[]{1}, 1)
        );
        for (Input input : inputs) {
            main.merge(input.nums1, input.m, input.nums2, input.n);
            System.out.println(Arrays.toString(input.nums1));
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;
        int bigPointer = m + n - 1;

        while (pointer2 >= 0) {
            if (pointer1 >= 0 && nums1[pointer1] > nums2[pointer2]) {
                nums1[bigPointer] = nums1[pointer1];
                pointer1--;
            } else {
                nums1[bigPointer] = nums2[pointer2];
                pointer2--;
            }
            bigPointer--;
        }
    }

    private record Input(int[] nums1, int m, int[] nums2, int n) {
    }
}
