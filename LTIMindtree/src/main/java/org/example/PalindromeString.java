package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeString {
    public static void main(String[] args) {
        PalindromeString ps = new PalindromeString();
        System.out.println(ps.isPalindrome("MALAYALAM"));
    }

    private boolean isPalindrome(String s) {
        return s.trim().equalsIgnoreCase(this.reverse(s));
    }

    private String reverse(String s) {

        List<Character> charList = new ArrayList<>();
               // Arrays.asList(s.toCharArray()).stream().map(String::valueOf).collect(Collectors.joining());
        for (char ch : s.toCharArray()) {
            charList.add(ch);
        }
        System.out.println(s);
        Collections.reverse(charList);
        String reversed = charList.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(reversed);
        return reversed;
    }
}
