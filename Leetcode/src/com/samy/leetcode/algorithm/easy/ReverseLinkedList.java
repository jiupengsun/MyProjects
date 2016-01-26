package com.samy.leetcode.algorithm.easy;

public class ReverseLinkedList {

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê1ÔÂ13ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/reverse-linked-list/
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		ListNode newHead = reverseList(next);
		next.next = head;
		head.next = null;
		return newHead;
	}

	public static ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		head.next = null;
		while (next.next != null) {
			ListNode nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
		}
		next.next = head;
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.constructListSample(5);
		ListNode.printList(head);
		head = reverseList2(head);
		ListNode.printList(head);
	}

}
