package com.samy.leetcode.algorithm.medium;

public class PerfectSquares {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê3ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/perfect-squares/
	 * @interpretation
	 */
	public int numSquares(int n) {
		int min = Integer.MAX_VALUE;
		int sqrt = (int)Math.sqrt(n);
		for(int i=sqrt; i>0; --i){
			int s = i*i;
			if(n % s == 0){
				min = Math.min(min, n / s);
				continue;
			} else{
				int t = n / s;
				t += numSquares
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.sqrt(16));
	}

}
