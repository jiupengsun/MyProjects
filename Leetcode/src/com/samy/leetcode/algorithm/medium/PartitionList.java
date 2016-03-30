package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class PartitionList {

	/**
	 * 
	 * @param head
	 * @param x
	 * @return
	 * 2016Äê3ÔÂ30ÈÕ
	 * @author Jiupeng
	 * @description 166 test cases, 1ms beats 4.36%
	 * @reference https://leetcode.com/problems/partition-list/
	 * @interpretation
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode fakeLess = new ListNode(x - 1);
		ListNode fakeLarger = new ListNode(x);
		ListNode fakeLessHead = fakeLess, fakeLargerHead = fakeLarger;
		while (head != null) {
			if (head.val < x) {
				fakeLess.next = head;
				fakeLess = fakeLess.next;
			} else {
				fakeLarger.next = head;
				fakeLarger = fakeLarger.next;
			}
			head = head.next;
		}
		fakeLarger.next = null;
		fakeLess.next = fakeLargerHead.next;
		return fakeLessHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
