package com.samy.leetcode.algorithm.easy;

public class LongestUncommonSubsequenceI {
  /**
   * https://leetcode.com/problems/longest-uncommon-subsequence-i/description/
   * @param a
   * @param b
   * @return
   */
  public int findLUSlength(String a, String b) {
    if(a.length() != b.length())
      return Math.max(a.length(), b.length());
    return a.equals(b) ? -1 : a.length();
  }
}
