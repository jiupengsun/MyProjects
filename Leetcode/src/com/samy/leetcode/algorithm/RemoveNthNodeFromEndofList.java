package com.samy.leetcode.algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndofList {

	/**
	 * 
	 * @param head
	 * @param n
	 * @return
	 * 2016Äê1ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/remove-nth-node-from-end-of-list/
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head, tail = head;
		while ((n--) > 0) {
			tail = tail.next;
		}
		if (tail == null)
			return head.next;

		while (tail.next != null) {
			tail = tail.next;
			current = current.next;
		}

		current.next = current.next.next;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
