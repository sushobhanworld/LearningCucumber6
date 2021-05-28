package org.example.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstOccuranceNonRepeative
{
    private static void FirstOccurance(String s)
    {
        Map<Character, Integer> map= new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
            //start taking character
            Character c=s.charAt(i);
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)+1);
            }
            else
                map.put(c, 1);
        }
        System.out.printf("Map :"+map);

        for (Map.Entry<Character, Integer> m: map.entrySet()) {
            if (m.getValue() == 1)
            {
                System.out.printf(String.valueOf(m.getKey()));
                break;
            }
        }

    }

    public static void main(String[] args) {
        FirstOccurance("AABCDBF");
    }
}
