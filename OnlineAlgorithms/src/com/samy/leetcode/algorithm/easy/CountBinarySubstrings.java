package com.samy.leetcode.algorithm.easy;

public class CountBinarySubstrings {
  /**
   * https://leetcode.com/problems/count-binary-substrings/description/
   * @param s
   * @return
   */
  public int countBinarySubstrings(String s) {
    if(s.equals("")) return 0;
    int last = 0, count = 0, tmp = 1;
    for(int i=1; i<s.length(); ++i) {
      if(s.charAt(i) == s.charAt(i-1)) tmp++;
      else {
        count += Math.min(last, tmp);
        last = tmp;
        tmp = 1;
      }
    }
    count += Math.min(last, tmp);
    return count;
  }
}
