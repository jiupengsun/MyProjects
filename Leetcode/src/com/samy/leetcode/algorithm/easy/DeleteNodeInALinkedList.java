package com.samy.leetcode.algorithm.easy;

public class DeleteNodeInALinkedList {

	/**
	 * 
	 * @param node
	 * 2016Äê1ÔÂ11ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/delete-node-in-a-linked-list/
	 */
	public static void deleteNode(ListNode node) {
		if (node.next != null) {
			node.val = node.next.val;
			node.next = node.next.next;
		}
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