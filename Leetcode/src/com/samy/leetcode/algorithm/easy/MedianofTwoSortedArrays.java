package com.samy.leetcode.algorithm.easy;

public class MedianofTwoSortedArrays {

	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/median-of-two-sorted-arrays/
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[(nums1.length + nums2.length) / 2 + 1];
		boolean order1 = (nums1.length <= 1) || (nums1[1] > nums1[0]);
		boolean order2 = (nums2.length <= 1) || (nums2[1] > nums2[0]);
		int i, m, n;
		for (i = 0, m = 0, n = 0; i < nums.length && m < nums1.length
				&& n < nums2.length; i++) {
			nums[i] = nums1[order1 ? m : nums1.length - 1 - m] < nums2[order2 ? n
					: nums2.length - 1 - n]
							? nums1[order1 ? m++ : nums1.length - 1 - (m++)]
							: nums2[order2 ? n++ : nums2.length - 1 - (n++)];
		}
		if (i < nums.length) {
			if (m == nums1.length)
				while (i < nums.length) {
					nums[i++] = nums2[order2 ? n++ : nums2.length - 1 - (n++)];
				}
			else if (n == nums2.length)
				while (i < nums.length) {
					nums[i++] = nums1[order1 ? m++ : nums1.length - 1 - (m++)];
				}
		}
		return (nums1.length + nums2.length) % 2 == 0
				? (double) (nums[i - 1] + nums[i - 2]) / 2 : nums[i - 1];
	}

	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Find median in two sorted arrays -- ascending default
	 *              algorithm complexity: O(m+n) construct a new ordered array
	 * @reference
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int[] nums = new int[(nums1.length + nums2.length) / 2 + 1];
		int i, m, n;
		for (i = 0, m = 0, n = 0; i < nums.length && m < nums1.length
				&& n < nums2.length; i++) {
			nums[i] = nums1[m] < nums2[n] ? nums1[m++] : nums2[n++];
		}
		if (i < nums.length) {
			if (m == nums1.length)
				while (i < nums.length) {
					nums[i++] = nums2[n++];
				}
			else if (n == nums2.length)
				while (i < nums.length) {
					nums[i++] = nums1[m++];
				}
		}
		return (nums1.length + nums2.length) % 2 == 0
				? (double) (nums[i - 1] + nums[i - 2]) / 2 : nums[i - 1];
	}

	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description
	 * @reference Sample algorithm on leetcode
	 */
	public double findMedianSortedArray_Sample(int[] A, int[] B) {
		int m = A.length, n = B.length;
		// if m+n is even, then l + 1 = r
		// if m+n is odd, then l=r
		int l = (m + n + 1) / 2;
		int r = (m + n + 2) / 2;
		return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

	/**
	 * 
	 * @param A
	 * @param aStart
	 * @param B
	 * @param bStart
	 * @param k
	 * @return
	 * 2016年1月18日
	 * @author Jiupeng
	 * @description Get the median of A and B
	 * @reference
	 */
	private double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1)
			return B[bStart + k - 1];
		if (bStart > B.length - 1)
			return A[aStart + k - 1];
		if (k == 1)
			return Math.min(A[aStart], B[bStart]);

		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k / 2 - 1 < A.length)
			aMid = A[aStart + k / 2 - 1];
		if (bStart + k / 2 - 1 < B.length)
			bMid = B[bStart + k / 2 - 1];

		if (aMid < bMid)
			return getkth(A, aStart + k / 2, B, bStart, k - k / 2);// Check: aRight + bLeft 
		else
			return getkth(A, aStart, B, bStart + k / 2, k - k / 2);// Check: bRight + aLeft
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
