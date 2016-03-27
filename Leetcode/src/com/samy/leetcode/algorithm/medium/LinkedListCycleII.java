package com.samy.leetcode.algorithm.medium;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycleII {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年3月26日
	 * @author Jiupeng
	 * @description 16 test cases, 2ms beats 7.81%
	 * @reference https://leetcode.com/problems/linked-list-cycle-ii/
	 * @interpretation
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode tortoise = head, hare = head;
		while (hare != null && hare.next != null) {
			hare = hare.next.next;
			tortoise = tortoise.next;
			if (hare == tortoise) {
				//intersection
				ListNode tail = hare, newHead = tail.next;
				tail.next = null;
				ListNode inter = intersection(head, newHead);
				tail.next = newHead;
				return inter;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param h1
	 * @param h2
	 * @return
	 * 2016年3月26日
	 * @author Jiupeng
	 * @description return the intersection of two nodes
	 * @reference 
	 * @interpretation
	 */
	private ListNode intersection(ListNode h1, ListNode h2) {
		int l1 = 0, l2 = 0;
		ListNode n1 = h1, n2 = h2;
		while (n1 != null) {
			++l1;
			n1 = n1.next;
		}
		while (n2 != null) {
			++l2;
			n2 = n2.next;
		}
		n1 = h1;
		n2 = h2;
		int i = l1 - l2;
		while (i > 0) {
			n1 = n1.next;
			--i;
		}
		while (i < 0) {
			n2 = n2.next;
			++i;
		}
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年3月26日
	 * @author Jiupeng
	 * @description 16 test cases, 1ms beats 18.88%
	 * Based on the Floyd's Cycle finding algorithm, and optimized it
	 * @reference http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
	 * @interpretation
	 */
	public ListNode detectCycleSample(ListNode head) {
		ListNode tortoise = head, hare = head;
		while (hare != null && hare.next != null) {
			hare = hare.next.next;
			tortoise = tortoise.next;
			if (hare == tortoise) {
				//meet
				tortoise = head;
				while (tortoise != hare) {
					tortoise = tortoise.next;
					hare = hare.next;
				}
				return hare;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
