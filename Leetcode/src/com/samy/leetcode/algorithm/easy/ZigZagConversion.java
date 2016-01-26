package com.samy.leetcode.algorithm.easy;

public class ZigZagConversion {

	/**
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 * 2016年1月4日
	 * @author Jiupeng
	 * @description More efficient!!!
	 * @reference 
	 */
	public String convertSample1(String s, int numRows) {
		if (numRows < 2 || s.length() < numRows)
			return s;
		char[] converted = new char[s.length()];
		int step = (numRows - 1) << 1, index = 0;
		for (int i = 0; i <= numRows - 1; ++i) {
			for (int j = i, addChar = step - i; j < s
					.length(); j += step, addChar += step) {
				converted[index++] = s.charAt(j);
				// addChar is the complement of i
				if (i % (numRows - 1) != 0 && addChar < s.length())
					converted[index++] = s.charAt(addChar);
			}
		}
		return new String(converted);
	}

	public String convert(String s, int numRows) {
		int length = s.length();
		// count the number of each group
		/*
		 * 0   4
		 * 1 3 5 = 4
		 * 2   6
		 */
		int L = (numRows - 1) << 1;
		if (L == 0)
			return s;
		char[] sb = new char[length];
		for (int i = 0; i < length; ++i) {
			int row = Math.min(i % L, L - i % L);
			int sum = 0;
			for (int j = 0; j <= row; ++j) {
				int N = j < row ? length - 1 : i;
				sum += complement(N, L, j);
				if (j != (L - j) % L)
					sum += complement(N, L, L - j);
			}
			sb[sum - 1] = s.charAt(i);
		}

		return new String(sb);
	}

	/**
	 * 
	 * @param N
	 * @param c
	 * @param remainder
	 * @return 2016年1月4日
	 * @author Jiupeng
	 * @description Counting how many numbers between 0 and N inclusive, which
	 *              divides c with the remainder %remainder%
	 * @reference
	 */
	private int complement(int N, int c, int remainder) {
		return (N + c - (remainder % c)) / c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AA";
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert(s, 4));
	}

}
