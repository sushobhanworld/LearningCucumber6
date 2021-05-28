package org.example.practice;

public class TestException
{
    private static void divide(int a, int b)
    {
        try {
            int c= a/b;
            System.out.println("Result :"+c);
        }
        catch (ArithmeticException e)
        {
            ArithmeticException arithmeticException= new ArithmeticException();
            arithmeticException.initCause(e);
            throw(arithmeticException);
        }
    }

    public static void main(String[] args) {
        try
        {
            divide(2,0);
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println("Exception to string :"+e.toString());
            System.out.println("Message string :"+e.getMessage());
            System.out.println("Test Throwable :"+e.fillInStackTrace());
        }
    }
}
