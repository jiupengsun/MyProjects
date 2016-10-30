package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class BulbSwitcher {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年2月15日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/bulb-switcher/
	 * @interpretation https://leetcode.com/discuss/75014/math-solution
	 */
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年2月15日
	 * @author Jiupeng
	 * @description a slow solution, o(n^2)
	 * @reference
	 * @interpretation
	 */
	public int bulbSwitchSlow(int n) {
		boolean[] bulbs = new boolean[n];
		int on = n;
		//round 1
		Arrays.fill(bulbs, true);
		//round 2...n
		for (int i = 2; i <= n; ++i) {
			for (int j = i; j <= n; j += i) {
				bulbs[j - 1] = !bulbs[j - 1];
				if (bulbs[j - 1])
					++on;
				else
					--on;
			}
		}
		return on;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] b = new boolean[0];
		Arrays.fill(b, true);
	}

}
