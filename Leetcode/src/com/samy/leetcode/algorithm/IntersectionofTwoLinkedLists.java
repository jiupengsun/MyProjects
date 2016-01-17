package com.samy.leetcode.algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionofTwoLinkedLists {

	/**
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/intersection-of-two-linked-lists/
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode n1 = headA, n2 = headB;
		int l1 = 1, l2 = 1;
		while (n1.next != null) {
			++l1;
			n1 = n1.next;
		}
		while (n2.next != null) {
			++l2;
			n2 = n2.next;
		}
		n1 = headA;
		n2 = headB;
		int i = l1 - l2;
		if (i > 0) {
			while ((i--) > 0)
				n1 = n1.next;
		} else if (i < 0) {
			while ((i++) < 0)
				n2 = n2.next;
		}
		while (n1 != null && n2 != null) {
			if (n1 == n2)
				return n1;
			n1 = n1.next;
			n2 = n2.next;
		}
		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
