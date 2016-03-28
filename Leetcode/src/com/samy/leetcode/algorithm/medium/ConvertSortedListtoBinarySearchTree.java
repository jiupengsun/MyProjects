package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConvertSortedListtoBinarySearchTree {

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年3月28日
	 * @author Jiupeng
	 * @description 32 test cases, 3ms beats 2.62%
	 * @reference https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
	 * @interpretation
	 */
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		Integer[] node = new Integer[list.size()];
		list.toArray(node);
		return helper(node, 0, node.length - 1);
	}

	private TreeNode helper(Integer[] node, int st, int en) {
		if (st > en)
			return null;
		int mid = (st + en) >> 1;
		TreeNode root = new TreeNode(node[mid]);
		TreeNode left = helper(node, st, mid - 1);
		TreeNode right = helper(node, mid + 1, en);
		root.left = left;
		root.right = right;
		return root;
	}

	/**
	 * 
	 * @param head
	 * @return
	 * 2016年3月28日
	 * @author Jiupeng
	 * @description
	 * @reference 32 test cases, 1ms beats 40.13%
	 * @interpretation
	 */
	public TreeNode sortedListToBST2(ListNode head) {
		return helper(head, null);
	}

	private TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail)
			return null;
		ListNode tortoise = head, hare = head;
		while (hare != tail && hare.next != tail) {
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		TreeNode root = new TreeNode(tortoise.val);
		root.left = helper(head, tortoise);
		root.right = helper(tortoise.next, tail);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
