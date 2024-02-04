package com.gr.java9;


import java.util.List;

//Assignment number 2
public class MutableImmutable {

    public static void main(String[] args) {

        List<MutableContainer> data = List.of(new MutableContainer(10),new MutableContainer(20));

        System.out.println("Data : "+ data);

        //Mutable object
        data.get(0).setData(500);

        System.out.println("Data : "+ data);

    }
}

class MutableContainer {

    private int data;

    public MutableContainer(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int x){
        this.data = x;
    }

    public String toString(){
        return "Data : " +getData();
    }
}