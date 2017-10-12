package com.samy.leetcode.algorithm.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ExclusiveTimeofFunctions {

  /**
   * https://leetcode.com/submissions/detail/122314507/
   * @param n
   * @param logs
   * @return
   */
  public int[] exclusiveTime(int n, List<String> logs) {
    int[] timeSlot = new int[n];
    int interval = 0;
    Deque<int[]> stack = new LinkedList<>();
    for(String log: logs) {
      String[] l = log.split(":");
      int id = Integer.parseInt(l[0]);
      int time = Integer.parseInt(l[2]);
      if(l[1].equals("start")) {
        stack.push(new int[]{id, time, interval});
        interval = 0;
      } else {
        int[] last = stack.pop();
        int running_time = time - last[1] + 1;
        running_time -= interval;
        timeSlot[id] += running_time;
        interval = last[2] + time - last[1] + 1;
      }
    }
    return timeSlot;
  }
}
