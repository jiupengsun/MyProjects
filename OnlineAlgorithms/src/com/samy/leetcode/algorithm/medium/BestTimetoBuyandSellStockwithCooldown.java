package com.samy.leetcode.algorithm.medium;

public class BestTimetoBuyandSellStockwithCooldown {

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年1月31日
	 * @author Jiupeng
	 * @description 212 test cases, 2ms beats 47.7%
	 * @reference https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
	 * @interpretation https://leetcode.com/discuss/76929/o-n-java-solution-3ms
	 */
	public static int maxProfit(int[] prices) {
		int l = prices.length;
		if (l < 2)
			return 0;
		int buy = -prices[0], sell = 0, cooldown = 0;
		for (int i = 1, current, temp; i < l; ++i) {
			current = buy;
			//get the lower buy price, notice here the buy is a negative integer
			//if yesterday we take cooldown, then the new buy price is cooldown - prices[i]
			//if it's smaller, then take it, otherwise we didn't buy
			temp = cooldown - prices[i];
			buy = buy > temp ? buy : temp;
			//if sell could get larger profit, then sell
			cooldown = sell > cooldown ? sell : cooldown;
			//
			temp = current + prices[i];
			sell = sell > temp ? sell : temp;
		}
		return sell > cooldown ? sell : cooldown;
	}

	/**
	 * 
	 * @param prices
	 * @return
	 * 2016年2月1日
	 * @author Jiupeng
	 * @description 212 test cases, beats 47.7%
	 * @reference http://yuancrackcode.com/2015/11/24/best-time-to-buy-and-sell-stock-with-cooldown/
	 */
	public static int maxProfit2(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int l = prices.length;
		int[] profit = new int[l];
		profit[0] = 0;
		profit[1] = Math.max(0, prices[1] - prices[0]);
		int buy = prices[0] < prices[1] ? prices[0] : prices[1];
		for (int i = 2, diff; i < l; ++i) {
			//cooldown or sell on the i-th day
			diff = prices[i] - buy;
			profit[i] = profit[i - 1] > diff ? profit[i - 1] : diff;
			//take the lower buy price, buy today or not
			//if sell on the day before yesterday, and the price is lower than current buy price
			//then do it
			diff = prices[i] - profit[i - 2];
			buy = buy < diff ? buy : diff;
		}
		return profit[l - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9 };
		System.out.println(maxProfit2(prices));
	}

}
