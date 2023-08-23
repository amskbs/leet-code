package org.amskbs.easy.palindrome_number;

public class Main {

    /*
    Given an integer x, return true if x is a palindrome, and false otherwise.
     */
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isPalindrome(123321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;
        int tested = x;
        while (tested > 9) {
            rev = rev * 10 + tested % 10;
            tested = tested / 10;
        }
        return (x == rev || rev == x / 10);
    }
}
