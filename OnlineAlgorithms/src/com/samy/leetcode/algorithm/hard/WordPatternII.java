package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {

  /**
   * https://leetcode.com/problems/word-pattern-ii/description/
   *
   * @param pattern
   * @param str
   * @return
   */
  public boolean wordPatternMatch(String pattern, String str) {
    String[] cToS = new String[26];
    Map<String, Character> sToC = new HashMap<>();
    return helper(pattern, str, 0, 0, cToS, sToC);
  }

  private boolean helper(String pattern, String str, int p, int s, String[] cToS, Map<String, Character> sToC) {
    if (p == pattern.length() && s == str.length())
      return true;
    if (p >= pattern.length() || s >= str.length())
      return false;
    char c = pattern.charAt(p);
    if (cToS[c - 'a'] != null) {
      String tmp = cToS[c - 'a'];
      for (int i = 0, l = Math.min(tmp.length(), str.length() - s); i < l; ++i) {
        if (tmp.charAt(i) != str.charAt(s + i))
          return false;
      }
      // match
      return helper(pattern, str, p + 1, s + tmp.length(), cToS, sToC);
    } else {
      for (int i = s + 1, l = str.length(); i <= l; ++i) {
        String tmp = str.substring(s, i);
        if (!sToC.containsKey(tmp)) {
          cToS[c - 'a'] = tmp;
          sToC.put(tmp, c);
          if (helper(pattern, str, p + 1, i, cToS, sToC))
            return true;
          sToC.remove(tmp);
          cToS[c - 'a'] = null;
        }
      }
      return false;
    }
  }
}
