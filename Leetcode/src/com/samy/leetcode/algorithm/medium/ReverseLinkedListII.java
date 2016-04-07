package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedListII {

	/**
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 * Apr 7, 2016
	 * @author Jiupeng
	 * @description 44 test cases, 0ms beats 13.22%
	 * @reference https://leetcode.com/problems/reverse-linked-list-ii/
	 * @interpretation
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode last = fakeHead, now = head;
		int i = 1;
		while (i < m) {
			now = now.next;
			last = last.next;
			++i;
		}
		ListNode pre = now, next = now.next;
		while (i < n) {
			ListNode tmp = next.next;
			next.next = pre;
			pre = next;
			next = tmp;
			++i;
		}
		last.next = pre;
		now.next = next;
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
