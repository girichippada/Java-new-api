package com.gr;

public class Records {

    record Person(String name, Integer contactNumber, String emailId, Integer age){}
    public static void main(String[] args) {
        Person person1 = new Person("Girish", 34324, "dsdjhd@live.in", 56);

    }
}
