package com.samy.leetcode.algorithm;

public class CountPrimes {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月24日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/count-primes/
	 */
	public int countPrimes(int n) {
		boolean[] isNotPrime = new boolean[n];
		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().
		for (int i = 2; i * i < n; ++i) {
			if (isNotPrime[i])
				continue;
			for (int j = i * i; j < n; j += i) {
				isNotPrime[j] = true;
			}
		}
		int count = 0;
		for (int i = 2; i < n; ++i) {
			if (!isNotPrime[i])
				++count;
		}
		return count;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月24日
	 * @author Jiupeng
	 * @description modified version
	 * @reference https://leetcode.com/discuss/81779/12-ms-java-solution-modified-from-the-hint-method-beats-99-95%25
	 */
	public int countPrimesSample(int n) {
		if (n < 3)
			return 0;

		boolean[] f = new boolean[n];
		int count = n >> 1;
		for (int i = 3; i * i < n; i += 2) {
			if (f[i])
				continue;

			for (int j = i * i; j < n; j += 2 * i) {
				if (!f[j]) {
					--count;
					f[j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
