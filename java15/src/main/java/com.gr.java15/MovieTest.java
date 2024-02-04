package com.gr.java15;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

public class MovieTest {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        List<Movie> topThreeMovies = topThreeMovies();
        System.out.println("Top 3 movies based on score : ");
        System.out.println(topThreeMovies);
    }

    //Get List of movies(top 3) based on score.
    //1.Movies - for each movie -> calculate score(movie & score)
    //2.Sort movie by score(movie & score required together)
    //3.Get top 3
    //4.Return movie list.
    public static List<Movie> topThreeMovies() {

        record MovieScore(Movie movie, int score) {
        }

        return movies.stream()
                .map(movie -> new MovieScore(movie, calculateScore(movie)))
                .sorted(Comparator.comparingInt(MovieScore::score).reversed())
                .limit(3)
                .map(MovieScore::movie)
                .toList();
    }

    private static int calculateScore(Movie movie) {
        return MovieUtil.getScore(movie);
    }


    public static MinMax<Movie> findMinMaxGrossingMovie() {
        //var grossEarningComparator = Comparator.comparing(Movie::getGrossEarning);
        var grossEarningComparator = Comparator.comparing(Movie::grossEarning);

        return movies.stream()
                .collect(Collectors.teeing
                        (
                                minBy(grossEarningComparator),
                                maxBy(grossEarningComparator),
                                (min, max) -> new MinMax<>(min.orElse(null), max.orElse(null))
                        )
                );
    }

}
