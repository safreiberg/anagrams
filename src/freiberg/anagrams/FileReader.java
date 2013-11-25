package freiberg.anagrams;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.google.common.collect.Lists;

public class FileReader {
	public static List<String> readCsvToList(String filename) throws IOException {
		List<String> lines = FileUtils.readLines(new File(filename));
		List<String> cleanLines = Lists.newArrayList();
		for (String line : lines) {
			cleanLines.add(toLowerNoFormat(line));
		}
		return cleanLines;
	}
	
	public static String toLowerNoFormat(String s) {
		return s.replaceAll("[^a-zA-Z]", "").toLowerCase();
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(readCsvToList("tree_types.csv"));
		System.out.println(readCsvToList("herbs.csv"));
	}
}
