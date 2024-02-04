package com.gr.java16;

import lombok.extern.slf4j.Slf4j;

import java.io.InvalidObjectException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class CustomerLocationTest {

    public static void main(String[] args) {

        //Compound key.
        List<CustomerLastVisited> customerLocations = getCustomerLocation();

        Optional<CustomerLastVisited> lastSpottedOptional = customerLocations.stream().filter(customerLastVisited -> customerLastVisited.customerLocation().equals(
            new CustomerLocation(new Customer("Girish",35),
                    new Location("India","New Delhi")))).findFirst();
        CustomerLastVisited lastSpotted = lastSpottedOptional.orElseThrow();

        log.info("{} was Last Spotted on : {}", lastSpotted.customerLocation().customer().name(), lastSpotted.dateTime());
    }

    record CustomerLastVisited(CustomerLocation customerLocation, LocalDateTime dateTime){ }

    private static List<CustomerLastVisited> getCustomerLocation(){
        var customerLocationVisitedList = new ArrayList<CustomerLastVisited>();

        //Ben
        var uk = new Location("UK","London");
        var ben = new CustomerLocation(new Customer("Ben",30),uk);

        customerLocationVisitedList.add(new CustomerLastVisited(ben,LocalDateTime.now()));

        //Emily
        var emily = new CustomerLocation(new Customer("Emily",30),uk);
        customerLocationVisitedList.add(new CustomerLastVisited(emily,LocalDateTime.now().minusDays(1)));

        //Girish
        var india = new Location("India","New Delhi");
        var girish = new CustomerLocation(new Customer("Girish",35),india);
        customerLocationVisitedList.add(new CustomerLastVisited(girish,LocalDateTime.now().minusDays(2)));

        return customerLocationVisitedList;
    }
}
