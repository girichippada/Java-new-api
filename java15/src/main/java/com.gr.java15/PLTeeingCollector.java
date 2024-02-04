package com.gr.java15;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

//Shows example of Teeing Collector and a record together.
//Solution to assignment number 1.
@Slf4j
public class PLTeeingCollector {
	
	public static void main(String[] args) {
		
		List<PremierLeague> teamsData = getLeagueData();

		var premierLeagueStatistics= getMostAndLeastWinningTeams(teamsData);

		log.info("Team with minimum wins : " + premierLeagueStatistics.min().name());
		log.info("Team with max points : "+premierLeagueStatistics.max().name());
		
	}



	public static MinMax<PremierLeague> getMostAndLeastWinningTeams(List<PremierLeague> teams){
		Comparator<PremierLeague> compareByNoOfWins = Comparator.comparingInt(PremierLeague::won);
		return teams
				.stream()
				.collect(Collectors.teeing(
						minBy(compareByNoOfWins),
						maxBy(compareByNoOfWins),
						(min, max) -> new MinMax<>(min.orElse(null), max.orElse(null))
				));

	}






















	private static PremierLeagueStatistics getLeagueStatistics(List<PremierLeague> teamsData) {
		return teamsData.stream()
				        .collect(teeing(
				        		minBy(comparing(PremierLeague::won)),
								maxBy(comparing(PremierLeague::points)),
								(minWins, maxPoints) -> new PremierLeagueStatistics(
								minWins.orElse(null), maxPoints.orElse(null)
						        )
						)
				);
	}

	private static List<PremierLeague> getLeagueData(){

		var premierLeagueTeamsList = new ArrayList<PremierLeague>();

		var manCity = new PremierLeague("Man City", 23, 3, 74);

		var leicester = new PremierLeague("Leicester City", 17, 8, 56);

		var manUtd = new PremierLeague("Man United", 17, 4, 60);

		var westBrom = new PremierLeague("West Brom", 4, 17, 21);

		var shefUnited = new PremierLeague("Sheffield United", 4, 17, 14);

		premierLeagueTeamsList.add(manCity);
		premierLeagueTeamsList.add(leicester);
		premierLeagueTeamsList.add(manUtd);
		premierLeagueTeamsList.add(westBrom);
		premierLeagueTeamsList.add(shefUnited);

		premierLeagueTeamsList.forEach(team -> log.info("team: {}", team));
		
		return premierLeagueTeamsList;
	}
}

record PremierLeague (String name, int won, int lost, int points){ }

record PremierLeagueStatistics(PremierLeague minWinsTeam, PremierLeague maxPointsTeam) { }