package com.samy.leetcode.algorithm.medium;

public class H_IndexII {

	/**
	 * 
	 * @param citations
	 * @return
	 * 2016Äê3ÔÂ24ÈÕ
	 * @author Jiupeng
	 * @description 82 test cases, 10ms beats 96.36%
	 * @reference https://leetcode.com/problems/h-index-ii/
	 * @interpretation
	 */
	public int hIndex(int[] citations) {
		int l = citations.length;
		int i = 0, j = l - 1, mid;
		while (i <= j) {
			mid = (i + j) >> 1;
			int c = l - mid;
			if (citations[mid] > c)
				j = mid - 1;
			else if (citations[mid] < c)
				i = mid + 1;
			else
				return c;
		}
		return l - i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 0 };
		H_IndexII hi = new H_IndexII();
		hi.hIndex(citations);
	}

}
