package org.amskbs.easy.n27_remove_element;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Input> inputs = List.of(
                new Input(new int[]{3, 2, 2, 3}, 3),
                new Input(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2)
        );

        for (Input input : inputs) {
            int x = main.removeElement(input.array, input.k);
            System.out.println(x);
            System.out.println(Arrays.toString(input.array));
        }
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    private record Input(int[] array, int k) {
    }
}
