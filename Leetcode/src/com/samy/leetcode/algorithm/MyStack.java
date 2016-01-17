package com.samy.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

	private Queue<Integer> myQueue = new LinkedList<Integer>();

	/**
	 * 
	 * @param x
	 * 2016Äê1ÔÂ17ÈÕ
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/implement-stack-using-queues/
	 */
	//Push element x onto stack.
	public void push(int x) {
		myQueue.add(x);
		int size = myQueue.size();
		for (int i = 0; i < size - 1; ++i) {
			myQueue.add(myQueue.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		myQueue.remove();
	}

	// Get the top element.
	public int top() {
		return myQueue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return myQueue.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
