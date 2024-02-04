package com.gr.java14;

import java.util.ArrayList;
import java.util.List;

public class NullPointerExceptions {

    public static void main(String[] args) {

        Order order = new Order(1L);

        Customer customer = new Customer("Dolph Lundgren");
        order.setCustomer(customer);

        Address address = new Address();
        address.setCountry("Sweden");
        address.setCity("Stockholm");
        customer.setAddress(address);

        List<Order> orders = new ArrayList<>(0);
        orders.add(order);
        processShippingAddress(orders);

        //Example 2
        var location  = new Integer[][]{ null };
        location[0][0] = 6;
        System.out.println(location);
    }

    public static void processShippingAddress(List<Order> orders){
        for(Order order : orders){
            System.out.println(order.getCustomer().getAddress().getCountry());
        }
    }
}
