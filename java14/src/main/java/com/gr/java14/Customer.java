package com.gr.java14;

public class Customer {

    private String name;
    private Address address;

    public Customer(String name){
        this.name = name;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address=address;
    }

}
