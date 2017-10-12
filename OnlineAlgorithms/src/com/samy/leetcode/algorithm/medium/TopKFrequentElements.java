package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class TopKFrequentElements {

  /**
   *
   * @param nums
   * @param k
   * @return
   * Apr 18, 2016
   * @author Jiupeng
   * @description
   * @reference https://leetcode.com/problems/top-k-frequent-elements/
   * @interpretation
   */
  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    List<Integer> list = new ArrayList<>(k);
    PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      que.add(new int[]{entry.getKey(), entry.getValue()});
    }
    for(int i=0; i<k; ++i)
      list.add(que.poll()[0]);
    return list;
  }

  /**
   * use bucket sort
   * @param nums
   * @param k
   * @return
   */
  public List<Integer> topKFrequent2(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    List<Integer> list = new ArrayList<>(k);
    List<Integer>[] bucket = new List[nums.length];
    for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
      int num = entry.getKey(), count = entry.getValue();
      if(bucket[count - 1] == null) {
        bucket[count - 1] = new ArrayList();
      }
      bucket[count - 1].add(num);
    }
    for(int i=0, j=nums.length-1; j>=0 && i<k; --j) {
      if(bucket[j] != null) {
        int t = 0;
        while(t<bucket[j].size() && i<k) {
          list.add(bucket[j].get(t));
          ++i;
          ++t;
        }
      }
    }
    return list;
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
