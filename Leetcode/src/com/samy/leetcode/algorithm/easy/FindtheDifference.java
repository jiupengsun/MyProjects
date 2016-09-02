package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 9/2/16.
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindtheDifference {

  public char findTheDifference(String s, String t) {
    int c = 0;
    for(int i=0, l=s.length(); i<l; ++i)
      c ^= (int) s.charAt(i);
    for(int i=0, l=t.length(); i<l; ++i)
      c ^= (int) t.charAt(i);

    return (char)c;
  }
}
