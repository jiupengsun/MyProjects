package com.samy.leetcode.algorithm.medium;

/**
 * Created by samy on 10/30/16.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputarrayissorted {

  public int[] twoSum(int[] numbers, int target) {
    int[] indices = new int[2];
    int i=0, j=numbers.length-1;
    if(i>=j)
      return indices;
    while(i < j) {
      int sum = numbers[i] + numbers[j];
      if (sum > target)
        --j;
      else if (sum < target)
        ++i;
      else {
        indices[0] = i+1;
        indices[1] = j+1;
        break;
      }
    }
    return indices;
  }
}
