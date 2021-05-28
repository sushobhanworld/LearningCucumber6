package org.example.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWithMap
{
    public static void main(String[] args) {
       // CountOccurances(new String[]{"sushobhan", "java", "kumar", "angular", "sushobhan", "kumar"});
        Stream2(new String[]{"sushobhan", "java", "kumar", "angular", "sushobhan", "kumar"});
    }

    private static void CountOccurances(String[] s)
    {
        List<String> stringList= Arrays.asList(s);
        Map<String, Long> m1 = stringList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(m1);
    }
    
    private static void UniqueSet(String[] s)
    {
        List<String> stringList= Arrays.asList(s);
        List<String> a = stringList.stream().distinct().collect(Collectors.toList());
        System.out.println(a);
    }

    private static void Stream1(String[] s)
    {
        List<String> stringList= Arrays.asList(s);
        //String n = stringList.stream().collect(Collectors.joining());
        Set<String> n = stringList.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(n);
    }
    
    private static void Stream2(String[] s)
    {
        List<String> stringList= Arrays.asList(s);
        List<String> s2 = stringList.stream().sorted().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(s2);
    }
}
