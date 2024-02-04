package com.gr.java16;

public record Constant(double value) implements Expression {

    @Override
    public double evaluate() {
        return value;
    }
}
