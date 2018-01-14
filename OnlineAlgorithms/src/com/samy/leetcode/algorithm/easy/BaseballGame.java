package com.samy.leetcode.algorithm.easy;

import java.util.Deque;
import java.util.LinkedList;

public class BaseballGame {
  /**
   * https://leetcode.com/problems/baseball-game/description/
   * @param ops
   * @return
   */
  public int calPoints(String[] ops) {
    int sum = 0;
    Deque<Integer> stack = new LinkedList<>();
    for(String s: ops) {
      if(s.equals("C")) {
        sum -= stack.pop();
      } else if(s.equals("D")) {
        int t = stack.peek() << 1;
        sum += t;
        stack.push(t);
      } else if(s.equals("+")) {
        int t = stack.pop();
        int t2 = t + stack.peek();
        stack.push(t);
        stack.push(t2);
        sum += t2;
      } else {
        int t = Integer.parseInt(s);
        stack.push(t);
        sum += t;
      }
    }
    return sum;
  }
}
