package com.gr.java14;

public class Order {

    private Long id;
    private Customer customer;

    public Order(Long id){
        this.id= id;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }
}
