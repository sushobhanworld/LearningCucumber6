package org.example.practice;

public class CustomException {

    public static void main(String[] args)
    {
        System.out.println("from create custom exception");
        try
        {
            System.out.println("Inside try block");
            throw new SushobhanException("Testing Custom Exception");
        }
        catch (SushobhanException e)
        {
            System.out.println("caught exception");
            System.out.println(e.getMessage());
            System.out.println("get cause: "+e.getCause());
        }
    }
}
