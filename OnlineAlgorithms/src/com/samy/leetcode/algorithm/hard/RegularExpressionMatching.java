package com.samy.leetcode.algorithm.hard;

public class RegularExpressionMatching {

  /**
   * https://leetcode.com/problems/regular-expression-matching/description/
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    int pos_s=s.length()-1, pos_p=p.length()-1;
    int lastPattern=0, lastMatch=0;
    while(pos_s >= 0) {
      if(pos_p>=0 && (p.charAt(pos_p)==s.charAt(pos_s) || p.charAt(pos_p)=='.')) {
        pos_s--;
        pos_p--;
      } else if (pos_p>=0 && p.charAt(pos_p)=='*') {
        lastPattern = pos_p;
      }
    }
    return false;
  }
}
