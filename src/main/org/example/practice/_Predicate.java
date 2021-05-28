package org.example.practice;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate
{
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValidWithPredicate.test("9731950640"));
        System.out.println(isPhoneNumberValidWithPredicate.test("7619549352"));

        System.out.println(isPhoneNumberValidWithPredicate.and(containsNumber3).test("9731950640"));
        System.out.println(isPersonNameIsSushobhanWithAge35.test("Sushobhan", ""));
    }

    static Predicate<String> isPhoneNumberValidWithPredicate=
            phoneNumber -> phoneNumber.startsWith("97") && phoneNumber.length()==10;

    static Predicate<String> containsNumber3= phoneNumber -> phoneNumber.contains("3");
    static BiPredicate<String, String> isPersonNameIsSushobhanWithAge35=
            (name, age) -> Boolean.parseBoolean((name.equals("Sushobhan")+age));
}
