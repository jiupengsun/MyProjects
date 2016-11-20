package com.samy.leetcode.algorithm.medium;

/**
 * https://leetcode.com/problems/shortest-word-distance-iii/
 * Created by samy on 11/19/16.
 */
public class ShortestWordDistanceIII {

  public int shortestWordDistance(String[] words, String word1, String word2) {
    int min = Integer.MAX_VALUE;
    if(word1.equals(word2)) {
      int last = -1;
      for(int i=0; i<words.length; ++i) {
        if(words[i].equals(word1)) {
          if(last >= 0) {
            min = Math.min(min, i-last);
          }
          last = i;
        }
      }

    } else {
      int last1=-1, last2=-1;
      for(int i=0; i<words.length; ++i) {
        if(words[i].equals(word1)) {
          if(last2 >= 0) {
            min = Math.min(min, i-last2);
          }
          last1 = i;
        } else if (words[i].equals(word2)) {
          if(last1 >= 0) {
            min = Math.min(min, i-last1);
          }
          last2 = i;
        }
      }
    }
    return min;
  }
}
