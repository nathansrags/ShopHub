package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Groups names by their first letter
public class GroupingBy {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve", "Alex");
        Map<Character, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(grouped);
    }


}
