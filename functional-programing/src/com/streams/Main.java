package com.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();
        /*
        //Imperative approach👎
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        */
        //Declarative approach✅
        //Filter✅

        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))//filter return true false
                .collect(Collectors.toList());
//        females.forEach(System.out::println);
        //Sort✅

        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge)//this is sorted(sıralama) as age
                        .thenComparing(Person::getGender))
                .collect(Collectors.toList());
        //sorted.forEach(System.out::println);
        //All Match✅
        boolean allMatch = people.stream().allMatch(person -> person.getAge() > 50);
//        System.out.println(allMatch);

        boolean anyMatch = people.stream().anyMatch(person -> person.getAge() > 25);
//        System.out.println(anyMatch);

        //None match✅
        boolean noneMatch = people.stream().noneMatch(person -> person.equals("amet"));
//        System.out.println(noneMatch);//return true if the value none exist

        //Max✅
        Optional<Person> maxValue = people.stream().max(Comparator.comparing(Person::getAge));
//        System.out.println(maxValue);

        //Min✅
        Optional<Person> minValue = people.stream().min(Comparator.comparing(Person::getAge));
//        System.out.println(minValue);

        //Group✅
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        /*
        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });
        */
        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleAge.ifPresent(person-> System.out.println(person));
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("emin", 243, Gender.MALE),
                new Person("ali", 21, Gender.MALE),
                new Person("ahmet", 27, Gender.MALE),
                new Person("mehmet", 24, Gender.MALE),
                new Person("aslı", 20, Gender.FEMALE),
                new Person("eyşan", 31, Gender.FEMALE),
                new Person("ayşe", 30, Gender.FEMALE)


        );
    }
}
