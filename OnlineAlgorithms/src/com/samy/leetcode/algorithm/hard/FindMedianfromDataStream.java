package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class FindMedianfromDataStream {}

class MedianFinder {
  PriorityQueue<Integer> left;
  PriorityQueue<Integer> right;

  /** initialize your data structure here. */
  public MedianFinder() {
    // left is max heap
    left = new PriorityQueue<>((x,y)->y-x);
    // right is min heap
    right = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if(left.isEmpty())
      left.add(num);
    else if(left.size() == right.size()) {
      if(num > left.peek()) {
        right.add(num);
        left.add(right.poll());
      } else
        left.add(num);
    } else {
      // left is larger
      left.add(num);
      right.add(left.poll());
    }
  }

  public double findMedian() {
    return left.size()==right.size() ? (left.peek()+right.peek())/2d : left.peek();
  }
}
