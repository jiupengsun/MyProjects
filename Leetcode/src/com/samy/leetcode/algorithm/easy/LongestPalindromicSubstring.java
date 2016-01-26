package com.samy.leetcode.algorithm.easy;

public class LongestPalindromicSubstring {

	/**
	 * 
	 * @param s
	 * @return
	 * 2016Äê1ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description Using Manacher algorithm
	 * @reference https://leetcode.com/problems/longest-palindromic-substring/
	 */
	public String longestPalindrome(String s) {
		int i = 0;
		// insert # to the string
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < s.length(); i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");

		// define the rightest position
		int max_right = -1;
		// define the position with max radius
		int max_center = -1;
		// define the radius array
		int[] rad = new int[sb.length()];

		for (i = 0; i < sb.length(); i++) {
			// temp radius
			int r = 1;
			// I. rad[i]-k<rad[i-k]
			// II. rad[i]-k>rad[i-k]
			// III. rad[i]-k=rad[i-k]
			// id would never be larger than i
			if (i <= max_right) {
				r = Math.min(rad[max_center] - i + max_center, rad[2 * max_center - i]);
			}

			// try the bigger radius
			while (i - r >= 0 && i + r < sb.length()
					&& sb.charAt(i - r) == sb.charAt(i + r)) {
				r++;
			}

			// update the max_right and max_center
			if (i + r - 1 > max_right) {
				max_right = i + r - 1;
				max_center = i;
			}
			rad[i] = r;
		}

		// scan the radius array and get the max length of palindromic
		// rad[i]-1 = the max length of origin string array
		// judge whether rad[pos] is "#"
		int length = rad.length;
		int max = 0, pos = 0;
		for (i = 0; i < length; i++) {
			if (rad[i] - 1 > max) {
				max = rad[i] - 1;
				pos = i;
			}
		}

		return max % 2 == 0
				? s.substring((pos - 1) / 2 - max / 2 + 1, (pos + 1) / 2 + max / 2)
				: s.substring((pos - 1) / 2 - (max - 1) / 2,
						(pos - 1) / 2 + (max + 1) / 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
