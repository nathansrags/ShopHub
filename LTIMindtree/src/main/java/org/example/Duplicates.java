package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Duplicates {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 5, 7, 3, 8, 7, 2);
        Set<Integer> unique = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();
        for (Integer i : list) {
            if (unique.contains(i)) {
                duplicate.add(i);
            } else {
                unique.add(i);
            }
        }
        System.out.println(duplicate);
        duplicate = list.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting())).entrySet()
                .stream().filter(en -> en.getValue() >1)
                .map(Map.Entry::getKey).sorted().collect(Collectors.toList());
        System.out.println(duplicate);

    }
}
