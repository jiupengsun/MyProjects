package com.samy.leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/flip-game-ii/
 * Created by samy on 11/19/16.
 */
public class FlipGameII {
  public boolean canWin(String s) {
    char[] c = s.toCharArray();
    return DP(c);
  }

  private boolean DP(char[] c) {
    for(int i=0; i<c.length-1; ++i) {
      if(c[i]=='+' && c[i+1]=='+') {
        c[i] = '-';
        c[i+1] = '-';
        boolean next = DP(c);
        c[i] = '+';
        c[i+1] = '+';
        if(!next) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String flip = "+++++";
    FlipGameII fg = new FlipGameII();
    System.out.println(fg.canWin(flip));
  }
}
