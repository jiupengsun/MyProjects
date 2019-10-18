package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
  private final static int[] letter = new int[]{
    1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
  };

  public String[] findWords(String[] words) {
    List<String> l = new ArrayList<>();
    for (String s : words) {
      int p = -1;
      for (char c : s.toCharArray()) {
        if (c >= 'A' && c <= 'Z')
          c += 32;
        c -= 'a';
        if (p < 0)
          p = letter[c];
        else if (letter[c] != p) {
          p = -1;
          break;
        }
      }
      if (p >= 0)
        l.add(s);
    }
    String[] r = new String[l.size()];
    for (int i = 0; i < r.length; ++i)
      r[i] = l.get(i);
    return r;
  }
}
