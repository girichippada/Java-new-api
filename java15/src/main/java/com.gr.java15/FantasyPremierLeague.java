package com.gr.java15;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class FantasyPremierLeague {

    public static Map<Player, Integer> playerScore = new HashMap<>();
    public static List<Player> players = getPlayers();


    public static void main(String[] args) {
        log.info("list of all players: {}", players);
        //List<Player> players = topThreePlayers();
        List<Player> players = getTop3Players();
        System.out.println(players);
    }


    public static List<Player> topThreePlayers() {

        record PlayerScore(Player player, int score) {
        }

        return players.stream()
                .map(player -> new PlayerScore(player, calculateScore(player)))
                .sorted(Comparator.comparingInt(PlayerScore::score)
                        .reversed())
                .limit(3)
                .map(PlayerScore::player)
                .collect(Collectors.toList());
    }

    private static int calculateScore(Player player) {
        return playerScore.get(player);
    }

    private static List<Player> getPlayers() {

        var bruno = new Player("Fernandes", Club.MUN, Position.MIDFIELD);
        var kane = new Player("Kane", Club.TOT, Position.FORWARD);
        var salah = new Player("Salah", Club.LIV, Position.FORWARD);
        var son = new Player("Son", Club.TOT, Position.MIDFIELD);
        var mane = new Player("Mane", Club.LIV, Position.FORWARD);
        var ederson = new Player("Ederson", Club.MCI, Position.GOALKEEPER);

        playerScore.put(bruno, 30);
        playerScore.put(kane, 25);
        playerScore.put(salah, 10);
        playerScore.put(son, 15);
        playerScore.put(mane, 14);
        playerScore.put(ederson, 10);

        return List.of(bruno, kane, salah, son, mane, ederson);
    }

    private static List<Player> getTop3Players(){
        return players.stream()
                .sorted(Comparator.comparing(FantasyPremierLeague::calculateScore, Comparator.reverseOrder()))
                .limit(3)
                .toList();
    }
}

class Player {

    private String name;
    private Club club;
    private Position position;

    public Player(String name, Club club, Position position) {
        this.name = name;
        this.club = club;
        this.position = position;
    }

    public String toString() {
        return name + " plays for " + club + " (in/as) " + position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && club == player.club;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, club);
    }
}

enum Club {
    MUN,
    TOT,
    LIV,
    MCI
}

enum Position {
    MIDFIELD,
    FORWARD,
    GOALKEEPER,
    DEFENDER
}
