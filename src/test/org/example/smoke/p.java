package org.example.smoke;

import java.util.LinkedHashMap;
import java.util.Map;

public class p
{
    public static void main(String[] args) {
        CountAndBuildString("sushobhan");
    }
    private static void CountAndBuildString(String s)
    {
        LinkedHashMap<Character, Integer> charCountMap= new LinkedHashMap<>();
        //Convert the s to character array
        char[] c = s.toCharArray();

        for(char c1: c)
        {
            if(charCountMap.containsKey(c1))
            {
                charCountMap.put(c1, charCountMap.get(c1)+1);
            }
            else
            {
                charCountMap.put(c1, 1);
            }
        }
        //print
        for (Map.Entry entry: charCountMap.entrySet())
        {
            System.out.print(entry.getKey()+""+entry.getValue());
        }
    }
}
