package com.samy.leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-game/
 * Created by samy on 11/19/16.
 */
public class FlipGame {
  public List<String> generatePossibleNextMoves(String s) {
    char[] c = s.toCharArray();
    List<String> list = new ArrayList<>();
    for(int i=0; i<c.length-1; ++i) {
      if(c[i]=='+' && c[i+1]=='+') {
        c[i] = '-';
        c[i+1] = '-';
        list.add(new String(c));
        c[i] = '+';
        c[i+1] = '+';
      }
    }
    return list;
  }
}
