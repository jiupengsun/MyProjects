package com.samy.leetcode.algorithm.easy;

public class DeleteNodeInALinkedList {

	/**
	 * 
	 * @param node
	 * 2016��1��11��
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