package com.gr.java9;

import java.util.*;

import static java.util.Map.entry;

//Examples of List.of,Set.of,Map.of,Collections.unmodifiableList

public class CollectionFactory {

    public static void main(String[] args) {

        //Comment/Uncomment the following to check the output.

        list();
        set();
        map();
        //noNull();
        //noDuplicates();
        ofVsUnmodifiable();
    }

    public static void ofVsUnmodifiable() {

        List<String> list = Arrays.asList("Epl","LaLiga","Bundesliga");
        List<String> leagues = Collections.unmodifiableList(list);
        //list.set(2,"Ligue1");

        System.out.println("Using Collections.unmodifiable : "  +leagues);

        List<String> leaguesUsingOf = List.of("Epl","LaLiga","Bundesliga");
        System.out.println("Using List.of : " + leaguesUsingOf);
    }

    public static void noNull() {
        System.out.println("Adding null in a call to List.of");
        List<String> leagues = List.of("Epl","LaLiga","Bundesliga",null);
        System.out.println(leagues);
    }

    public static void noDuplicates() {

        System.out.println("Adding duplicates using add in Set.");
        Set<String> set = new HashSet<>();
        set.add("EPL");
        set.add("LALIGA");
        set.add("BUNDESLIGA");
        set.add("EPL");
        System.out.println(set);

        System.out.println("Adding duplicates using Set.of");
        Set<String> leagues = Set.of("EPL","LALIGA","BUNDESLIGA","EPL");
        System.out.println(leagues);

        System.out.println("Adding duplicates using Map.of");
        Map<String,Integer> leagueRanking =
                Map.of("Epl",200 , "LaLiga",210,"Bundesliga",190);
        System.out.println(leagueRanking);
    }


    public static void list() {
        unmodifiableListWithAdd();
        unmodifiableListArraysAsList();
        unmodifiableListOf();
    }

    public static void set() {
        unmodifiableSetAdd();
        unmodifiableSetArraysAsList();
        unmodifiableSetOf();
    }

    public static void map() {
        unmodifiableMapUsingPut();
        unmodifiableMapUsingOf();
        unmodifiableMapWithTenElements();
    }

    public static void unmodifiableListWithAdd() {

        List<String> list = new ArrayList<>();
        list.add("Epl");
        list.add("LaLiga");
        list.add("Bundesliga");

        List<String> leagues = Collections.unmodifiableList(list);
        System.out.println(leagues);
    }


    public static void unmodifiableListArraysAsList() {
        List<String> leagues =  Collections.unmodifiableList(
                Arrays.asList("Epl","LaLiga","Bundesliga"));

        System.out.println(leagues);
    }

    public static void unmodifiableListOf() {

        List<String> leagues = List.of("Epl","LaLiga","Bundesliga");
        System.out.println(leagues);

        List<String> emptyList  = List.of();
        List<String> one = List.of("Epl");
        List<String> two = List.of("Epl","LaLiga");
        List<String> ten = List.of("a","b","c","d","e","f","g","h","i","j");

        //UnsupportedOperationException
        //leagues.add("Ligue 1");
        //leagues.set(0,"SerieA");
        //leagues.remove("Epl");
    }

    public static void unmodifiableSetAdd() {
        Set<String> set = new HashSet<>();
        set.add("EPL");
        set.add("LALIGA");
        set.add("BUNDESLIGA");

        Set<String> leagues = Collections.unmodifiableSet(set);
        System.out.println(leagues);
    }

    public static void unmodifiableSetArraysAsList() {
        Set<String> leagues =  Collections.unmodifiableSet(new HashSet<>(
                Arrays.asList("EPL","LALIGA","BUNDESLIGA")));

        System.out.println(leagues);
    }

    public static void unmodifiableSetOf() {
        Set<String> leagues = Set.of("EPL","LALIGA","BUNDESLIGA");
        System.out.println(leagues);
    }

    public static void unmodifiableMapUsingPut() {
        Map<String,Integer> map = new HashMap<>();

        map.put("EPL", 200);
        map.put("LaLiga", 210);
        map.put("Bundesliga", 190);

        Map<String,Integer> leagueRanking = Collections.unmodifiableMap(map);
        System.out.print(leagueRanking);
    }

    public static void unmodifiableMapUsingOf() {
        Map<String,Integer> leagueRanking =
                Map.of("Epl",200 , "LaLiga",210,"Bundesliga",190);
        System.out.println(leagueRanking);
    }

    public static void unmodifiableMapWithTenElements() {
        //If more than 10 entries...
        Map<String,Integer> leagueRanking =
                Map.ofEntries(
                        entry("Epl",200),
                        entry("LaLiga",210),
                        entry("Bundesliga",190),
                        entry("League1",250)
                );
        System.out.println(leagueRanking);
    }


}
