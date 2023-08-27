package org.amskbs.easy.n219_contains_duplicate_II;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Input> inputs = List.of(
                new Input(new int[]{1, 2, 3, 1}, 3),
                new Input(new int[]{1, 0, 1, 1}, 1),
                new Input(new int[]{1, 2, 3, 1, 2, 3}, 2)
        );

        for (Input input : inputs) {
            System.out.println(main.containsNearbyDuplicate(input.array, input.k));
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer lastIndexOfNum = map.get(nums[i]);
            if (lastIndexOfNum != null) {
                if (i - lastIndexOfNum <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    private static class Input {
        int[] array;
        int k;

        public Input(int[] array, int k) {
            this.array = array;
            this.k = k;
        }
    }
}
