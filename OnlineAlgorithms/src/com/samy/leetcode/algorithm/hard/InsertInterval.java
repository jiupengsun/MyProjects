package com.samy.leetcode.algorithm.hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for an interval.
 */

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
  /**
   * https://leetcode.com/problems/insert-interval/description/
   * @param intervals
   * @param newInterval
   * @return
   */
  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> list = new LinkedList<>();
    boolean state = false;
    int start = newInterval.start, end = newInterval.end;
    for(Interval in : intervals) {
      if(in.end < start || in.start > end) {
        // no intersection
        if(!state && in.start > end) {
          // should insert new interval
          list.add(new Interval(start, end));
          state = true;
        }
        list.add(in);
      } else {
        // has intersection
        start = Math.min(in.start, start);
        end = Math.max(in.end, end);
      }
    }
    if(intervals.size()==0 || !state)
      list.add(new Interval(start, end));
    return list;
  }
}
