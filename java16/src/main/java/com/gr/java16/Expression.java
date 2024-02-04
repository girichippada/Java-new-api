package com.gr.java16;

public sealed interface Expression permits Constant,Add,Multiply,Negate {

    double evaluate();

}
