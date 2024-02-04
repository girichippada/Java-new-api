package com.gr.java16;

public record Multiply(Expression left, Expression right) implements Expression {

    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
