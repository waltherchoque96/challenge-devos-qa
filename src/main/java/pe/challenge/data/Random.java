package pe.challenge.data;

import com.github.javafaker.Faker;

public class Random {

    public static String getName(){
        Faker faker = new Faker();
        String name = faker.name().firstName();

        return name;
    }

    public static String getJob(){
        Faker faker = new Faker();
        String job = faker.job().title();

        return job;
    }

}
