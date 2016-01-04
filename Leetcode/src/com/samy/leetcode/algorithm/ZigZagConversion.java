package com.samy.leetcode.algorithm;

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		StringBuilder sb = new StringBuilder(s.length());
		for (int i = 0; i < s.length(); i++) {
			// sb.setCharAt(, s.charAt(i));
		}

		return sb.toString();
	}

	public String convert1(String s, int numRows) {
		int length = s.length();
		int L = 2 * numRows - 2;
		int col = length / L - 1;
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		int row = 3;
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert(s, row));
	}

}
