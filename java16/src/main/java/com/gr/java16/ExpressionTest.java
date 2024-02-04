package com.gr.java16;

public class  ExpressionTest {

    public static void main(String[] args) {
        //2 + 3 * -4
        Expression expression = new Add(new Constant(2.0),
                new Multiply(new Constant(3.0),new Negate(new Constant(4.0))));

        System.out.println(expression.evaluate());
    }
}
