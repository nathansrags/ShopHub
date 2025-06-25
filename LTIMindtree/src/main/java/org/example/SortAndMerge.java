package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndMerge {
    public static void main(String[] args) {
        SortAndMerge sam = new SortAndMerge();
        int[] arr1 = {3, 6, 9, 0, 0};
        int[] arr2 = {4, 10,-3};
        List<Integer> result = sam.solution(arr1, arr2, arr1.length, arr2.length);
        System.out.println(result);
    }

    private List<Integer> solution(int[] arr1, int[] arr2, int m, int n) {
        List<List<int[]>> arr1List = Arrays.asList(Collections.singletonList(arr1), Collections.singletonList(arr2));
        List<int[]> result = arr1List.stream().flatMap(List::stream).collect(Collectors.toList());
        return result.stream().flatMapToInt(Arrays::stream).boxed().collect(Collectors.toList())
                .stream().filter(e -> e > 0).sorted().collect(Collectors.toList());
    }
}
