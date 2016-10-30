package com.samy.leetcode.algorithm.medium;

public class GasStation {

	/**
	 * 
	 * @param gas
	 * @param cost
	 * @return
	 * Apr 8, 2016
	 * @author Jiupeng
	 * @description 16 test cases, 0ms beats 90.11%
	 * @reference https://leetcode.com/problems/gas-station/
	 * @interpretation
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int min = Integer.MAX_VALUE, sum = 0, index = 0;
		int l = gas.length;
		for (int i = 0; i < l; ++i) {
			sum += gas[i] - cost[i];
			if (sum < min) {
				min = sum;
				index = i;
			}
		}
		return sum >= 0 ? index == l - 1 ? 0 : index + 1 : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
