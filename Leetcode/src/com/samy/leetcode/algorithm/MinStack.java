package com.samy.leetcode.algorithm;

/**
 * 
 * @author sam
 * @description accepted, beats 89.97%. o(2n) space and o(1) time complexity
 * @reference https://leetcode.com/problems/min-stack/
 */
public class MinStack {

	private int[] stack = new int[20000];
	private int point = -1;
	private int[] minStack = new int[20000];

	public void push(int x) {
		++point;
		stack[point] = x;
		if (point == 0) {
			minStack[0] = 0;
		} else {
			if (x > stack[minStack[point - 1]])
				minStack[point] = minStack[point - 1];
			else
				minStack[point] = point;
		}
	}

	public void pop() {
		--point;
	}

	public int top() {
		return stack[point];
	}

	public int getMin() {
		return stack[minStack[point]];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		System.out.println(min - 1);
	}

}

class MinStack2 {

	public void push(int x) {
	}

	public void pop() {
	}

	public int top() {
		return 0;
	}

	public int getMin() {
		return 0;
	}
}
