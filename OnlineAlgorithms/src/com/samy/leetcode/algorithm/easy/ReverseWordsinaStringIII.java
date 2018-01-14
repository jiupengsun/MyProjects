package com.samy.leetcode.algorithm.easy;

public class ReverseWordsinaStringIII {
  /**
   * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
   * @param s
   * @return
   */
  public String reverseWords(String s) {
    char[] c = s.toCharArray();
    int i, j;
    for(i=0, j=0; j<c.length; ++j) {
      if(c[j] == ' ') {
        reverse(c, i, j-1);
        i = j + 1;
      }
    }
    if(i < j)
      reverse(c, i, j-1);
    return String.valueOf(c);
  }

  private void reverse(char[] c, int i, int j) {
    for(; i<j; ++i, --j) {
      char t = c[i];
      c[i] = c[j];
      c[j] = t;
    }
  }
}
