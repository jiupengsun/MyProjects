package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortList {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年4月29日
	 * @author Jiupeng
	 * @description Correct but TLE
	 * @reference https://leetcode.com/problems/sort-list/
	 * @interpretation
	 */
	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		ListNode fakeH = head.next;
		head.next = null;
		ListNode less = new ListNode(-1);
		ListNode larger = new ListNode(-1);
		ListNode lessT = less, largerT = larger;
		while (fakeH != null) {
			if (fakeH.val >= head.val) {
				largerT.next = fakeH;
				largerT = largerT.next;
			} else {
				lessT.next = fakeH;
				lessT = lessT.next;
			}
			fakeH = fakeH.next;
		}
		lessT.next = null;
		largerT.next = null;
		ListNode left = sortList(less.next);
		head.next = sortList(larger.next);
		if (left == null)
			return head;
		fakeH = left;
		while (left.next != null)
			left = left.next;
		left.next = head;
		return fakeH;
	}

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年4月29日
	 * @author Jiupeng
	 * @description 15 test cases, 13ms beats 9.95%
	 * @reference 
	 * @interpretation
	 */
	public ListNode sortList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode n1 = head, n2 = head.next;
		ListNode i = n1, j = n2;
		head = head.next.next;
		while (head != null && head.next != null) {
			i.next = head;
			i = i.next;
			j.next = head.next;
			j = j.next;
			head = head.next.next;
		}
		i.next = null;
		n1 = sortList2(n1);
		n2 = sortList2(n2);
		head = new ListNode(0);
		ListNode tmp = head;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				tmp.next = n1;
				n1 = n1.next;
			} else {
				tmp.next = n2;
				n2 = n2.next;
			}
			tmp = tmp.next;
		}
		if (n1 != null)
			tmp.next = n1;
		if (n2 != null)
			tmp.next = n2;
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
