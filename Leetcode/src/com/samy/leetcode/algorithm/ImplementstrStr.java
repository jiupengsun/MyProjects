package com.samy.leetcode.algorithm;

public class ImplementstrStr {

	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 * 2016年1月22日
	 * @author Jiupeng
	 * @description KMP algorithm, 72 test cases, 7ms beats 31.17%
	 * @reference https://leetcode.com/problems/implement-strstr/
	 */
	public int strStr(String haystack, String needle) {
		int hl = haystack.length(), nl = needle.length();
		if (hl < nl)
			return -1;
		if (nl == 0)
			return 0;
		int m = 0, i = 0;
		int[] T = new int[nl];
		kmpTable(needle, T);
		while (m + i < hl) {
			if (needle.charAt(i) == haystack.charAt(m + i)) {
				if (i == nl - 1)
					return m;
				++i;
			} else {
				if (i > 0) {
					m = m + i - T[i];
					i = T[i];
				} else {
					i = 0;
					++m;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param needle
	 * @param table
	 * @return
	 * 2016年1月22日
	 * @author Jiupeng
	 * @description construct the KMP Table
	 * @reference https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
	 */
	private void kmpTable(String w, int[] table) {
		int l = w.length();
		int pos = 2, cnd = 0;
		while (pos < l) {
			if (w.charAt(pos - 1) == w.charAt(cnd)) {
				table[pos] = cnd + 1;
				++cnd;
				++pos;
			} else if (cnd > 0)
				cnd = table[cnd];
			else {
				table[pos] = 0;
				++pos;
			}
		}
	}

	/**
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 * 2016年1月23日
	 * @author Jiupeng
	 * @description JDK v8 indexOf method
	 * @reference
	 */
	public int strStr2(String haystack, String needle) {
		int hl = haystack.length(), nl = needle.length();
		if (hl < nl)
			return -1;
		if (nl == 0)
			return 0;
		for (int i = 0, j, max = hl - nl; i <= max; ++i) {
			while (i <= max && haystack.charAt(i) != needle.charAt(0))
				++i;
			if (i <= max) {
				for (j = 1; j < nl; ++j)
					if (haystack.charAt(i + j) != needle.charAt(j))
						break;
				if (j == nl)
					return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementstrStr is = new ImplementstrStr();
		String s = "mississippi";
		String w = "a";
		System.out.println(is.strStr2(s, w));
	}

}
