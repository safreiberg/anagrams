package freiberg.anagrams;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class Words {
	public static long score(String s) {
		long l = 1;
		for (int i = 0; i < s.length(); i++){
		    char c = s.charAt(i);
		    l *= Primes.getPrime(Character.getNumericValue(c) - 10);
		}
		return l;
	}
	
	public static Map<String, Long> mapStrings(List<String> words) {
		Map<String, Long> map = Maps.newHashMap();
		for (String s : words) {
			map.put(s, score(s));
		}
		return map;
	}
	
	public static Map<Long, String> mapLongs(List<String> words) {
		Map<Long, String> map = Maps.newHashMap();
		for (String s : words) {
			map.put(score(s), s);
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(score("ABC"));
	}
}
