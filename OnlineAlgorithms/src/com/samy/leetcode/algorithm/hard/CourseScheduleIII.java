package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class CourseScheduleIII {
  /**
   * https://leetcode.com/problems/course-schedule-iii/description/
   * @param courses
   * @return
   */
  public int scheduleCourse(int[][] courses) {
    // sort by ddl, process task which has nearest ddl
    Arrays.sort(courses, Comparator.comparingInt(i -> i[1]));
    // max heap
    PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i2 - i1);

    int last = 0;
    for(int[] c: courses) {
      last += c[0];
      que.add(c[0]);
      if(last > c[1]) {
        // if current task is overtime
        // then remove previous task who has longest running time
        last -= que.poll();
      }
    }
    return que.size();
  }
}
