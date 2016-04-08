package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesfromSortedListII {

	/**
	 * 
	 * @param head
	 * @return
	 * Apr 9, 2016
	 * @author Jiupeng
	 * @description 166 test cases, 1ms beats 25.85%
	 * @reference https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
	 * @interpretation
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode pre = fakeHead, now = head;
		int count = 0;
		while (now != null && now.next != null) {
			while (now.next != null && now.val == now.next.val) {
				now = now.next;
				++count;
			}
			now = now.next;
			if (count > 0)
				pre.next = now;
			else
				pre = pre.next;
			count = 0;
		}
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
