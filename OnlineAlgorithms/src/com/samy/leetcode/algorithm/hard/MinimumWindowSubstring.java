package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

  /**
   * https://leetcode.com/problems/minimum-window-substring/description/
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    Map<Character, Integer> set = new HashMap<>();
    for(Character c: t.toCharArray())
      set.put(c, set.getOrDefault(c, 0)+1);
    Map<Character, Integer> letters = new HashMap<>();
    Set<Character> flag = new HashSet<>();
    int i=0, l=s.length();
    int min = Integer.MAX_VALUE, start=0;
    for(; i<l; ++i) {
      char c = s.charAt(i);
      if(set.containsKey(c)) {
        int n = letters.getOrDefault(c, 0);
        letters.put(c, ++n);
        if(n==set.get(c) && flag.add(c)) {
          if(flag.size() == set.size())
            break;
        }
      }
    }
    if (i == l)
      return "";

    for(int j=0; i<l; ++j) {
      char c = s.charAt(j);
      if(set.containsKey(c)) {
        Integer n = letters.get(c);
        letters.put(c, --n);
        if (n < set.get(c)){
          if(i-j+1 < min) {
            min = i-j+1;
            start = j;
            if (min == set.size())
              return s.substring(start, start+min);
          }
          // find next c
          while((++i)<l) {
            char tmp = s.charAt(i);
            if (set.containsKey(tmp)) {
              letters.put(tmp, letters.get(tmp)+1);
              if (tmp == c)
                break;
            }
          }
        }
      }
    }
    return s.substring(start, start+min);
  }
}
