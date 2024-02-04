package com.gr.java15;

public class LocationTest {

    public static void main(String[] args) {
        Location locationOne = new Location("India", 20.5937, 78.9629);
        Location locationTwo = new Location("India", 20.5937, 78.9629);

        System.out.println("Same location: " + locationOne.equals(locationTwo));
        System.out.println("Latitude: " + locationOne.latitude());
        System.out.println("Longitude :" + locationOne.longitude());
        System.out.println(locationOne);

    }
}