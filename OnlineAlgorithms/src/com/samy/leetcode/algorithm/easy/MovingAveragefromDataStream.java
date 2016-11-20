package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * Created by samy on 11/19/16.
 */
public class MovingAveragefromDataStream {}

class MovingAverage {
  private int[] window;
  private int current = 0;
  private int current_size = 0;
  private int sum = 0;
  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    window = new int[size];
  }

  public double next(int val) {
    sum -= window[current];
    window[current] = val;
    sum += val;
    if( current_size < window.length)
      ++current_size;
    current = (++current) % window.length;
    return (double)sum / current_size;
  }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */