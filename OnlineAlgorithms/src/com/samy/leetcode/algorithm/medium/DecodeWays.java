package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/decode-ways/
 * Created by samy on 11/9/16.
 */
public class DecodeWays {

  public int numDecodings(String s) {
    char[] array = s.toCharArray();
    if (array.length==0 || array[0] == '0')
      return 0;
    int[] ways = new int[array.length+1];
    ways[0] = 1;
    ways[1] = 1;
    int i = 0;
    for(i=2; i<ways.length; ++i) {
      // check if legal
      if(array[i-1] == '0' && (array[i-2] == '0' || array[i-2] > '2')) {
        return 0;
      }
      // legal, judge whether could combine with former character
      if(array[i-1] == '0') {
        ways[i] = ways[i-2];
      }
      else if(array[i-2] =='1' || array[i-2]=='2' && array[i-1] <= '6') {
        // could combine
        ways[i] = ways[i-2] + ways[i-1];
      } else {
        // cannot combine
        ways[i] = ways[i-1];
      }
    }
    return ways[i-1];
  }
}
