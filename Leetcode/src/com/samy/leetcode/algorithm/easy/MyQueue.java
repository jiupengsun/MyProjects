package com.samy.leetcode.algorithm.easy;

public class MyQueue {
	/**
	 * 
	 * @param x
	 * 2016Äê1ÔÂ14ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/implement-queue-using-stacks/
	 */

	/***
	 * simulate the stack
	 */
	private int[] Stack = new int[65535];
	private int top_Point = 0;

	//Push element x to the back of queue.
	public void push(int x) {
		// add the judgement, then it's slow
		// remove it, then much faster
		if (top_Point < Stack.length)
			Stack[top_Point++] = x;
	}

	// Removes the element from in front of queue.
	public void pop() {
		for (int i = 0; i < top_Point; ++i) {
			Stack[i] = Stack[i + 1];
		}
		--top_Point;
	}

	// Get the front element.
	public int peek() {
		return Stack[0];
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return top_Point == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
