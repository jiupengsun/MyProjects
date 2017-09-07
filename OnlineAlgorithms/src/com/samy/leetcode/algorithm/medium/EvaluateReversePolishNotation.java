package com.samy.leetcode.algorithm.medium;

import java.util.Deque;
import java.util.LinkedList;

public class EvaluateReversePolishNotation {

  /**
   * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
   * @param tokens
   * @return
   */
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new LinkedList<>();
    int j=0;
    int p, q;
    while(j < tokens.length) {
      switch(tokens[j]) {
        case "+":
          p = stack.pop();
          q = stack.pop();
          stack.push(p + q);
          break;
        case "-":
          p = stack.pop();
          q = stack.pop();
          stack.push(q - p);
          break;
        case "*":
          p = stack.pop();
          q = stack.pop();
          stack.push(p * q);
          break;
        case "/":
          p = stack.pop();
          q = stack.pop();
          stack.push(q / p);
          break;
        default:
          stack.push(Integer.parseInt(tokens[j]));
      }
      ++j;
    }
    return stack.peek();
  }
}
