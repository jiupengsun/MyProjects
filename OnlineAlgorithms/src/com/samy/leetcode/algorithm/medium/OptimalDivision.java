package com.samy.leetcode.algorithm.medium;

public class OptimalDivision {

  public String optimalDivision(int[] nums) {
    int l = nums.length;
    if(l == 0)
      return "";
    if(l == 1)
      return String.valueOf(nums[0]);
    if(l == 2)
      return nums[0] + "/" + nums[1];
    StringBuilder sb = new StringBuilder("" + nums[0]);
    sb.append("/(");
    for(int i=1; i<l; ++i) {
      sb.append(nums[i] + "/");
    }
    sb.deleteCharAt(sb.length()-1);
    sb.append(")");
    return sb.toString();
  }
}
