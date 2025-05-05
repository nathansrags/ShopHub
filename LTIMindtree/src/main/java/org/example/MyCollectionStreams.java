package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static java.lang.System.*;

/**
 * Hello world!
 *
 */
public class MyCollectionStreams
{
    public static void main( String[] args )
    {
        out.println( "Hello World!" );
        List<List<String>> tests = List.of(List.of("apple"), List.of("Banana"));
        List<String> names = tests.stream().flatMap(List::stream).collect(Collectors.toList());
        out.println(names);
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("c");
        list.add(1, "b");
        out.println(list);
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean s = bool.compareAndExchange(false, true);
        out.println(s);
    }
}
