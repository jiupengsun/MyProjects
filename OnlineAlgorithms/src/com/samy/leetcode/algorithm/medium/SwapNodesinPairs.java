package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesinPairs {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê2ÔÂ23ÈÕ
	 * @author Jiupeng
	 * @description 55 test cases, 0ms beats 13.63%
	 * @reference https://leetcode.com/problems/swap-nodes-in-pairs/
	 * @interpretation
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head, second = head.next, prev = first;
		head = head.next;
		first.next = second.next;
		second.next = first;
		first = first.next;
		while (first != null && first.next != null) {
			second = first.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			prev = first;
			first = first.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
