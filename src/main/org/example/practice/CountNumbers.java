package org.example.practice;

import java.util.*;
import java.util.stream.Collectors;

public class CountNumbers
{
    private static Map<String, Integer> CountOccurances(String[] s)
    {
        Map<String, Integer> map= new LinkedHashMap<>();
        for(int i=0;i<s.length;i++)
        {
            if(map.containsKey(s[i]))
            {
                map.put(s[i], map.get(s[i])+1);
            }
            else
            {
                map.put(s[i], 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(CountOccurances(new String[]{"sushobhan", "java", "kumar", "angular", "sushobhan", "kumar"}));
        String[] s= {"sushobhan", "java", "kumar", "angular", "sushobhan", "kumar"};

        List<String> list= Arrays.asList(s);

        //list.stream()

    }
}
