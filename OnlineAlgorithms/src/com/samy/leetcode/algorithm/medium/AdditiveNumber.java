package com.samy.leetcode.algorithm.medium;

public class AdditiveNumber {

	/**
	 * 
	 * @param num
	 * @return
	 * Apr 11, 2016
	 * @author Jiupeng
	 * @description 37 test cases, 2ms beats 68.74%
	 * @reference https://leetcode.com/problems/additive-number/
	 * @interpretation
	 */
	public boolean isAdditiveNumber(String num) {
		int l = num.length();
		long n1, n2, n3;
		for (int i = 1; i <= l-1; ++i) {
			for (int j = i + 1; j <= l; ++j) {
				n1 = Long.parseLong(num.substring(0, i));
				n2 = Long.parseLong(num.substring(i, j));
				int k = j;
				while (true) {
					n3 = n1 + n2;
					String s3 = String.valueOf(n3);
					int end = k + s3.length();
					if (end > l)
						break;
					else if (num.substring(k, end).equals(s3)) {
						if (end == l)
							return true;
						n1 = n2;
						n2 = n3;
						k = end;
					} else
						break;
				}
				if(num.charAt(i) == '0')
					break;
			}
			if(num.startsWith("0"))
				return false;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Integer.MAX_VALUE);
		String s1 = "1023";
		AdditiveNumber an = new AdditiveNumber();
		System.out.println(an.isAdditiveNumber(s1));
	}

}
