package com.samy.leetcode.algorithm.hard;

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">Longest Valid Parentheses</a>
 */
public class LongestValidParentheses {
  public static void main(String[] args) {
    LongestValidParentheses solution = new LongestValidParentheses();
    System.out.println(solution.longestValidParentheses("(()"));
    System.out.println(solution.longestValidParentheses(")()())"));
    System.out.println(solution.longestValidParentheses("()(())"));
  }

  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }
    int firstValid = s.indexOf('(');
    if (firstValid < 0) {
      return 0;
    }
    // skip to first left
    s = s.substring(s.indexOf('('));
    int max = 0;
    // count[i] means the length of valid parentheses at position i.
    int[] count = new int[s.length()];
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          // style: xxx()
          count[i] = i >= 2 ? count[i - 2] + 2 : 2;
        } else if (count[i - 1] > 0 && i > count[i - 1] && s.charAt(i - count[i - 1] - 1) == '(') {
          // style: ((xxx))
          count[i] = count[i - 1] + 2 + (i > count[i - 1] + 1 ? count[i - count[i - 1] - 2] : 0);
        }
        max = Math.max(max, count[i]);
      }
    }
    return max;
  }
}
