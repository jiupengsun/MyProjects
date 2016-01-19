package com.samy.leetcode.algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveLinkedListElements {

	/**
	 * 
	 * @param head
	 * @param val
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description 63 test cases, 1ms beats 86.71%
	 * @reference https://leetcode.com/problems/remove-linked-list-elements/
	 */
	public ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val)
			head = head.next;
		if (head == null || head.next == null)
			return head;
		ListNode current = head, next = current.next;
		while (next != null) {
			if (next.val == val) {
				current.next = next.next;
			} else {
				current = current.next;
			}
			next = next.next;
		}
		return head;
	}

	/**
	 * 
	 * @param head
	 * @param val
	 * @return
	 * 2016年1月19日
	 * @author Jiupeng
	 * @description using only one point
	 * @reference https://leetcode.com/discuss/70221/java-solution-without-fake-head
	 */
	public ListNode removeElements2(ListNode head, int val) {
		while (head != null && head.val == val)
			head = head.next;
		if (head == null)
			return null;
		ListNode walk = head;
		while (walk.next != null) {
			if (walk.next.val == val)
				walk.next = walk.next.next;
			else
				walk = walk.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
