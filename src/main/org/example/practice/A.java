package org.example.practice;

import java.io.IOException;

public class A
{
    void show()
    {
        System.out.println("parent");
    }
}

class B extends A
{
    void show() throws ArithmeticException
    {
        System.out.println("child");
    }
    public static void main(String[] args) {
        A a= new B();
    }
}



