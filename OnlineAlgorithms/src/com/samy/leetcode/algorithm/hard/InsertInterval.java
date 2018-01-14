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

  /**
   * using binary search firstly
   * @param intervals
   * @param newInterval
   * @return
   */
  public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
    // binary search
    int i=0, j=intervals.size()-1, mid=i;
    while(i <= j) {
      mid = ((j - i) >> 1) + i;
      int end = intervals.get(mid).end;
      if(end == newInterval.start)
        break;
      else if(end < newInterval.start)
        i = mid + 1;
      else
        j = mid - 1;
    }
    mid = Math.max(mid-1, 0);
    for(j=mid; j<intervals.size(); ++j) {
      Interval in = intervals.get(j);
      if(in.end < newInterval.start)
        continue;
      if(in.start > newInterval.end)
        break;
      intervals.remove(j);
      newInterval.start = Math.min(in.start, newInterval.start);
      newInterval.end = Math.max(in.end, newInterval.end);
      --j;
    }
    intervals.add(j, newInterval);
    return intervals;
  }

  public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
    int st = findStart(intervals, newInterval);
    int en = findEnd(intervals, newInterval);
    if(en < 0) {
      intervals.add(0, newInterval);
    } else if(st == intervals.size()) {
      intervals.add(newInterval);
    } else {
      if(st <= en) {
        newInterval.start = Math.min(newInterval.start, intervals.get(st).start);
        newInterval.end = Math.max(newInterval.end, intervals.get(en).end);
        for(int i=st; i<=en; ++i) {
          intervals.remove(st);
        }
      }
      intervals.add(st, newInterval);
    }
    return intervals;
  }

  private int findStart(List<Interval> intervals, Interval newInterval) {
    int i=0, j=intervals.size()-1, mid=0;
    while(i <= j) {
      mid = ((j - i) >> 1) + i;
      Interval in = intervals.get(mid);
      if(in.end > newInterval.start)
        j = mid - 1;
      else if(in.end < newInterval.start)
        i = mid + 1;
      else
        return mid;
    }
    return i;
  }

  private int findEnd(List<Interval> intervals, Interval newInterval) {
    int i=0, j=intervals.size()-1, mid=0;
    while(i <= j) {
      mid = ((j - i) >> 1) + i;
      Interval in = intervals.get(mid);
      if(in.start > newInterval.end)
        j = mid - 1;
      else if(in.start < newInterval.end)
        i = mid + 1;
      else
        return mid;
    }
    return j;
  }
}
