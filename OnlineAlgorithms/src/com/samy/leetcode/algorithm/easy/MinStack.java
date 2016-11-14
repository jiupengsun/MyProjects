package com.samy.leetcode.algorithm.easy;

/**
 * 
 * @author sam
 * @description accepted, beats 89.97%. o(2n) space and o(1) time complexity
 * @reference https://leetcode.com/problems/min-stack/
 */
public class MinStack {

	private int initialCapacity = 50;
	private int[] stack;
	private int pointer;
	private int[] minStack;

	public MinStack() {
		stack = new int[initialCapacity];
		minStack = new int[initialCapacity];
		pointer = -1;
	}

	public MinStack(int size) {
		initialCapacity = size;
		new MinStack();
	}

	public void push(int x) {
		ensureCapacity();
		++pointer;
		stack[pointer] = x;
		if (pointer == 0) {
			minStack[0] = 0;
		} else {
			minStack[pointer] = x < stack[minStack[pointer-1]] ? pointer : minStack[pointer-1];
		}
	}

	public void pop() {
		if(pointer > -1)
			--pointer;
	}

	public int top() {
		return stack[pointer];
	}

	public int getMin() {
		return stack[minStack[pointer]];
	}

	private void ensureCapacity() {
		if(pointer == stack.length-1) {
			int old_size = stack.length;
			int new_size = old_size + (old_size>>1) + 1;
			int[] tmp_stack = new int[new_size];
			int[] tmp_minStack = new int[new_size];
			System.arraycopy(stack, 0, tmp_stack, 0, old_size);
			System.arraycopy(minStack, 0, tmp_minStack, 0, old_size);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;*/
		int m1 = Integer.MIN_VALUE + 5;
		int m2 = Integer.MIN_VALUE + 7;
		int m = m1 << 1 - m2;
		int n = m1 - m2 + m1;
		System.out.println(m + " " + n);
	}

}

/**
 * 
 * @author samparly
 * @description An interesting and tricky implementation, use %min% and a special number which is less than %min%
 * to calculate the last min value. So it's no need to relocate a new array. However, errors may happen when %min%
 * overflows
 * @reference http://stackoverflow.com/questions/685060/design-a-stack-such-that-getminimum-should-be-o1
 */
class MinStack2 {

	private int min;
	private int[] stack = new int[1024];
	private int point = -1;

	public void push(int x) {
		++point;
		if (point == 0) {
			stack[0] = x;
			min = x;
		} else if (x < min) {
			stack[point] = x - min + x;
			min = x;
		} else
			stack[point] = x;
	}

	public void pop() {
		int x = stack[point--];
		if (x < min) {
			min += min - x;
		}
	}

	public int top() {
		int x = stack[point];
		if (x < min) {
			int prevMin = min;
			min += min - x;
			return prevMin;
		}
		return x;
	}

	public int getMin() {
		return min;
	}
}
