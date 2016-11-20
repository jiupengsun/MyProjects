package com.samy.leetcode.algorithm.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 * Created by samy on 11/18/16.
 */
public class AssignCookies {

  /**
   * sort the array
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int i=0, j=0, l1=g.length, l2=s.length;
    while(i<l1 && j<l2) {
      if(s[j] >= g[i]) {
        ++count;
        ++i;
        ++j;
      } else {
        ++j;
      }
    }
    return count;
  }
}
