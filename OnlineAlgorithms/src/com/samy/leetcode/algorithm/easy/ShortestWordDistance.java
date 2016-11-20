package com.samy.leetcode.algorithm.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 * Created by samy on 11/19/16.
 */
public class ShortestWordDistance {
  public int shortestDistance(String[] words, String word1, String word2) {
    Queue<Integer> que = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    for(int i=0; i<words.length; ++i) {
      if(words[i].equals(word1))
        que.add(i);
    }
    for(int i=0; i<words.length; ++i) {
      if(words[i].equals(word2)) {
        while(!que.isEmpty() && que.peek()<=i) {
          int j = que.poll();
          min = Math.min(min, i-j);
        }
        if(!que.isEmpty()) {
          min = Math.min(min, que.peek() - i);
        } else
          return min;
      }
    }
    return min;
  }

  public int shortestDistance2(String[] words, String word1, String word2) {
    int last1=-1, last2=-1;
    int min = Integer.MAX_VALUE;
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
    return min;
  }
}
