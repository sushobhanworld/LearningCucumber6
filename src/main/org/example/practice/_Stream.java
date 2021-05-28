package org.example.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.practice._Stream.Gender.FEMALE;
import static org.example.practice._Stream.Gender.MALE;

public class _Stream
{
    public static void main(String[] args) {
        List<Person> people= Arrays.asList(new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
                            );

        people.stream()
                .map(peopleList -> peopleList.name)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        people.stream()
                .map(peopleList -> peopleList.gender)
                .collect(Collectors.toSet())
                .forEach(setList -> System.out.println(setList));

        people.stream()
                .map(peopleList -> peopleList.name)
                .mapToInt(peopleNameLength -> peopleNameLength.length())
                .forEach(lengths -> System.out.println(lengths));
        boolean b = people.stream()
                .allMatch(f -> f.gender.equals(FEMALE));
        System.out.println(b);
    }

    static class Person
    {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender
    {
        MALE, FEMALE;
    }
}
