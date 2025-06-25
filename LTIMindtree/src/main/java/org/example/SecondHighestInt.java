package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestInt {

    public static void main(String[] args) {
        // Second Highest Int
        List<Integer> ints = Arrays.asList(3, 4, 5, 2, 9, 7);
        int lg = ints.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElseThrow();
        System.out.println(lg);
        // Second smallest Int

        int smg = ints.stream().sorted().skip(1).findFirst().orElseThrow();
        System.out.println(smg);
    }
}
