package org.amskbs.easy.n202_happy_number;

import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Integer> list = List.of(19, 2, 123, 12, 9);
        for (Integer integer : list) {
            System.out.println(main.isHappy(integer));
            System.out.println(main.isHappy2(integer));
        }
    }

    public boolean isHappy(int n) {
        HashSet<Integer> checkedNumbers = new HashSet<>();
        int nextNumber = n;
        while (true) {
            nextNumber = getNextNumber(nextNumber);
            int digitsSum = getDigitsSum(nextNumber);
            if (digitsSum == 1) {
                return true;
            }
            if (checkedNumbers.contains(nextNumber)) {
                return false;
            }
            checkedNumbers.add(nextNumber);
        }
    }

    // generate next number at the same time when calculating digits sum
    public boolean isHappy2(int n) {
        HashSet<Integer> checkedNumbers = new HashSet<>();
        int nextNumber = getNextNumber(n);
        while (true) {
            DigitsSumWithNextNumber digitsSum = getDigitsSumWithNextNumber(nextNumber);
            if (digitsSum.sum == 1) {
                return true;
            }
            if (checkedNumbers.contains(digitsSum.nextNumber)) {
                return false;
            }
            checkedNumbers.add(digitsSum.nextNumber);
            nextNumber = digitsSum.nextNumber;
        }
    }
    private int getNextNumber(int n) {
        int nextNumber = 0;
        while (n > 0) {
            byte digit = (byte) (n % 10);
            n = n / 10;
            nextNumber = nextNumber + digit * digit;
        }
        return nextNumber;
    }

    private int getDigitsSum(int n) {
        int sum = 0;
        while (n > 0) {
            byte digit = (byte) (n % 10);
            n = n / 10;
            sum += digit;
        }
        return sum;
    }

    private DigitsSumWithNextNumber getDigitsSumWithNextNumber(int n) {
        int sum = 0;
        int nextNumber = 0;
        while (n > 0) {
            byte digit = (byte) (n % 10);
            n = n / 10;
            sum += digit;
            nextNumber = nextNumber + digit * digit;
        }
        return new DigitsSumWithNextNumber(nextNumber, sum);
    }

    private static class DigitsSumWithNextNumber {
        final int nextNumber;
        final int sum;

        public DigitsSumWithNextNumber(int nextNumber, int sum) {
            this.nextNumber = nextNumber;
            this.sum = sum;
        }
    }

}
