package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class NumberOfWords {
    public static void main(String[] args) {
        String sentence = "Hello I am new to hello world. In the world of programmer I am staring to learn programming. I am a good programmer";
        String [] words = sentence.split(" ");
        //long count = stream(words).count();
        Map<String, Long> counts = Arrays.stream(words).collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println(counts);
    }
}
