package com.samy.leetcode.algorithm.medium;

public class OneEditDistance {

  /**
   * https://leetcode.com/problems/one-edit-distance/description/
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isOneEditDistance(String s, String t) {
    int ls = s.length(), ts = t.length();
    if (ls == ts) {
      // check if there's only one position not same
      int count = 0;
      for (int i = 0; i < ls; ++i) {
        if (s.charAt(i) != t.charAt(i)) {
          if (++count > 1)
            return false;
        }
      }
      return count == 1;
    } else {
      if (Math.abs(ls - ts) != 1)
        return false;
      if (ts > ls) {
        String tmp = s;
        s = t;
        t = tmp;
        ts = t.length();
      }
      boolean skip = false;
      for (int i = 0, j = 0; i < ts; ++i, ++j) {
        if (s.charAt(j) != t.charAt(i)) {
          if (!skip) {
            skip = true;
            --i;
          } else
            return false;
        }
      }
      return true;
    }
  }
}
