package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber {

	/**
	 * 
	 * @param n
	 * @param primes
	 * @return
	 * 2016年3月20日
	 * @author Jiupeng
	 * @description 83 test cases, 51ms beats 27.71%
	 * @reference https://leetcode.com/problems/super-ugly-number/
	 * @interpretation
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(primes.length);
		for (int p : primes) {
			queue.add(new Pair(p));
		}
		for (int i = 1; i < n;) {
			Pair p = queue.poll();
			if (ugly[i - 1] != p.factor)
				ugly[i++] = p.factor;
			++p.index;
			p.factor = p.prime * ugly[p.index];
			queue.add(p);
		}
		return ugly[n - 1];
	}

	class Pair implements Comparable<Pair> {
		final int prime;
		int index;
		int factor;

		Pair(int prime) {
			this.index = 0;
			this.prime = prime;
			this.factor = prime;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return factor < o.factor ? -1 : factor == o.factor ? 0 : 1;
		}
	}

	/**
	 * 
	 * @param n
	 * @param primes
	 * @return
	 * 2016年3月21日
	 * @author Jiupeng
	 * @description 83 test cases, 19ms beats 99.5%
	 * @reference 
	 * @interpretation
	 */
	public int nthSuperUglyNumber2(int n, int[] primes) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int[] index = new int[primes.length];
		int[] factor = Arrays.copyOf(primes, primes.length);
		for (int i = 1; i < n; ++i) {
			ugly[i] = min(factor);
			update(primes, factor, index, ugly, i);
		}
		return ugly[n - 1];
	}

	private int min(int[] factor) {
		int min = Integer.MAX_VALUE;
		for (int f : factor)
			min = f < min ? f : min;
		return min;
	}

	private void update(int[] primes, int[] factor, int[] index, int[] ugly,
			int i) {
		for (int j = 0; j < factor.length; ++j) {
			if (ugly[i] == factor[j]) {
				++index[j];
				factor[j] = primes[j] * ugly[index[j]];
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] primes = { 2, 7, 13, 19 };
		SuperUglyNumber sun = new SuperUglyNumber();
		System.out.println(sun.nthSuperUglyNumber2(n, primes));
	}

}
