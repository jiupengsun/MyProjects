package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/maximum-equal-frequency/">Maximum Equal Frequency</a>
 * refer to: https://leetcode.com/problems/maximum-equal-frequency/discuss/403931/JavaC%2B%2BPython-Easy-to-understand-(compare-counts)
 */
// TODO not correct yet
public class MaximumEqualFrequency {
  public int maxEqualFreq(int[] nums) {
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    int max = 0;
    for (int i=0; i<nums.length; ++i) {
      int freq = countMap.compute(nums[i], (k, v) -> (v == null ? 1 : v+1));
      Integer prevCount = freqMap.computeIfPresent(freq-1, (k, v) -> (v == 1 ? null : v-1));
      int count = freqMap.compute(freq, (k, v) -> (v == null ? 1 : v + 1));
      // thus we can know freqMap at least contains key=freq
      if (freqMap.size() == 2
            // if we want to remove one element and all of the other elements
            // have same frequency, then we definitely have and only have 2 frequencies
            && countMap.size() >= 2
            // we must have at least 2 elements
            && (freqMap.getOrDefault(1, 0) == 1
            // case 1: only one element occurs once
                  || prevCount != null && count == 1
                  // case 2: other elements have frequency freq-1, and only current element have freq, then remove one
                  || freqMap.getOrDefault(freq+1, 0) == 1))
                  // case 3: only one element have frequence freq+1, others have freq
      {
        max = i;
      }
    }
    return max + 1;
  }

  public static void main(String[] args) {
    MaximumEqualFrequency m = new MaximumEqualFrequency();
/*
    int[] nums = new int[]{10,2,8,9,3,8,1,5,2,3,7,6};
    int[] nums = new int[]{2,2,1,1,5,3,3,5};
    int[] nums = new int[]{1,1,1,2,2,2};
    int[] nums = new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5};
*/
    int[] nums = new int[]{1,2,3};
    System.out.println(m.maxEqualFreq(nums));
  }
}
