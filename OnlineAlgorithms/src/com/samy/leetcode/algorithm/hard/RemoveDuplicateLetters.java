package com.samy.leetcode.algorithm.hard;


import java.util.PriorityQueue;

public class RemoveDuplicateLetters {

  public static void main(String[] args) {
    RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
    System.out.println(rd.removeDuplicateLetters("mitnlruhznjfyzmtmfnstsxwktxlboxutbic"));
  }

  /**
   * https://leetcode.com/problems/remove-duplicate-letters/description/
   *
   * @param s
   * @return
   */
  public String removeDuplicateLetters(String s) {
    int[] letters = new int[26];
    // postion
    PriorityQueue<Integer> que = new PriorityQueue<>();
    for (int i = 0, l = s.length(); i < l; ++i) {
      int pos = s.charAt(i) - 'a';
      // avoid index 0
      letters[pos] = i + 1;
    }
    for (int i = 0; i < 26; ++i) {
      if (letters[i] > 0)
        que.add(letters[i] - 1);
    }
    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (!que.isEmpty()) {
      int pos = que.poll();
      if (letters[s.charAt(pos) - 'a'] < 0) {
        // this character has been used
        continue;
      }
      int min = -1;
      for (; i <= pos; ++i) {
        if (letters[s.charAt(i) - 'a'] < 0) {
          // this character has been used
          continue;
        }
        if (min < 0 || s.charAt(min) > s.charAt(i))
          min = i;
      }
      if (min >= 0) {
        sb.append(s.charAt(min));
        letters[s.charAt(min) - 'a'] = -1;
        if (letters[s.charAt(pos) - 'a'] > 0)
          que.add(pos);
        i = min + 1;
      } else
        i = pos + 1;
    }
    return sb.toString();
  }
}
