package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-anagram-mappings/description/
 */
public class FindAnagramMappings {
  public int[] anagramMappings(int[] A, int[] B) {
    Map<Integer, Queue<Integer>> map = new HashMap<>();
    for(int i=0; i<B.length; ++i) {
      Queue<Integer> que = map.get(B[i]);
      if(que == null) {
        que = new LinkedList<>();
        map.put(B[i], que);
      }
      que.add(i);
    }
    int[] res = new int[A.length];
    for(int i=0; i<A.length; ++i) {
      Queue<Integer> que = map.get(A[i]);
      res[i] = que.poll();
    }
    return res;
  }
}
