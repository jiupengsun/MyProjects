package com.samy.leetcode.algorithm.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 * Created by samy on 11/19/16.
 */
public class ShortestWordDistanceII {}

class WordDistance{
  Map<String, List<Integer>> dict;
  public WordDistance(String[] words) {
    dict = new HashMap<>();
    for(int i=0; i<words.length; ++i) {
      List<Integer> po = dict.get(words[i]);
      if(po == null)
        po = new ArrayList<>();
      po.add(i);
      dict.put(words[i], po);
    }
  }

  /**
   * beats 90.4%
   * @param word1
   * @param word2
   * @return
   */
  public int shortest(String word1, String word2) {
    List<Integer> list1 = dict.get(word1);
    List<Integer> list2 = dict.get(word2);
    int min = Integer.MAX_VALUE;
    int i=0, j=0;
    int l1=list1.size(), l2=list2.size();
    while(i<l1 && j<l2) {
      int a = list1.get(i), b=list2.get(j);
      min = Math.min(min, Math.abs(a-b));
      if(a >= b)
        ++j;
      else
        ++i;
    }
    return min;
  }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
