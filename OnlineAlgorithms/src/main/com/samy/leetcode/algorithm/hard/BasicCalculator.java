package com.samy.leetcode.algorithm.hard;

import java.util.Deque;
import java.util.LinkedList;

public class BasicCalculator {
  public static void main(String[] args) {
    BasicCalculator bc = new BasicCalculator();
    bc.calculate("(1+(4+5+2)-3)+(6+8)");
  }

  /**
   * https://leetcode.com/problems/basic-calculator/description/
   *
   * @param s
   * @return
   */
  public int calculate(String s) {
    Deque<Character> ops = new LinkedList<>();
    Deque<Integer> digit = new LinkedList<>();
    int i = 0, j = 0;
    for (; j <= s.length(); ++j) {
      char c = ' ';
      if (j < s.length()) {
        c = s.charAt(j);
        if (c >= '0' && c <= '9') {
          continue;
        }
      }
      // not a digit
      if (i < j) {
        // transform it to integer
        int num = Integer.parseInt(s.substring(i, j).trim());
        // check ops
        if (ops.isEmpty() || ops.peek() == '(')
          digit.push(num);
        else {
          if (ops.pop() == '-')
            num = -num;
          if (!digit.isEmpty()) {
            num = digit.pop() + num;
          }
          digit.push(num);
        }
      }
      // a continuous space
      if (c == ' ') {
        i = j + 1;
        continue;
      }
      // operator
      if (c == ')') {
        ops.pop();
        if (!ops.isEmpty()) {
          int num = digit.pop();
          if (ops.pop() == '-')
            num = -num;
          if (!digit.isEmpty()) {
            num = digit.pop() + num;
          }
          digit.push(num);
        }
      } else
        ops.push(c);
      i = j + 1;
    }
    return digit.pop();
  }
}
