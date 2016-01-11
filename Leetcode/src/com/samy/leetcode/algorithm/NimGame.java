package com.samy.leetcode.algorithm;

public class NimGame {

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/nim-game/
	 */
	public static boolean canWinNim(int n) {
		return (n & 0x3) != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 13;
		System.out.println((x >> 2 << 2) == x);
	}

}
