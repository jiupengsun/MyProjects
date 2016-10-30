package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortList {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê3ÔÂ29ÈÕ
	 * @author Jiupeng
	 * @description 21 test cases, 44ms beats 27.87%
	 * @reference https://leetcode.com/problems/insertion-sort-list/
	 * @interpretation
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null)
			return null;
		ListNode last = head, next = last.next;
		while (next != null) {
			if (next.val < head.val) {
				last.next = next.next;
				next.next = head;
				head = next;
				next = last.next;
			} else {
				ListNode n = head;
				while (n.next != next && n.next.val < next.val)
					n = n.next;
				if (n.next != next) {
					last.next = next.next;
					next.next = n.next;
					n.next = next;
					next = last.next;
				} else {
					last = last.next;
					next = next.next;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
