package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>(){
      @Override
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });
    PriorityQueue<Integer> meeting = new PriorityQueue<>();
    if(intervals.length > 0)
      meeting.add(intervals[0].end);
    for(int i=1; i<intervals.length; ++i) {
      int in = meeting.peek();
      if(in <= intervals[i].start) {
        meeting.poll();
      }
      meeting.add(intervals[i].end);
    }
    return meeting.size();
  }
}


class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}

