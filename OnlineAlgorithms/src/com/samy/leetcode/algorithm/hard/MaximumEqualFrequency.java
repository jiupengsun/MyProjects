package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-equal-frequency/">Maximum Equal Frequency</a>
 * refer to: https://leetcode.com/problems/maximum-equal-frequency/discuss/403931/JavaC%2B%2BPython-Easy-to-understand-(compare-counts)
 */
public class MaximumEqualFrequency {
  public int maxEqualFreq(int[] nums) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    int max = 0;
    for (int i=0; i<nums.length; ++i) {
      int preSize = freqMap.size();
      int freq = countMap.compute(nums[i], (k, v) -> (v == null ? 1 : v+1));
      freqMap.computeIfPresent(freq-1, (k, v) -> (v == 1 ? null : v-1));
      freqMap.compute(freq, (k, v) -> (v == null ? 1 : v + 1));
      if (preSize == 1
            // before adding this num, every other num has same frequency
            || (freqMap.size() == 2
                  && (freqMap.getOrDefault(freq+1, 0) == 1
                        // e.g. [1,1,2,2,2]
                        || freqMap.getOrDefault(1, 0) == 1))) {
                        // e.g. [1,1,3,2,2]
        max = i;
      }
    }
    return max + 1;
  }

  public static void main(String[] args) {
    MaximumEqualFrequency m = new MaximumEqualFrequency();
/*
    int[] nums = new int[]{2,2,1,1,5,3,3,5};
    int[] nums = new int[]{1,1,1,2,2,2};
    int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5};
    int[] nums = new int[]{1,2,3};
    int[] nums = new int[]{10,2,8,9,3,8,1,5,2,3,7,6};
    int[] nums = new int[]{2,2,1,1,5,3,3,5};
*/
    int[] nums = new int[]{1,2,3,1,2,3,4,4,4,4,1,2,3,5,6};
    System.out.println(m.maxEqualFreq(nums));
  }
}
