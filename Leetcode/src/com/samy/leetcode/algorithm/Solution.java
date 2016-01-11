package com.samy.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 * @description Find two numbers in an array, which could be added up to a
	 *              specific target number
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]) + 1;
				result[1] = i + 1;
				return result;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;
	}

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 * @description Add up the numbers from two links
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode l = l2;
		int carry = 0;
		int sum = 0;
		while (true) {
			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			l2.val = sum % 10;
			if (l1.next == null && l2.next == null) {
				if (carry > 0)
					l2.next = new ListNode(carry);
				break;
			}
			if (l1.next == null)
				l1.next = new ListNode(0);
			if (l2.next == null)
				l2.next = new ListNode(0);
			l1 = l1.next;
			l2 = l2.next;
		}
		return l;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @description Longest Substring Without Repeating Characters
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0, i = 0, j = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		while (j < s.length()) {
			String st = s.substring(j, j + 1);
			if (map.containsKey(st) && map.get(st) >= i)
				i = map.get(st) + 1;
			map.put(st, j++);
			max = max > (j - i) ? max : (j - i);
		}
		return max;
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @description Use 256array to replace hashmap; Replace substring to charAt
	 */
	public int lengthOfLongestSubstring2(String s) {
		int max = 0, i = 1, j = 1;
		int[] chars = new int[256];
		while (j <= s.length()) {
			char c = s.charAt(j - 1);
			if (chars[c] >= i) {
				i = chars[c] + 1;
				if (s.length() - i < max)
					return max;
			}
			chars[c] = j++;
			max = max > (j - i) ? max : (j - i);
		}
		return max;
	}

	/**
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 * @description Find median in two sorted arrays -- regardless ascending or
	 *              descending
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
	 * @description Find median in two sorted arrays -- ascending default
	 *              algorithm complexity: O(m+n) construct a new ordered array
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
	 * 2016年1月11日
	 * @author Jiupeng
	 * @description Sample algorithm on leetcode
	 * @reference
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
	 * 2016年1月11日
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

	public static void println(Object s) {
		System.out.println(s.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] { 2, 3 };
		int[] nums2 = new int[] {};
		Solution S = new Solution();
		println(S.findMedianSortedArrays(nums1, nums2));
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
