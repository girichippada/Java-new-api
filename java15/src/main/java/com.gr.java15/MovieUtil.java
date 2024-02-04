package com.gr.java15;

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

		List<String> starCast = new ArrayList<>();
		starCast.add("Daniel Craig");
		starCast.add("Eva Green");

		Movie casinoRoyale = new Movie("Casino Royale", starCast, LocalDate.of(2006, 11, 14)
				,  "Martin Campbell", Genre.ACTION, 4, 606_099_584);
		movieScore.put(casinoRoyale,9);

		// Avengers, Rating 5

		List<String> avengersStarCast = new ArrayList<>();
		avengersStarCast.add("Robert Downey Jr.");
		avengersStarCast.add("Chris Evans");
		avengersStarCast.add("Mark Ruffalo");
		avengersStarCast.add("Chris Hemsworth");

		Movie avengers = new Movie("Avengers:Endgame", avengersStarCast, LocalDate.of(2019, 04, 26)
				,"Anthony Russo", Genre.SUPERHERO, 5, 3_000_000_000L);
		movieScore.put(avengers,10);

		// Johnny English, Rating 4

		List<String> johnyEnglishStarCast = new ArrayList<>();
		johnyEnglishStarCast.add("Rowan Atkinson");

		Movie johnyEnglish = new Movie("Johnny English", johnyEnglishStarCast, LocalDate.of(2003, 04, 11)
				,"Peter Howitt", Genre.COMEDY, 4, 159_000_000);
		movieScore.put(johnyEnglish,8);

		// The Departed, Rating 5

		List<String> departedStarCast = new ArrayList<>();
		departedStarCast.add("Leonardo DiCaprio");
		departedStarCast.add("Matt Damon");
		departedStarCast.add("Jack Nicholson");

		Movie departed = new Movie("The Departed", departedStarCast, LocalDate.of(2006, 9, 26)
				,"Martin Scorsese", Genre.CRIME, 5, 291_000_000);
		movieScore.put(departed,7);


		/*// The grudge, Rating 3
		Movie grudge = new Movie("The Grudge", "Nicolas Pesce");

		List<String> grudgeStarCast = new ArrayList<>();
		grudgeStarCast.add("John Cho");
		grudgeStarCast.add("Andrea Riseborough");

		grudge.setCast(grudgeStarCast);
		grudge.setGenre(Genre.HORROR);
		grudge.setRating(3);
		grudge.setDateOfRelease(LocalDate.of(2020, 1, 3));
		grudge.setGrossEarning(50_000_000);
		movieScore.put(grudge,5);


		// The wolf of wall street, Rating 5
		Movie wows = new Movie("The Wolf Of Wall Street", "Martin Scorsese");

		List<String> wowfStarCast = new ArrayList<>();
		wowfStarCast.add("Leonardo DiCaprio");
		wowfStarCast.add("Jonah Hill");
		wowfStarCast.add("Margot Robbie");

		wows.setCast(wowfStarCast);
		wows.setGenre(Genre.CRIME);
		wows.setRating(5);
		wows.setDateOfRelease(LocalDate.of(2013, 12, 25));
		wows.setGrossEarning(392_000_000);
		movieScore.put(wows,7);


		// Once upon a time in hollywood, Rating 5
		Movie onceHollywood = new Movie("Once upon a time in Hollywood", "Quentin Tarantino");

		List<String> onceHollyWoodStarCast = new ArrayList<>();
		onceHollyWoodStarCast.add("Leonardo DiCaprio");
		onceHollyWoodStarCast.add("Brad Pitt");
		onceHollyWoodStarCast.add("Margot Robbie");

		onceHollywood.setCast(onceHollyWoodStarCast);
		onceHollywood.setGenre(Genre.COMEDY);
		onceHollywood.setRating(5);
		onceHollywood.setDateOfRelease(LocalDate.of(2019, 7, 26));
		onceHollywood.setGrossEarning(374_000_000);
		movieScore.put(onceHollywood,9);


		// Fight club, Rating 5
		Movie fightClub = new Movie("Fight Club", "David Fincher");

		List<String> fightClubStarCast = new ArrayList<>();
		fightClubStarCast.add("Brad Pitt");
		fightClubStarCast.add("Edward Norton");

		fightClub.setCast(fightClubStarCast);
		fightClub.setGenre(Genre.ACTION);
		fightClub.setRating(5);
		fightClub.setDateOfRelease(LocalDate.of(1999, 10, 10));
		fightClub.setGrossEarning(101_000_000);
		movieScore.put(fightClub,9);


		// Bad Boys For Life ,Rating 3
		Movie badBoys = new Movie("Bad Boys For Life", "Adil El Arbi");

		List<String> badBoysStarCast = new ArrayList<>();
		badBoysStarCast.add("Will Smith");
		badBoysStarCast.add("Martin Lawrence");

		badBoys.setCast(badBoysStarCast);
		badBoys.setGenre(Genre.ACTION);
		badBoys.setRating(3);
		badBoys.setDateOfRelease(LocalDate.of(2020, 01, 17));
		badBoys.setGrossEarning(291_000_000);
		movieScore.put(badBoys,6);*/


		movies.add(casinoRoyale);
		movies.add(avengers);
		movies.add(johnyEnglish);
		movies.add(departed);
		/*movies.add(grudge);
		movies.add(wows);
		movies.add(onceHollywood);
		movies.add(fightClub);
		movies.add(badBoys);*/

		return movies;
	}
	/*public static List<Movie> getMovieData() {

		// casino royale, Rating 4
		Movie casinoRoyale = new Movie("Casino Royale", "Martin Campbell");

		List<String> starCast = new ArrayList<>();
		starCast.add("Daniel Craig");
		starCast.add("Eva Green");

		casinoRoyale.setCast(starCast);
		casinoRoyale.setGenre(Genre.ACTION);
		casinoRoyale.setRating(4);
		casinoRoyale.setDateOfRelease(LocalDate.of(2006, 11, 14));
		casinoRoyale.setGrossEarning(606_099_584);
		movieScore.put(casinoRoyale,9);

		// Avengers, Rating 5
		Movie avengers = new Movie("Avengers:Endgame", "Anthony Russo");

		List<String> avengersStarCast = new ArrayList<>();
		avengersStarCast.add("Robert Downey Jr.");
		avengersStarCast.add("Chris Evans");
		avengersStarCast.add("Mark Ruffalo");
		avengersStarCast.add("Chris Hemsworth");

		avengers.setCast(avengersStarCast);
		avengers.setGenre(Genre.SUPERHERO);
		avengers.setRating(5);
		avengers.setDateOfRelease(LocalDate.of(2019, 04, 26));
		avengers.setGrossEarning(3_000_000_000L);
		movieScore.put(avengers,10);

		// Johnny English, Rating 4
		Movie johnyEnglish = new Movie("Johnny English", "Peter Howitt");

		List<String> johnyEnglishStarCast = new ArrayList<>();
		johnyEnglishStarCast.add("Rowan Atkinson");

		johnyEnglish.setCast(johnyEnglishStarCast);
		johnyEnglish.setGenre(Genre.COMEDY);
		johnyEnglish.setRating(4);
		johnyEnglish.setDateOfRelease(LocalDate.of(2003, 04, 11));
		johnyEnglish.setGrossEarning(159_000_000);
		movieScore.put(johnyEnglish,8);

		// The Departed, Rating 5
		Movie departed = new Movie("The Departed", "Martin Scorsese");

		List<String> departedStarCast = new ArrayList<>();
		departedStarCast.add("Leonardo DiCaprio");
		departedStarCast.add("Matt Damon");
		departedStarCast.add("Jack Nicholson");

		departed.setCast(departedStarCast);
		departed.setGenre(Genre.CRIME);
		departed.setRating(5);
		departed.setDateOfRelease(LocalDate.of(2006, 9, 26));
		departed.setGrossEarning(291_000_000);
		movieScore.put(departed,7);


		// The grudge, Rating 3
		Movie grudge = new Movie("The Grudge", "Nicolas Pesce");

		List<String> grudgeStarCast = new ArrayList<>();
		grudgeStarCast.add("John Cho");
		grudgeStarCast.add("Andrea Riseborough");

		grudge.setCast(grudgeStarCast);
		grudge.setGenre(Genre.HORROR);
		grudge.setRating(3);
		grudge.setDateOfRelease(LocalDate.of(2020, 1, 3));
		grudge.setGrossEarning(50_000_000);
		movieScore.put(grudge,5);


		// The wolf of wall street, Rating 5
		Movie wows = new Movie("The Wolf Of Wall Street", "Martin Scorsese");

		List<String> wowfStarCast = new ArrayList<>();
		wowfStarCast.add("Leonardo DiCaprio");
		wowfStarCast.add("Jonah Hill");
		wowfStarCast.add("Margot Robbie");

		wows.setCast(wowfStarCast);
		wows.setGenre(Genre.CRIME);
		wows.setRating(5);
		wows.setDateOfRelease(LocalDate.of(2013, 12, 25));
		wows.setGrossEarning(392_000_000);
		movieScore.put(wows,7);


		// Once upon a time in hollywood, Rating 5
		Movie onceHollywood = new Movie("Once upon a time in Hollywood", "Quentin Tarantino");

		List<String> onceHollyWoodStarCast = new ArrayList<>();
		onceHollyWoodStarCast.add("Leonardo DiCaprio");
		onceHollyWoodStarCast.add("Brad Pitt");
		onceHollyWoodStarCast.add("Margot Robbie");

		onceHollywood.setCast(onceHollyWoodStarCast);
		onceHollywood.setGenre(Genre.COMEDY);
		onceHollywood.setRating(5);
		onceHollywood.setDateOfRelease(LocalDate.of(2019, 7, 26));
		onceHollywood.setGrossEarning(374_000_000);
		movieScore.put(onceHollywood,9);


		// Fight club, Rating 5
		Movie fightClub = new Movie("Fight Club", "David Fincher");

		List<String> fightClubStarCast = new ArrayList<>();
		fightClubStarCast.add("Brad Pitt");
		fightClubStarCast.add("Edward Norton");

		fightClub.setCast(fightClubStarCast);
		fightClub.setGenre(Genre.ACTION);
		fightClub.setRating(5);
		fightClub.setDateOfRelease(LocalDate.of(1999, 10, 10));
		fightClub.setGrossEarning(101_000_000);
		movieScore.put(fightClub,9);


		// Bad Boys For Life ,Rating 3
		Movie badBoys = new Movie("Bad Boys For Life", "Adil El Arbi");

		List<String> badBoysStarCast = new ArrayList<>();
		badBoysStarCast.add("Will Smith");
		badBoysStarCast.add("Martin Lawrence");

		badBoys.setCast(badBoysStarCast);
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
	}*/

	public static int getScore(Movie movie){
		return movieScore.get(movie);
	}
}
