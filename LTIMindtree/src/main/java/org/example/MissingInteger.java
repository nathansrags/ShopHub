package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Find the smallest positive integer that does not occur in a given sequence.
public class MissingInteger {
    public static void main(String[] args) {
        MissingInteger mi = new MissingInteger();
        //int[] a = {-1, -3};
        int[] a = {1, 3, 6,  4, 1, 2};
        int missing = mi.solution(a);
        System.out.println(missing);
    }

    private int solution(int[] a) {
        List<Integer> ints = Arrays.stream(a).boxed().distinct().sorted().collect(Collectors.toList());
        System.out.println(ints);
        int missing = 1;
        for (Integer i : ints) {
            if (i == 0) {
                return missing;
            } else if (ints.contains(missing)) {
                missing = missing + 1;
            } else {
                break;
            }

        }
        missing = missing == 0 ? missing + 1 : missing;
        return missing;
    }
}
