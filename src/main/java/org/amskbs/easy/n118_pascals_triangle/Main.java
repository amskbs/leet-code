package org.amskbs.easy.n118_pascals_triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.generate(4));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = Collections.singletonList(1);
        result.add(firstRow);
        if (numRows == 1) return result;


        List<Integer> secondRow = List.of(1, 1);
        result.add(secondRow);
        if (numRows == 2) return result;

        List<Integer> previousRow = secondRow;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> newRow = generateNewRow(previousRow);
            result.add(newRow);
            previousRow = newRow;
        }

        return result;
    }

    private List<Integer> generateNewRow(List<Integer> previousRow) {
        List<Integer> row = new ArrayList<>();
        int elementsCount = previousRow.size() + 1;
        row.add(1);
        for (int i = 1; i < elementsCount - 1; i++) {
            row.add(previousRow.get(i - 1) + previousRow.get(i));
        }
        row.add(1);
        return row;
    }
}
