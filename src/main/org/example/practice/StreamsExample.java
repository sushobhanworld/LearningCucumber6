package org.example.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsExample
{
    public static void main(String[] args) {
        List<String> l= new ArrayList<>();
        l.add("Kumar");
        l.add("Sushobhan");


        l.stream().filter(s ->
        {
            System.out.println(s);
            System.out.println(s.startsWith("K"));
            Boolean result=s.startsWith("K");
            return result;
        }).forEach(s1-> System.out.println(s1));
        //System.out.println(i);

        //l.stream().filter(s ->s.length()>7).forEach(s1-> System.out.println(s1));
       // l.stream().filter(s->s.length()>7).collect()

        l.stream().distinct().sorted().collect(Collectors.toList());
    }
}
