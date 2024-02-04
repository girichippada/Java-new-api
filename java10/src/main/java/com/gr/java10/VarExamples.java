package com.gr.java10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import java.util.stream.Stream;

//Example of local variable type inference
public class VarExamples {

	public static void main(String[] args) throws URISyntaxException {
		
		//1.Var with literals - gives alignment
		literals();

		//2.Using var in for loop.
		forLoopOne(getNumbers());

		forLoopTwo();
		
		//3.Prefer explicit here
		Map<Genre,List<Movie>> movies = getMovies();
		//var movies = getMovies();
		
		//4.Careful ! - This is a list of type Object - Defeats purpose.
		List<Integer> numbers  = new ArrayList<>();
		numbers.add(1);
		//numbers.add("One");
		
		//5. Give meaningful names
		MovieSearchCriteria movieSearchCriteria = new MovieSearchCriteria();
		MovieService service = new MovieService();
		List<Movie> movie = service.getMovies(movieSearchCriteria);

		//6. Initializer
		List<String> vowels = List.of("a","e","i","o","u");
		//var vowelList = List.of("a","e","i","o","u");

		//7.Minimize the scope of local variables.
		scopeOfLocalVariables();

		//8.Using var in try with resource block
		readBatchFile();

		//9.Reading file using buffered reader -Assignment
		System.out.println("Assignment : Refactor readFileBufferedReader to use var");
		readFileBufferedReader();

		//10.Read from URL. - Assignment
		System.out.println("Assignment : Refactor readURL to use var");
		readURL();

		//11.break up chained or nested expressions with local variables.
		Optional<String> mostWatchedMovie =  getMostWatchedMovie_1();
		System.out.println(mostWatchedMovie.orElse("No movie found"));

		//Step one
		Optional<String> mostWatchedMovieStepOne =  getMostWatchedMovie_2();
		System.out.println(mostWatchedMovieStepOne.orElse("No movie found"));

		//Step two
		Optional<String> mostWatchedMovieStepTwo = getMostWatchedMovie_3();
		System.out.println(mostWatchedMovieStepTwo.orElse("No movie found"));
	}

	public static void literals(){
		boolean solved  = false;
		long sum = 0L;
		CrimeSceneSearchCriteria crimeSceneSearchCriteria = new CrimeSceneSearchCriteria();
		String detective = "Sherlock Holmes";

		//be careful of var with literals
		byte signal = 0; // byte
		//var signal = 0; //int
	}

	public static void forLoopOne(int[] numbers) {
		int max = 0;
		for(int number : numbers){
			if(max < number ) {
				max = number;
			}
		}
		System.out.println("Max is : "+max);
	}

	private static int [] getNumbers(){
		return new int [] {12,4,13,36,77,500};
	}

	public static void forLoopTwo() {
		Map<String, List<String>> movieByGenre = new HashMap<>();

		movieByGenre.put("COMEDY",List.of("Hangover","Pink Panther"));
		movieByGenre.put("ACTION",List.of("Bad Boys","Pulp Fiction"));

		for(Map.Entry<String,List<String>> moviesInGenre : movieByGenre.entrySet() ) {
			List<String> movies = moviesInGenre.getValue();
			//do something with movies.
		}
	}

	public static void readBatchFile() throws URISyntaxException {
		var path =  Paths.get(VarExamples.class.getClassLoader().getResource("batch.log").toURI());

		try(var lines = Files.lines(path)){
			var count = lines.filter(line -> line.contains("Failed"))
						      .count();
			System.out.println("Total errors in batch jobs: "+ count);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFileBufferedReader() throws URISyntaxException {

		var path =  Paths.get(VarExamples.class.getClassLoader().getResource("batch.log").toURI());

		try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
			bufferedReader.lines().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readURL() {
		try{
			URL url = new URL("https://www.oracle.com");
			URLConnection urlConnection = url.openConnection();

			try(InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
				BufferedReader reader  = new BufferedReader(isr))
			{
				Stream<String> lines = reader.lines().limit(5);
				lines.forEach(System.out::println);
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public static Optional<String> getMostWatchedMovie_1() {
		
		List<Movie> movies = getAllMovies();
		
		return movies.stream()
		             .collect(groupingBy(Movie::getName,counting()))
		             .entrySet()
		             .stream()
		             .max(Map.Entry.comparingByValue())
		             .map(Map.Entry::getKey);
	}
	

	public static Optional<String> getMostWatchedMovie_2() {
		
		List<Movie> movies = getAllMovies();
			
        Map<String,Long> movieCountMap = movies.stream()
        								       .collect(groupingBy(Movie::getName,counting()));
		     		
        Optional<Map.Entry<String,Long>>  mostWatchedMovieEntryOpt
                                          = movieCountMap.entrySet()
                                          			     .stream()
		                							     .max(Map.Entry.comparingByValue());
        
        return mostWatchedMovieEntryOpt.map(Map.Entry::getKey);
	
	}

	//break up chained or nested expressions with local variables.
	public static Optional<String> getMostWatchedMovie_3() {
		List<Movie> movies = getAllMovies();

        var movieCountMap = movies.stream()
				                  .collect(groupingBy(Movie::getName,counting()));
		     		
        var mostWatchedMovieEntryOpt = movieCountMap.entrySet()
				                                    .stream()
				                                    .max(Map.Entry.comparingByValue());
        
        return mostWatchedMovieEntryOpt.map(Map.Entry::getKey);
	}



	private static List<Movie> getAllMovies() {

		//var ?
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie("The Departed"));
		movies.add(new Movie("The Mummy"));
		movies.add(new Movie("The Departed"));
		movies.add(new Movie("Bad Boys"));
		movies.add(new Movie("X-Men"));
		movies.add(new Movie("Casino Royale"));
		movies.add(new Movie("Fight Club"));
		movies.add(new Movie("The Departed"));
		
		
		return movies;
	}



	public static Map<Genre,List<Movie>>getMovies() {
		return new HashMap<>();
	}

	//Minimize the scope of local variables
	public static void scopeOfLocalVariables() {
		//change this to set.

		//..lot's of code.
		//..lot's of code.
		//..lot's of code.
		var movies = new HashSet<String>();
		movies.add("Second Last : The Dark Knight");
		movies.add("Last : The Dark Knight Returns");
		for(var movie : movies) {
			System.out.println(movie);
		}
	}
}

class Movie{
	
	private String name;
	
	public Movie(String name) {
		this.name = name ;
	}
	
	public String getName() {
		return name;
	}
	
}
enum Genre{

	ACTION,
	COMEDY,
	HORROR
}

class MovieService {
	
	public List<Movie> getMovies( MovieSearchCriteria movieSearchCriteria){
		return new ArrayList<>();
	}
}

class MovieSearchCriteria{

}
class CrimeSceneSearchCriteria {

}

