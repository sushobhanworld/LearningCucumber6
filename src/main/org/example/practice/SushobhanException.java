package org.example.practice;

public class SushobhanException extends Exception
{
    public SushobhanException(String s)
    {
        super(s);
        message();
    }

    public void test() throws Exception
    {

    }
    public static void message() {
        System.out.println("from message method of SushobhanException");
        System.out.println("Exception message");
    }
}
