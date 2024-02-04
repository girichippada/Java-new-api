package com.gr.java14;

public class Address {
    private String country;
    private String city;
    private String street;

    public void setCountry(String country){
        this.country = country;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getStreet(){
        return street;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }
}
