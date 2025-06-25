package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceExample {
    public static void main(String[] args) {
        ReduceExample re = new ReduceExample();
        int[] nums = {-1, 1, 0, -2, -3, 3, 4};
        char[] words = {'I', 'a', 'm', 'H', 'o', 'm', 'e'};
        String[] strArray = {"Java", "Streams", "Reduce"};
        re.reduceAndSum(nums, words, strArray);
    }

    private int reduceAndSum(int[] nums, char[] chars, String[] strArray) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        String s = String.valueOf(chars);
        int sum = list.stream().filter(e -> e > 0).reduce(0, Integer::sum);
        int maxValue = list.stream().filter(e -> e > 0).reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println(sum);
        System.out.println(maxValue);
        String ss = Arrays.stream(strArray).collect(Collectors.joining());
        System.out.println(ss);
        System.out.println(s);
        return nums.length;
    }
}
