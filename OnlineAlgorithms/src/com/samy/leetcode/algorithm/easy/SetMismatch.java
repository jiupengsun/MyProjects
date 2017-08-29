package com.samy.leetcode.algorithm.easy;

public class SetMismatch {

  /**
   * https://leetcode.com/problems/set-mismatch/description/
   * @param nums
   * @return
   */
  public int[] findErrorNums(int[] nums) {
    boolean[] n = new boolean[nums.length];
    int repeat = -1;
    for(int i: nums) {
      if(n[i-1])
        repeat = i;
      n[i-1] = true;
    }
    for(int i=0; i<nums.length; ++i) {
      if(!n[i]) {
        if(i == repeat - 1)
          continue;
        return new int[] {repeat, i+1};
      }
    }
    return new int[]{};

  }
}
