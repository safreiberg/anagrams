package freiberg.anagrams;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Puzzle {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		List<String> herbs = FileReader.readCsvToList("herbs.csv");
		List<String> trees = FileReader.readCsvToList("tree_types.csv");
		
		System.out.println("Time to parse: " + (System.currentTimeMillis() - start) + " milliseconds");
		start = System.currentTimeMillis();
		
		Map<Long, String> treeScores = Words.mapLongs(trees);
		Map<String, Long> herbScores = Words.mapStrings(herbs);
		
		System.out.println("Time to map: " + (System.currentTimeMillis() - start) + " milliseconds");
		start = System.currentTimeMillis();
		// one tree, two herbs
		for (Map.Entry<String, Long> herb1 : herbScores.entrySet()) {
			for (Map.Entry<String, Long> herb2 : herbScores.entrySet()) {
				long combined = herb1.getValue() * herb2.getValue();
				if (treeScores.containsKey(combined)) {
					System.out.println("Match found: " + treeScores.get(combined) + ", with " + herb1.getKey() + " and " + herb2.getKey());
				}
			}
		}
		System.out.println("Time to search: " + (System.currentTimeMillis() - start) + " milliseconds");
	}
}
