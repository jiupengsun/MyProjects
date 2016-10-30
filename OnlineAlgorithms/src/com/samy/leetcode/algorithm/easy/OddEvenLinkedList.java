package com.samy.leetcode.algorithm.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class OddEvenLinkedList {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/odd-even-linked-list/
	 */
	public static ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode even_head = head.next;
		ListNode odd = head, even = even_head;
		while (even != null && even.next != null) {
			odd.next = even.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;
		}
		odd.next = even_head;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ListNode head = ListNode.constructListSampleFromArray(n);
		ListNode.printList(head);
		oddEvenList(head);
		ListNode.printList(head);
	}

}
