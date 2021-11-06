package com.gr;

public class StringUtils {

    public static void main(String[] args) {
        System.out.println(" ".isBlank());  //Checks is String is empty blank
        System.out.println(" He llo boss.. . ".strip());    //Removes all leading and trailing Whitespaces
        System.out.println(" He llo boss.. . ".stripLeading());
        System.out.println(" He llo boss.. . ".stripTrailing());
        System.out.println(" He llo boss.. . \n   Am in 2n d ..\n  a m in 3rd".stripIndent());
        System.out.println(" He llo boss.. . ".transform(s -> s.strip()).toLowerCase());
        System.out.println(" He llo boss... This is %s ".formatted("GR"));
        TestNPE testNPEObj = new TestNPE();
        System.out.println(testNPEObj.str.isBlank());

    }
}

class TestNPE {
    String str = null;
}