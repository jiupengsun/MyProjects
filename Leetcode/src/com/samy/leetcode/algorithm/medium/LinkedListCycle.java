package com.samy.leetcode.algorithm.medium;

public class LinkedListCycle {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description 16 test cases, 1ms beats 8.09%
	 * @reference https://leetcode.com/problems/linked-list-cycle/
	 * @interpretation Using the Hare and the Tortoise Algorithm. This algorithm is extremely popular
	 * in the list problems
	 */
	public boolean hasCycle(ListNode head) {
		ListNode tortoise = head, hare = head;
		while (tortoise != null && hare != null && hare.next != null
				&& hare.next != tortoise) {
			tortoise = tortoise.next;
			hare = hare.next.next;
			if (hare == tortoise)
				return true;
		}
		return (hare == null || hare.next == null) ? false : true;
	}

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年2月19日
	 * @author Jiupeng
	 * @description By reversing the list, the pointer will finally go back to head if exists a circle, otherwise
	 * reach tail. Another solution but will break the structre
	 * @reference 
	 * @interpretation https://leetcode.com/discuss/81318/java-1ms-reversing-list
	 */
	public boolean hasCycleAnotherSolution(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if (prev == head && head != null && head.next != null) //if we reach first node again, there is a cycle
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	static ListNode constructListSample(int l) {
		if (l < 1)
			return null;
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 1; i < l; ++i) {
			ListNode next = new ListNode(i);
			p.next = next;
			p = next;
		}
		return head;
	}

	static ListNode constructListSampleFromArray(int[] n) {
		ListNode head = null;
		if (n.length > 0) {
			head = new ListNode(n[0]);
			ListNode current = head;
			for (int i = 1; i < n.length; ++i) {
				ListNode next = new ListNode(n[i]);
				current.next = next;
				current = current.next;
			}
		}
		return head;
	}

	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}