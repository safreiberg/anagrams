package freiberg.anagrams;

import java.util.List;

import com.google.common.collect.Lists;

public class Primes {
	private static List<Long> primes = Lists.newArrayList();
	
	public static long getPrime(int n) {
		if (n >= primes.size()) {
			populatePrimes(n + 1);
		}
		return primes.get(n);
	}
	
	private static long getLastPrime() {
		if (primes.size() == 0) {
			primes.add(2L);
		}
		return primes.get(primes.size() - 1);
	}
	
	private static void populatePrimes(int n) {
		long candidate = getLastPrime() + 1;
		while (primes.size() < n) {
			if (isPrime(candidate)) {
				primes.add(candidate);
			}
			candidate++;
		}
	}
	
	private static boolean isPrime(long n) {
		if (primes.contains(n)) {
			return true;
		}
		boolean prime = true;
		for (long factor : primes) {
			long num = n / factor;
			if (num * factor == n) {
				prime = false;
				break;
			}
		}
		return prime;
	}
}
