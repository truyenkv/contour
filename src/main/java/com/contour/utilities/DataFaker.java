package com.contour.utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataFaker {

    private static Faker faker = new Faker();
    public static String getEmail(){
        return faker.internet().emailAddress();
    }

    public static String getName(){
        return faker.name().fullName();
    }

    public static String getPhone(){
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        return String.valueOf(number);
    }

    public static String getMiddle(){
        return "Join";
    }

}
