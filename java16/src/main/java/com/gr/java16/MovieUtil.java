package com.gr.java16;

import com.gr.java15.Genre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Populates movie related data.
public class MovieUtil {

	private static List<Movie> movies = new ArrayList<>();

	private final static Map<Movie,Integer> movieScore = new HashMap<>();

	public static List<Movie> getMovieData() {

		// casino royale, Rating 4
		var casinoRoyale = new Movie("Casino Royale", "Martin Campbell");

		var starCastList = new ArrayList<String>();
		starCastList.add("Daniel Craig");
		starCastList.add("Eva Green");

		casinoRoyale.setCast(starCastList);
		casinoRoyale.setGenre(Genre.ACTION);
		casinoRoyale.setRating(4);
		casinoRoyale.setDateOfRelease(LocalDate.of(2006, 11, 14));
		casinoRoyale.setGrossEarning(606_099_584);
		movieScore.put(casinoRoyale,9);

		// Avengers, Rating 5
		var avengers = new Movie("Avengers:Endgame", "Anthony Russo");

		var avengersStarCastList = new ArrayList<String>();
		avengersStarCastList.add("Robert Downey Jr.");
		avengersStarCastList.add("Chris Evans");
		avengersStarCastList.add("Mark Ruffalo");
		avengersStarCastList.add("Chris Hemsworth");

		avengers.setCast(avengersStarCastList);

		avengers.setGenre(Genre.SUPERHERO);
		avengers.setRating(5);
		avengers.setDateOfRelease(LocalDate.of(2019, 04, 26));
		avengers.setGrossEarning(3_000_000_000L);
		movieScore.put(avengers,10);

		// Johnny English, Rating 4
		var johnyEnglish = new Movie("Johnny English", "Peter Howitt");

		var johnyEnglishStarCastList = new ArrayList<String>();
		johnyEnglishStarCastList.add("Rowan Atkinson");

		johnyEnglish.setCast(johnyEnglishStarCastList);
		johnyEnglish.setGenre(Genre.COMEDY);
		johnyEnglish.setRating(4);
		johnyEnglish.setDateOfRelease(LocalDate.of(2003, 04, 11));
		johnyEnglish.setGrossEarning(159_000_000);
		movieScore.put(johnyEnglish,8);

		// The Departed, Rating 5
		var departed = new Movie("The Departed", "Martin Scorsese");

		var departedStarCastList = new ArrayList<String>();
		departedStarCastList.add("Leonardo DiCaprio");
		departedStarCastList.add("Matt Damon");
		departedStarCastList.add("Jack Nicholson");

		departed.setCast(departedStarCastList);
		departed.setGenre(Genre.CRIME);
		departed.setRating(5);
		departed.setDateOfRelease(LocalDate.of(2006, 9, 26));
		departed.setGrossEarning(291_000_000);
		movieScore.put(departed,7);


		// The grudge, Rating 3
		var grudge = new Movie("The Grudge", "Nicolas Pesce");

		var grudgeStarCastList = new ArrayList<String>();
		grudgeStarCastList.add("John Cho");
		grudgeStarCastList.add("Andrea Riseborough");

		grudge.setCast(grudgeStarCastList);
		grudge.setGenre(Genre.HORROR);
		grudge.setRating(3);
		grudge.setDateOfRelease(LocalDate.of(2020, 1, 3));
		grudge.setGrossEarning(50_000_000);
		movieScore.put(grudge,5);


		// The wolf of wall street, Rating 5
		var wows = new Movie("The Wolf Of Wall Street", "Martin Scorsese");

		var wowfStarCastList = new ArrayList<String>();
		wowfStarCastList.add("Leonardo DiCaprio");
		wowfStarCastList.add("Jonah Hill");
		wowfStarCastList.add("Margot Robbie");

		wows.setCast(wowfStarCastList);
		wows.setGenre(Genre.CRIME);
		wows.setRating(5);
		wows.setDateOfRelease(LocalDate.of(2013, 12, 25));
		wows.setGrossEarning(392_000_000);
		movieScore.put(wows,7);


		// Once upon a time in hollywood, Rating 5
		var onceHollywood = new Movie("Once upon a time in Hollywood", "Quentin Tarantino");

		var onceHollyWoodStarCastList = new ArrayList<String>();
		onceHollyWoodStarCastList.add("Leonardo DiCaprio");
		onceHollyWoodStarCastList.add("Brad Pitt");
		onceHollyWoodStarCastList.add("Margot Robbie");

		onceHollywood.setCast(onceHollyWoodStarCastList);
		onceHollywood.setGenre(Genre.COMEDY);
		onceHollywood.setRating(5);
		onceHollywood.setDateOfRelease(LocalDate.of(2019, 7, 26));
		onceHollywood.setGrossEarning(374_000_000);
		movieScore.put(onceHollywood,9);


		// Fight club, Rating 5
		var fightClub = new Movie("Fight Club", "David Fincher");

		var fightClubStarCastList = new ArrayList<String>();
		fightClubStarCastList.add("Brad Pitt");
		fightClubStarCastList.add("Edward Norton");

		fightClub.setCast(fightClubStarCastList);
		fightClub.setGenre(Genre.ACTION);
		fightClub.setRating(5);
		fightClub.setDateOfRelease(LocalDate.of(1999, 10, 10));
		fightClub.setGrossEarning(101_000_000);
		movieScore.put(fightClub,9);


		// Bad Boys For Life ,Rating 3
		var badBoys = new Movie("Bad Boys For Life", "Adil El Arbi");

		var badBoysStarCastList = new ArrayList<String>();
		badBoysStarCastList.add("Will Smith");
		badBoysStarCastList.add("Martin Lawrence");

		badBoys.setCast(badBoysStarCastList);
		badBoys.setGenre(Genre.ACTION);
		badBoys.setRating(3);
		badBoys.setDateOfRelease(LocalDate.of(2020, 01, 17));
		badBoys.setGrossEarning(291_000_000);
		movieScore.put(badBoys,6);


		movies.add(casinoRoyale);
		movies.add(avengers);
		movies.add(johnyEnglish);
		movies.add(departed);
		movies.add(grudge);
		movies.add(wows);
		movies.add(onceHollywood);
		movies.add(fightClub);
		movies.add(badBoys);
		
		return movies;
	}

	public static int getScore(Movie movie){
		return movieScore.get(movie);
	}
}
