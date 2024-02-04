package com.gr.java16;

import com.gr.java15.MinMax;
import com.gr.java15.Movie;
import com.gr.java15.MovieUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.teeing;

@Slf4j
public class MovieTest {
	
	public static List<Movie> movies = MovieUtil.getMovieData();
	
	public static void main(String[] args) {

		log.info("Movies Inventory : {}", movies);
		MinMax<Movie> minMaxGrossingMovie = findMinMaxGrossingMovie();

		log.info("Minimum grossing movie: {}", minMaxGrossingMovie.min());
		log.info("Maximum grossing movie: {}", minMaxGrossingMovie.max());
	}


	public static MinMax<Movie> findMinMaxGrossingMovie(){

		var grossEarningComparator = Comparator.comparingLong(Movie::grossEarning);

		return  movies.stream()
					  .collect(teeing(
					  			minBy(grossEarningComparator),
							  	maxBy(grossEarningComparator),
							  	(min, max) ->
										new MinMax<>(min.orElse(null), max.orElse(null)))
					  );
	}
}
