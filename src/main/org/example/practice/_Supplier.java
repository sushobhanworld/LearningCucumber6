package org.example.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class _Supplier
{
    public static void main(String[] args) {
        System.out.println(getDBConnectionURLSupplierList.get());
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:5432/user";
    static Supplier<List<String>> getDBConnectionURLSupplierList =
            () -> Arrays.asList("abc", "qwe");
}
