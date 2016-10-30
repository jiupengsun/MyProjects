package com.samy.leetcode.algorithm.medium;

public class AddTwoNumbers {

	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 * 2016Äê1ÔÂ18ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/add-two-numbers/
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode l = l2;
		int carry = 0;
		int sum = 0;
		while (true) {
			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			l2.val = sum % 10;
			if (l1.next == null && l2.next == null) {
				if (carry > 0)
					l2.next = new ListNode(carry);
				break;
			}
			if (l1.next == null)
				l1.next = new ListNode(0);
			if (l2.next == null)
				l2.next = new ListNode(0);
			l1 = l1.next;
			l2 = l2.next;
		}
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
