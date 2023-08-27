package org.amskbs.easy.n1_two_sum;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
     */
    public static void main(String[] args) {
        Main main = new Main();
        int[] result = main.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(result));

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            }
            int r = target - nums[i];
            if (hashMap.containsKey(r) && hashMap.get(r) != i) {
                return new int[]{hashMap.get(r), i};
            }
        }
        return new int[]{};
    }
}
