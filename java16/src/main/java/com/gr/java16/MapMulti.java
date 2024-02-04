package com.gr.java16;

import com.gr.java15.Movie;
import com.gr.java15.MovieUtil;

import java.util.List;
import java.util.stream.Collectors;

//Shows example of flatMap and mapMulti
public class MapMulti {

    public static List<Movie> movies = MovieUtil.getMovieData();

    public static void main(String[] args) {

        //Using flatMap
        List<String> starCastflatMap = starsInMartinMoviesFlatMap();
        System.out.println(starCastflatMap);

        //Using mapMulti
        List<String> starCastmapMulti = starsInMartinMoviesMapMulti();
        System.out.println(starCastmapMulti);

    }

    public static List<String> starsInMartinMoviesFlatMap() {
        //[ [a],[b,c],[d,e,f] ] -> [a,b,c,d,e,f]

        return movies.stream()
                .filter(movie -> movie.director().equals("Martin Scorsese"))
                .flatMap(movie -> movie.cast().stream())
                .collect(Collectors.toList());
    }

    public static List<String> starsInMartinMoviesMapMulti() {

        return movies.stream()
                .filter(movie -> movie.director().equals("Martin Scorsese"))
                .<String>mapMulti((movie,consumer) -> {
                    List<String> stars  = movie.cast();
                    for(String star : stars){
                        consumer.accept(star);
                    }
                })
                .collect(Collectors.toList());
    }
}
