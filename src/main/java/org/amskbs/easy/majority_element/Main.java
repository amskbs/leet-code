package org.amskbs.easy.majority_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    /*
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than n/2 times.
    You may assume that the majority element always exists in the array.
     */
    public static void main(String[] args) {
        Main main = new Main();
        int[] array1 = new int[]{2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
        int[] array2 = new int[]{6, 5, 5};
        int[] array3 = new int[]{6, 5, 5, 6, 6};
        List<int[]> arrays = List.of(array1, array2, array3);
        for (int[] array : arrays) {
            System.out.println("v1 " + main.majorityElement(array));
            System.out.println("v2 " + main.majorityElement2(array));
            System.out.println("v3 " + main.majorityElement3(array));
            System.out.println();
        }

    }

    public int majorityElement(int[] nums) {
        if (nums.length <= 2) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prevCount = map.get(nums[i]);
            if (i > nums.length / 2 && prevCount == null) {
                continue;
            }
            Integer count = map.merge(nums[i], 1, (oldValue, newValue) -> oldValue + 1);
            if (count > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > nums.length / 2)
                .findFirst()
                .get().getKey();
    }

    public int majorityElement3(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
