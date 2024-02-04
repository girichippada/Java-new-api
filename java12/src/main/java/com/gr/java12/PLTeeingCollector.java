package com.gr.java12;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.teeing;

import java.util.ArrayList;
import java.util.List;

//Shows example of Teeing Collector.
//Solution to assignment number 1.
public class PLTeeingCollector {
	
	public static void main(String[] args) {
		
		List<PremierLeague> teamsData = getLeagueData();

		var premierLeagueStatistics
				= teamsData.stream()
					       .collect(teeing(
					       		           minBy(comparing(PremierLeague::getWon)),
		    		 				       maxBy(comparing(PremierLeague::getPoints)),
								 	       (minWins,maxPoints) -> new PremierLeagueStatistics(
								 	      		minWins.orElse(null),maxPoints.orElse(null)
										   )
 		    		                    )
					    		   );

		System.out.println("Team with minimum wins : " + premierLeagueStatistics.getMinWinsTeam().getName());
		System.out.println("Team with max points : "+premierLeagueStatistics.getMaxPointsTeam().getName());
		
	}
	
	private static List<PremierLeague> getLeagueData(){
		var premierLeagueTeamsList = new ArrayList<PremierLeague>();

		var manCity = new PremierLeague("Man City");
		manCity.setPoints(74);
		manCity.setWon(23);
		manCity.setLost(3);

		var leicester = new PremierLeague("Leicester City");
		leicester.setPoints(56);
		leicester.setWon(17);
		leicester.setLost(8);

		var manUtd = new PremierLeague("Man United");
		manUtd.setPoints(60);
		manUtd.setWon(17);
		manUtd.setLost(4);

		var westBrom = new PremierLeague("West Brom");
		westBrom.setPoints(21);
		westBrom.setWon(4);
		westBrom.setLost(17);

		var shefUnited = new PremierLeague("Sheffield United");
		shefUnited.setPoints(14);
		shefUnited.setWon(4);
		shefUnited.setLost(17);

		premierLeagueTeamsList.add(manCity);
		premierLeagueTeamsList.add(leicester);
		premierLeagueTeamsList.add(manUtd);
		premierLeagueTeamsList.add(westBrom);
		premierLeagueTeamsList.add(shefUnited);
		
		return premierLeagueTeamsList;
	}
}

class PremierLeague{
	private String name;
	private int won;
	private int lost;
	private int points;
	
	public PremierLeague(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

class PremierLeagueStatistics{

	private final PremierLeague minWinsTeam;
	private final PremierLeague maxPointsTeam;

	public PremierLeagueStatistics(PremierLeague minWinsTeam,PremierLeague maxPointsTeam){
		this.minWinsTeam = minWinsTeam;
		this.maxPointsTeam = maxPointsTeam;
	}

	public PremierLeague getMinWinsTeam(){
		return minWinsTeam;
	}

	public PremierLeague getMaxPointsTeam(){
		return maxPointsTeam;
	}
}