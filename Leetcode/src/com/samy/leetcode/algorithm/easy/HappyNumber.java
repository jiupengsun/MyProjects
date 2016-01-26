package com.samy.leetcode.algorithm.easy;

public class HappyNumber {

	//this is the bitset representation of happy numbers in range[0,810)
	private static final long[] happyMark = new long[] { 580548859274370L,
			35812649762896L, 5764889547766761510L, 158621866461187L,
			-9061136725337702208L, -8574391826910016959L, 4683743612499927428L,
			286423854940160L, 29290989780729856L, 7566260683533189120L,
			1170945809492058640L, 720593571220033568L, 292095590400L };

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/happy-number/
	 */
	public static boolean isHappy(int n) {
		if (n > 0) {
			int digit = 0, d;
			while (true) {
				while (n > 0) {
					d = n % 10;
					digit += d * d;
					n /= 10;
				}
				if (digit > 9) {
					n = digit;
					digit = 0;
				} else
					return digit == 1;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param n
	 * @return
	 * 2016年1月14日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/discuss/74503/1ms-java-solution
	 */
	public static boolean isHappySample(int n) {
		if (n > 810) {
			int sum = 0, remainder = 0;
			while (n > 0) {
				remainder = n % 10;
				sum += remainder * remainder;
				n /= 10;
			}
			n = sum;
		}
		int idx = (n >> 6);
		long bitRep = (1L << (n & 0x3f));
		return (happyMark[idx] & bitRep) != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 810; ++i) {
			if (isHappy(i))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
	}

}
