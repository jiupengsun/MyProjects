package com.samy.leetcode.algorithm.medium;

import java.util.Iterator;

/**
 * 
 * @author sam
 * @reference https://leetcode.com/problems/peeking-iterator/
 * @description 12 test cases, 104ms beats 88.33%
 */
public class PeekingIterator<T> implements Iterator<T> {

	private Iterator<T> iterator = null;
	private T peekElement;

	public PeekingIterator(Iterator<T> iterator) {
		// initialize any member here.
		this.iterator = iterator;
		peekElement = iterator.hasNext() ? iterator.next() : null;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public T peek() {
		return peekElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public T next() {
		T now = peekElement;
		peekElement = iterator.hasNext() ? iterator.next() : null;
		return now;
	}

	@Override
	public boolean hasNext() {
		return peekElement != null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
