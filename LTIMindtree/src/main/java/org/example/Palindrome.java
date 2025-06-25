package org.example;

public class Palindrome {

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(121));
        System.out.println(p.isPalindrome(-121));
        System.out.println(p.isPalindrome(00));
    }

    private boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int reversed = 0;
        int original = x;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return original == reversed;

    }
}
