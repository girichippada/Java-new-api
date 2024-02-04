package com.gr.java10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//Example shows how to use copyOf method in a Map.
public class CopyOfMap {

	public static void main(String[] args) {

		var premierLeagueScoresMap = new HashMap<String,Integer>();

		premierLeagueScoresMap.put("Man City", 71);
		premierLeagueScoresMap.put("Man United", 57);
		premierLeagueScoresMap.put("Leicester City", 56);

		usingCopyOf(premierLeagueScoresMap);
		usingUnmodifiableView(premierLeagueScoresMap);
	}

	public static void usingUnmodifiableView(Map<String, Integer> premierLeagueScores) {

		var premierLeagueScoresMapView = Collections.unmodifiableMap(premierLeagueScores);

		// Results in UnsupportedOperationException
		// premierLeagueScoresMapView.put("Chelsea",51);

		premierLeagueScores.put("Chelsea", 51);

		System.out.println("Original - " + premierLeagueScores);
		System.out.println("UnmodifiableMap - " + premierLeagueScoresMapView);

	}

	public static void usingCopyOf(Map<String, Integer> premierLeagueScores) {

		var premierLeagueScoresMapCopy = Map.copyOf(premierLeagueScores);

		// Results in UnsupportedOperationException
		// premierLeagueScoresMapCopy.add("Chelsea",51);

		premierLeagueScores.put("Chelsea", 51);

		System.out.println("Original - " + premierLeagueScores);
		System.out.println("CopyOf - " + premierLeagueScoresMapCopy);
	}

}
