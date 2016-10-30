package com.samy.leetcode.algorithm.medium;

public class CoinChange {

	/**
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 * 2016年4月28日
	 * @author Jiupeng
	 * @description 180 test cases, 28ms beats 45.68%
	 * @reference https://leetcode.com/problems/coin-change/
	 * @interpretation https://www.hrwhisper.me/leetcode-coin-change/
	 * dp[i] means what's the least amount of coins that combine could get target i
	 * dp[i + coin] = min(dp[i + coin], dp[i] + 1)
	 */
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int coin : coins)
			if (coin <= amount)
				dp[coin] = 1;
		for (int i = 1; i <= amount; ++i)
			for (int coin : coins) {
				int total = i + coin;
				if (dp[i] > 0 && total <= amount) {
					dp[total] = dp[total] == 0 ? dp[i] + 1 : Math.min(dp[total], dp[i] + 1);
				}
			}
		return dp[amount] == 0 ? amount == 0 ? 0 : -1 : dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = new int[] { 186, 419, 83, 408 };
		int amount = 6249;
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(coins, amount));
	}

}
