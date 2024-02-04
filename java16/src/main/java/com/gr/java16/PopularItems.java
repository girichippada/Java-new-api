package com.gr.java16;

import java.util.Map;

public record PopularItems(String category, String percent) {

    public PopularItems(Map.Entry<String, String> entry) {
        this(entry.getKey(),entry.getValue());
    }

    @Override
    public String toString(){
        return "\nItem : " + this.category + ",Popularity : "+ this.percent;
    }
}
