package com.samy.leetcode.algorithm.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/merge-two-sorted-lists/
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head, current;
		if (l1 != null) {
			if (l2 == null)
				return l1;
			if (l1.val <= l2.val) {
				head = l1;
				l1 = l1.next;
			} else {
				head = l2;
				l2 = l2.next;
			}
		} else
			return l2;

		current = head;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null)
			current.next = l1;
		else
			current.next = l2;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n1 = { 1, 3, 5 };
		int[] n2 = { 1, 1, 7 };
		ListNode l1 = ListNode.constructListSampleFromArray(n1);
		ListNode l2 = ListNode.constructListSampleFromArray(n2);
		ListNode merge = mergeTwoLists(l1, l2);
		ListNode.printList(merge);
	}

}
