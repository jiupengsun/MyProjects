package com.samy.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PalindromeLinkedList {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê1ÔÂ20ÈÕ
	 * @author Jiupeng
	 * @description too slow, only beats 11%. o(2n) time and o(n) space
	 * @reference https://leetcode.com/problems/palindrome-linked-list/
	 */
	public static boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		int l = 0;
		while (head != null) {
			list.add(head.val);
			++l;
			head = head.next;
		}
		Integer[] vals = new Integer[l];
		list.toArray(vals);
		for (int i = (l - 1) >> 1; i >= 0; --i) {
			if (vals[i] != vals[l - 1 - i].intValue())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] n = { -16557, -8725, -29125, 28873, -21702, 15483, -28441, -17845,
				-4317, -10914, -10914, -4317, -17845, -28441, 15483, -21702, 28873,
				-29125, -8725, -16557 };
		ListNode head = ListNode.constructListSampleFromArray(n);
		isPalindrome(head);
	}
}
