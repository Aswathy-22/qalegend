package com.qalegend.utilities;
import com.github.javafaker.Faker;
public class RandomDataUtility {
    public static Faker faker;
    public static String getFirstname() {
        faker = new Faker();
        String firstName = faker.name().firstName();
        return firstName;
    }
    public static String getLastname() {
        faker = new Faker();
        String lastName = faker.name().lastName();
        return lastName;
    }
    public static String getPhonenumber() {
        faker=new Faker();
        String phoneNUmber = faker.phoneNumber().phoneNumber();
        return phoneNUmber;
    }
    public static String getAddress() {
        faker=new Faker();
        String address = faker.address().streetAddress();
        return address;
    }
    public static String getCity() {
        faker=new Faker();
        String city = faker.address().city();
        return city;
    }
    public static String getState() {
        faker=new Faker();
        String state = faker.address().state();
        return state;
    }
    public static String getPostalCode() {
        faker=new Faker();
        String postalCode = faker.address().zipCode();
        return postalCode;
    }
    public static String getEmail() {
            Faker faker = new Faker();
            return faker.internet().emailAddress();
    }
    public static String getPrefix(){
        faker=new Faker();
        String prefix = faker.name().prefix();
        return prefix;
    }

    public static String getPassword() {
        String password=faker.internet().password();
        return password;
    }
    public static String getRandomNumber(){
        faker=new Faker();
        String number=String.valueOf(faker.number().randomDigitNotZero());
        return number;
    }
}
