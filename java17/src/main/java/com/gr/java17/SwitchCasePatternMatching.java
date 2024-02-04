package com.gr.java17;

import java.util.*;


//Example of pattern matching & switch
public class SwitchCasePatternMatching {

    public static void main(String[] args) {

        Object value = getValue();

        String result = getResult(value);
        System.out.println(result);
    }

    public static String getResult(Object value){
        //char,byte,short,int,Character,Byte,Short,Integer,String,Enum type.

        //Available from JDK 21
        return switch(value){
            case String s -> "A String of length :  "+s.length();
            case List list -> "A list of size : "+ list.size();
            case Map map -> "A map(key,value) of size : "+ map.size();
            case Set set -> "A set, unique elements : " + set.size();
            default -> "Unknown data structure...";
        };
    }

    public static String getResultSwitchStatement(Object value) {
        var result = "";
        //Available from JDK 21
        switch (value) {
            case String s: result = "A String of length :  " + s.length();
                           break;
            case List list: result = "A list of size : " + list.size();
                            break;
            case Map map: result = "A map(key,value) of size : " + map.size();
                          break;
            case Set set: result = "A set, unique elements : " + set.size();
                          break;
            default:      result = "Unknown data structure...";
                          break;
        }
        return result;
    }

    //Example of Guarded pattern
    public static String getResultWithGuard(Object value){
        //Available from JDK 21
        return switch(value){
            case String s -> "A String of length :  "+s.length();
            //case List list && (list.size() > 10000) -> "A large list of size : "+ list.size();
            case List list -> "A list of size : "+ list.size();
            case Map map -> "A map(key,value) of size : "+ map.size();
            case Set set -> "A set, unique elements : " + set.size();
            default -> "Unknown data structure...";
        };
    }

    //null case label.
    public static String getLeagueDescription(FootballLeague league){
        return switch(league){
            case null -> "Invalid league";    //Available from JDK 21
            case EPL -> "English Premier League";
            case LA_LIGA -> "Spanish football League";
            case BUNDESLIGA -> "Football league in Germany";
            case LIGUE_1 -> "French football tournament";
        };
    }

    private static Object getValue() {
        return Map.of("1","One","2","Two");
        //return List.of(1,2,3,4,5);
        //return "Hello Pattern matching for switch";
    }
}
