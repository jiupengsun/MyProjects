package com.samy.leetcode.algorithm.easy;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
public class FirstBadVersion {

	private int first_bad = 1702766719;

	/**
	 * 
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ25ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/first-bad-version/
	 */
	public int firstBadVersion(int n) {
		int i = 1, j = n, mid = j >> 1;
		while (i < j) {
			if (isBadVersion(mid))
				j = mid;
			else
				i = mid + 1;
			mid = (i >> 1) + (j >> 1);
		}
		return i;
	}

	private boolean isBadVersion(int version) {
		if (version >= first_bad)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max_version = 2126753390;
		FirstBadVersion f = new FirstBadVersion();
		System.out.println(f.firstBadVersion(max_version));

	}

}
