package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 * Created by samy on 11/19/16.
 */
public class RepeatedSubstringPattern {
  public boolean repeatedSubstringPattern(String str) {
    char[] c = str.toCharArray();
    int i=0,j=1;
    while(j<c.length) {
      // c[i] == c[j]
      int o = j;
      while(i<o && j<c.length) {
        if(c[i]==c[j]) {
          ++i;
          ++j;
        } else {
          i = 0;
          if(c[i] != c[j])
            ++j;
          break;
        }
      }
      if (i==o && j==c.length) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String s ="ababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaa";
    RepeatedSubstringPattern r = new RepeatedSubstringPattern();
    System.out.println(r.repeatedSubstringPattern(s));
  }
}
