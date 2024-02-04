package com.gr.java16;


public record Negate(Expression expression) implements  Expression {

    public double evaluate() {
        return -expression.evaluate();
    }
}
