package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class H_Index {

	/**
	 * 
	 * @param citations
	 * @return
	 * 2016年3月24日
	 * @author Jiupeng
	 * @description 81 test cases, 4ms beats 9.28%
	 * @reference https://leetcode.com/problems/h-index/
	 * @interpretation
	 */
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int l = citations.length, i = l - 1;
		while (i >= 0 && citations[i] >= l - i)
			--i;
		return l - i - 1;
	}

	/**
	 * 
	 * @param citations
	 * @return
	 * 2016年3月24日
	 * @author Jiupeng
	 * @description 81 test cases, 1ms beats 61.18%
	 * @reference 
	 * @interpretation
	 */
	public int hIndex2(int[] citations) {
		int l = citations.length;
		int[] index = new int[l];
		for (int c : citations) {
			if (c > 0) {
				c = c > l ? l - 1 : c - 1;
				index[c]++;
			}
		}
		for (int i = l - 1, sum = 0; i >= 0; --i) {
			if ((sum += index[i]) >= (i + 1))
				return i + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = { 5, 5, 5, 5, 5 };
		H_Index hi = new H_Index();
		System.out.println(hi.hIndex2(citations));
	}

}
