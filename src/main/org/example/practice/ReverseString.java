package org.example.practice;

public class ReverseString
{
    String s= "sushobhan";

    public static void main(String[] args) {
        ReverseStringUtility("madam");
    }

    private static void ReverseStringUtility(String s)
    {
        StringBuilder stringBuilder= new StringBuilder(s);
        StringBuilder s1= stringBuilder.reverse();
        System.out.println(s1.toString());
        Boolean b= s.equals(s1.toString());
        System.out.println(b);
    }
}
