package com.gr.java16;

public record Product(Long id,String name, String description)  {

    //Compact constructor.
    public Product{
        if(id < 0) throw new IllegalArgumentException("Invalid Product id...");
    }

    public static void main(String[] args) {

        Product product = new Product(1L,"Bed","Queen size bed");
        System.out.println(product);
    }
}
