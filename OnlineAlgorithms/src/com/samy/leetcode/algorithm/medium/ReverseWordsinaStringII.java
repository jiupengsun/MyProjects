package com.samy.leetcode.algorithm.medium;

public class ReverseWordsinaStringII {

  /**
   * https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
   * @param s
   */
  public void reverseWords(char[] s) {
    int l=s.length;
    reverse(s, 0, l-1);
    for(int i=0, j=1; j<l; ++j) {
      if(j>i && (s[j]==' ' || j==l-1)) {
        int en = j;
        if(s[j] == ' ')
          en--;
        reverse(s, i, en);
        i = j+1;
      }
    }
  }

  private void reverse(char[] s, int st, int en) {
    for(; st < en; st++, en--) {
      char c = s[st];
      s[st] = s[en];
      s[en] = c;
    }
  }}
