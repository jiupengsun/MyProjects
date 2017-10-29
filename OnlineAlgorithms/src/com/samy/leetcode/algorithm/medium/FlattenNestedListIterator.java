package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class FlattenNestedListIterator {}

class NestedIterator implements Iterator<Integer> {

  Deque<Iterator<NestedInteger>> stack;
  Iterator<NestedInteger> iter;
  Integer current;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new LinkedList<>();
    iter = nestedList.iterator();
  }

  @Override
  public Integer next() {
    Integer n = current;
    current = null;
    return n;
  }

  @Override
  public boolean hasNext() {
    while(current == null) {
      if(iter.hasNext()) {
        NestedInteger n = iter.next();
        if(n.isInteger())
          current = n.getInteger();
        else {
          stack.push(iter);
          iter = n.getList().iterator();
        }
      } else if(!stack.isEmpty()){
        iter = stack.pop();
      } else
        break;
    }

    return current != null;
  }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation */
interface NestedInteger {

  // @return true if this NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this NestedInteger holds, if it holds a single integer
  // Return null if this NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this NestedInteger holds, if it holds a nested list
  // Return null if this NestedInteger holds a single integer
  public List<NestedInteger> getList();
}
