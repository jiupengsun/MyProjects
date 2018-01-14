package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class MergeIntervals {

  /**
   * https://leetcode.com/problems/merge-intervals/description/
   * @param intervals
   * @return
   */
  public List<Interval> merge(List<Interval> intervals) {
    TreeMap<Integer, Interval> map = new TreeMap();
    for(Interval in: intervals) {
      int st=in.start, en=in.end;
      Map.Entry<Integer, Interval> entry = null;
      // check before
      while((entry = map.floorEntry(st)) != null &&
              entry.getValue().end >= st) {
        // overlapping
        map.remove(entry.getKey());
        st = Math.min(st, entry.getKey());
        en = Math.max(en, entry.getValue().end);
      }
      // check after
      while((entry = map.higherEntry(st)) != null &&
              entry.getKey() <= en) {
        // overlapping
        map.remove(entry.getKey());
        st = Math.min(st, entry.getKey());
        en = Math.max(en, entry.getValue().end);
      }
      // put back
      map.put(st, new Interval(st, en));
    }
    List<Interval> list = new ArrayList<>(map.values());
    return list;
  }

  public List<Interval> merge2(List<Interval> intervals) {
    Collections.sort(intervals, Comparator.comparingInt(i2 -> i2.start));
    for(int i=1; i<intervals.size(); ++i) {
      Interval prev = intervals.get(i-1);
      Interval cur = intervals.get(i);
      if(prev.end >= cur.start) {
        // overlapping
        intervals.remove(i-1);
        cur.start = Math.min(prev.start, cur.start);
        cur.end = Math.max(prev.end, cur.end);
        --i;
      }
    }
    return intervals;
  }
}
