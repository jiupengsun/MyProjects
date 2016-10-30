package com.samy.leetcode.algorithm.easy;

public class CompareVersionNumbers {

	/**
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 * 2016Äê1ÔÂ26ÈÕ
	 * @author Jiupeng
	 * @description 71 test cases, 1ms beats 90.12%
	 * @reference https://leetcode.com/problems/compare-version-numbers/
	 */
	public int compareVersion(String version1, String version2) {
		int i = 0, j = 0, l1 = version1.length(), l2 = version2.length();
		for (int i1, j1; i < l1 && j < l2; i = i1 + 1, j = j1 + 1) {
			i1 = version1.indexOf('.', i);
			i1 = i1 == -1 ? l1 : i1;
			j1 = version2.indexOf('.', j);
			j1 = j1 == -1 ? l2 : j1;
			int d = Integer.parseInt(version1.substring(i, i1))
					- Integer.parseInt(version2.substring(j, j1));
			if (d != 0)
				return d > 0 ? 1 : -1;
		}
		for (char c; i < l1; ++i) {
			c = version1.charAt(i);
			if (c != '0' && c != '.')
				return 1;
		}
		for (char c; j < l2; ++j) {
			c = version2.charAt(j);
			if (c != '0' && c != '.')
				return -1;
		}
		return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		String version2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		System.out.println(cvn.compareVersion(version1, version2));
	}

}
