package com.gr.java13;

//Preview feature in Java 13
public class TextBlocks {
    public static void main(String[] args) {

        String addressOneLine = "10 M.G.Road\nMumbai,India,400086\n ";

        String addressTerminators = "10 M.G.Road\n" +
                                    "Mumbai,India,400086\n ";

        String addressTextBlock = """
                10 M.G.Road
                Mumbai,India,400086
                """;

        System.out.println(addressOneLine);
        System.out.println(addressTerminators);
        System.out.println(addressTextBlock);

        String textBlockData = """
                 {
                  "round": "MatchDay 1",
                  "date":  "2021-04-06",
                  "team1": "Real Madrid",
                  "team2": "Barcelona",
                  "score": { "ft": [2, 1] }
                 }
                 """;
        System.out.println(textBlockData);
    }
}