package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {

  /**
   * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
   * @param nums1
   * @param nums2
   * @param k
   * @return
   * https://discuss.leetcode.com/topic/50885/simple-java-o-klogk-solution-with-explanation
   */
  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    if(nums1.length == 0 || nums2.length==0)
      return new ArrayList<int[]>();
    PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>(){
      @Override
      public int compare(int[] i1, int[] i2) {
        return i1[0] + i1[1] - i2[0] - i2[1];
      }
    });

    for(int i=0; i<nums1.length && i<k; ++i)
      que.add(new int[]{nums1[i], nums2[0], 0});
    List<int[]> list = new ArrayList<>();
    while(k-- > 0 && !que.isEmpty()) {
      int[] n = que.poll();
      list.add(new int[]{n[0], n[1]});
      if(n[2] < nums2.length-1)
        que.add(new int[]{n[0], nums2[n[2]+1], n[2]+1});
    }
    return list;
  }
}
