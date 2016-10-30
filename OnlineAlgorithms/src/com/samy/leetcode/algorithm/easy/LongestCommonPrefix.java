package com.samy.leetcode.algorithm.easy;

public class LongestCommonPrefix {

	/**
	 * 
	 * @param strs
	 * @return
	 * 2016年1月20日
	 * @author Jiupeng
	 * @description 171 test cases 4ms beats 49.82%
	 * @reference https://leetcode.com/problems/longest-common-prefix/
	 */
	public String longestCommonPrefix(String[] strs) {
		int l = strs.length;
		switch (l) {
		case 0:
			return "";
		case 1:
			return strs[0];
		default: {
			int i, j;
			for (j = 0; j < strs[0].length(); ++j) {
				for (i = 0; i < l - 1 && j < strs[i + 1].length(); ++i) {
					if (strs[i].charAt(j) != strs[i + 1].charAt(j))
						break;
				}
				if (i != l - 1)
					break;
			}
			return strs[0].substring(0, j);
		}
		}
	}

	/**
	 * 
	 * @param strs
	 * @return
	 * 2016年1月20日
	 * @author Jiupeng
	 * @description much faster, 1ms application
	 * @reference https://leetcode.com/discuss/78823/1ms-simple-clean-java-solution-o-n2
	 */
	public String longestCommonPrefixSample(String[] strs) {
		if (null == strs || strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}
		return prefix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "adaf";
		System.out.println(str.substring(0, 0));
	}

}
