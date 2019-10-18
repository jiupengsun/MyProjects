package com.samy.leetcode.algorithm.easy;

public class DetectCapital {

  /**
   * https://leetcode.com/problems/detect-capital/description/
   *
   * @param word
   * @return
   */
  public boolean detectCapitalUse(String word) {
    int count = 0;
    for (char c : word.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        count++;
      }
    }
    return count == 0 || count == word.length() || (count == 1 && word.charAt(0) <= 'Z');
  }
}
