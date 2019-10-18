package com.samy.leetcode.algorithm.hard;

import java.util.Deque;
import java.util.LinkedList;

public class RegularExpressionMatching {

  public static void main(String[] args) {
    Deque<Integer> stack = new LinkedList<>();
    System.out.println(new Integer(1) == null);
  }

  /**
   * https://leetcode.com/problems/regular-expression-matching/description/
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    char[] pattern = new char[p.length()];
    int l = 0;
    for (int i = 0; i < pattern.length; ++i) {
      // skip repeat start
      if (i > 0 && p.charAt(i) == '*' && pattern[l - 1] == '*')
        continue;
      pattern[l++] = p.charAt(i);
    }
    // l is the new length
    return helper(s, pattern, 0, 0, l);
  }

  private boolean helper(String s, char[] pattern, int pos_s, int pos_p, int length) {
    if (pos_s == s.length() && pos_p == length)
      return true;
    if (pos_s == s.length() || pos_p == length) {
      if (pos_p == length)
        return false;
      if (pos_p < length - 1 && pattern[pos_p + 1] == '*')
        return helper(s, pattern, pos_s, pos_p + 2, length);
      return false;
    }
    if (pos_p < length - 1 && pattern[pos_p + 1] == '*') {
      // next char is star
      // if don't match current char
      if (helper(s, pattern, pos_s, pos_p + 2, length))
        return true;
      // if match current char for N times
      while (pos_s < s.length()) {
        if (s.charAt(pos_s) == pattern[pos_p] || pattern[pos_p] == '.') {
          if (helper(s, pattern, pos_s + 1, pos_p + 2, length))
            return true;
          ++pos_s;
        } else
          break;
      }
    } else if (s.charAt(pos_s) == pattern[pos_p] || pattern[pos_p] == '.')
      // next char isn't start
      // just match current one
      return helper(s, pattern, pos_s + 1, pos_p + 1, length);
    return false;
  }
}
