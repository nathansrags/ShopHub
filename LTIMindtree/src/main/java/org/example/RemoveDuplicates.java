package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = {1, 1, 2};
        rd.removeDuplicates(nums);
        Arrays.stream(nums).forEach(System.out::println);

    }

    private int removeDuplicates(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().collect(Collectors.toList());
        System.out.println(list);
        for (int i = 0; i < nums.length; i++) {
            if (i >= list.size()) {
                nums[i] = 0;
            }else{
                nums[i] = list.get(i);
            }

        }

        return list.size();
    }
}
