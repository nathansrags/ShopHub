package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class AllPrimeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10,13,11,14);
        List<Integer> primeNumbers = numbers.stream().sorted().filter(AllPrimeNumbers::isPrime).collect(Collectors.toList());
        System.out.println(primeNumbers);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
}
