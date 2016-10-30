package com.samy.leetcode.algorithm.medium;

public class BestTimetoBuyandSellStockII {

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年1月31日
	 * @author Jiupeng
	 * @description 198 test cases, 1ms beats 92.45%. o(2n)
	 * @reference https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	 * @interpretation
	 */
	public int maxProfit(int[] prices) {
		int profit = 0, rise = 0, l = prices.length;
		//n times comparison and n times plus
		for (int i = 1; i < l; ++i) {
			while (i < l && prices[i] <= prices[i - 1])
				++i;
			rise = i - 1;
			while (i < l && prices[i] >= prices[i - 1])
				++i;
			profit += prices[i - 1] - prices[rise];
		}
		return profit;
	}

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年1月31日
	 * @author Jiupeng
	 * @description 2ms, beats 15.49%. o(5n) time complexity
	 * @reference https://leetcode.com/discuss/82733/very-simple-java-solution-with-explanation
	 * @interpretation
	 */
	public int maxProfitSample(int[] prices) {
		int gain = 0, l = prices.length;
		//n times comparison, n times plus
		for (int i = 0, diff; i < l - 1; ++i) {
			//n times mimus
			diff = prices[i + 1] - prices[i];
			//n times comparison
			diff = diff > 0 ? diff : 0;
			//n times plus
			gain += diff;
		}
		//totally 5n times operation
		return gain;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
