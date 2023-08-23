package org.amskbs.easy.majority_element;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than n/2 times.
    You may assume that the majority element always exists in the array.
     */
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(main.majorityElement(new int[]{6, 5, 5}));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > nums.length / 2 && !map.containsKey(nums[i])) {
                continue;
            }
            Integer count = map.merge(nums[i], 1, (oldValue, newValue) -> oldValue + 1);
            if (count > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
