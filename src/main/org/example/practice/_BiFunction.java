package example.practice;

import java.util.function.BiFunction;

public class _BiFunction
{
    public static void main(String[] args) {
        System.out.println(increamentByOneAndMultiplyBiFuntion.apply(4, 5));
    }

    static BiFunction<Integer, Integer, Integer> increamentByOneAndMultiplyBiFuntion=
            (numberToIncreamentByOne, numberToMultiplyBy) -> (numberToIncreamentByOne+1)*numberToMultiplyBy;

    static int increamentByOneAndMultiply(int number, int numToMultiplyBy)
    {
        return (number+1)*numToMultiplyBy;
    }
}
