package com.samy.leetcode.algorithm.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray {
  public int findShortestSubArray(int[] nums) {
    // get the most number
    Map<Integer, int[]> map = new HashMap<>();
    int max = 1;
    for(int i=0; i<nums.length; ++i) {
      if(map.containsKey(nums[i])) {
        int[] pos = map.get(nums[i]);
        pos[1] = i;
        pos[2]++;
        if(pos[2] > max) max = pos[2];
        map.put(nums[i], pos);
      } else {
        map.put(nums[i], new int[]{i, i, 1});
      }
    }
    int min = nums.length;
    for(int[] i: map.values()) {
      if(i[2] == max) {
        min = Math.min(min, i[1]-i[0]+1);
      }
    }
    return min;
  }
}
