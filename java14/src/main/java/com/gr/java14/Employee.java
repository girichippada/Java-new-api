package com.gr.java14;

public record Employee(int id,String name) {

    public Employee {
        if (id <= 0 || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid Employee");
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1,"Darth Vader");
        System.out.println(e1.name());
        System.out.println(e1);

        Employee e2 = new Employee(1,"Darth Vader");
        System.out.println("Are they the same employees ? " + e1.equals(e2));
    }
}

