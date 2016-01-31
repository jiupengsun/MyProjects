package com.samy.leetcode.algorithm.medium;

public class BestTimetoBuyandSellStock {

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年1月31日
	 * @author Jiupeng
	 * @description 198 test cases, 2ms beats 59.42%
	 * @reference https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * @interpretation
	 */
	public int maxProfit(int[] prices) {
		int l = prices.length;
		if (l < 2)
			return 0;
		int min = 0, max = 0, interval_min = 0;
		for (int i = 1, rise = 0; i < l; ++i) {
			//find minimum
			while (i < l && prices[i] <= prices[i - 1])
				++i;
			rise = i - 1;
			if (prices[rise] < prices[interval_min])
				interval_min = rise;
			//find maximum
			while (i < l && prices[i] >= prices[i - 1])
				++i;
			if (prices[i - 1] > prices[max]) {
				max = i - 1;
				if (prices[rise] < prices[min])
					min = rise;
			} else if (prices[i - 1] - prices[rise] > prices[max] - prices[min]) {
				max = i - 1;
				min = rise;
			}
		}
		if (interval_min < max)
			min = interval_min;
		return prices[max] - prices[min];
	}

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年1月31日
	 * @author Jiupeng
	 * @description DP solution, 1ms beats 95.39%
	 * @reference https://leetcode.com/discuss/79390/java-simple-dp-solutions-3ms
	 * @interpretation
	 */
	public int maxProfitSample(int[] prices) {
		int buy = Integer.MAX_VALUE, sell = 0;
		for (int price : prices) {
			int diff = price - buy;
			sell = sell > diff ? sell : diff;
			buy = buy < price ? buy : price;
		}
		return sell;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 3, 2, 6, 5, 0, 3 };

		BestTimetoBuyandSellStock bt = new BestTimetoBuyandSellStock();
		System.out.println(bt.maxProfit(prices));
	}

}
