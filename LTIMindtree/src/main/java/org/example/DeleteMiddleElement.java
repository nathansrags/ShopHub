package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DeleteMiddleElement {
    public static void main(String[] args) {
        DeleteMiddleElement dme = new DeleteMiddleElement();
        Stack<Integer> stack = new Stack<>();
        List<Integer> integers = Arrays.asList(9, 5, 2, 7, 8, 6, 3);
        stack.addAll(integers);
        System.out.println(dme.solution(stack, 4));
    }

    private Stack<Integer> solution(Stack<Integer> inputStack, int n) {
        int middle = inputStack.size() % 2 == 0 ? (inputStack.size() / 2) : ((inputStack.size() + 1) / 2);
        int element = inputStack.get(middle);
        System.out.println(inputStack.size() + "   " + middle);
        System.out.println(inputStack);
        System.out.println("Middle element is " + element);
        inputStack.removeElementAt(middle - 1);
        return inputStack;
    }

}
