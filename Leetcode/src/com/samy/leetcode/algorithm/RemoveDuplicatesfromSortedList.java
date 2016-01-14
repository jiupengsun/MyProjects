package com.samy.leetcode.algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesfromSortedList {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head, tmp;
		int i;
		while (current != null && current.next != null) {
			i = current.val;
			tmp = current.next;
			if (tmp.val == i) {
				current.next = tmp.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 5, 8, 3, 2, 3, 3, 1 };
		ListNode head = ListNode.constructListSampleFromArray(n);
		ListNode.printList(head);
		head = deleteDuplicates(head);
		ListNode.printList(head);
	}

}
