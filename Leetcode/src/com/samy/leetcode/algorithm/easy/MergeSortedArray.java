package com.samy.leetcode.algorithm.easy;

public class MergeSortedArray {

	/**
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/merge-sorted-array/
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = (m--) + (n--) - 1;
		for (; m >= 0 && n >= 0;) {
			if (nums1[m] >= nums2[n])
				nums1[i--] = nums1[m--];
			else
				nums1[i--] = nums2[n--];
		}
		while (n >= 0)
			nums1[i--] = nums2[n--];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
