package com.samy.leetcode.algorithm.easy;

public class Palindromic {

	/**
	 * 
	 * @param s
	 * @return 2016Äê1ÔÂ3ÈÕ
	 * @author Jiupeng
	 * @description Finding the longest palindrome string in the string S using
	 *              Manacher algorithm:
	 *              https://en.wikipedia.org/wiki/Longest_palindromic_substring
	 */
	public String longestPalindrome(String s) {
		int i = 0, max = 0, pos = 0;
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
			while (i - r >= 0 && i + r < sb.length() && sb.charAt(i - r) == sb.charAt(i + r)) {
				r++;
			}

			// update the max_right and max_center
			if (i + r - 1 > max_right) {
				max_right = i + r - 1;
				max_center = i;
			}

			// record the position which has the max length of radius
			rad[i] = r;
			if (r - 1 > max) {
				max = r - 1;
				pos = i;
			}
		}

		return max % 2 == 0 ? s.substring((pos - 1) / 2 - max / 2 + 1, (pos + 1) / 2 + max / 2)
				: s.substring((pos - 1) / 2 - (max - 1) / 2, (pos - 1) / 2 + (max + 1) / 2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palindromic p = new Palindromic();
		String[] ss = new String[6];
		ss[0] = "bb";
		ss[1] = "abcba";
		ss[2] = "avserfresok";
		ss[3] = "aaaaaaaaaaaaa";
		ss[4] = "abcvbnbvc";
		ss[5] = "qwerewqty";
		for (String s : ss) {
			System.out.println(s + ", the max palindromic string is: " + p.longestPalindrome(s));
		}
	}

}
