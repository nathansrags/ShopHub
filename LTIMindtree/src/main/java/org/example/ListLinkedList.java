package org.example;

import java.util.LinkedList;

public class ListLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Display the LinkedList
        System.out.println("LinkedList: " + list);

        // Access an element
        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        // Remove an element
        list.remove("Banana");
        System.out.println("After Removal: " + list);

        // Add an element to the beginning
        list.addFirst("Orange");
        System.out.println("After Adding First: " + list);

        // Add an element to the end
        list.addLast("Grape");
        System.out.println("After Adding Last: " + list);
    }
}
