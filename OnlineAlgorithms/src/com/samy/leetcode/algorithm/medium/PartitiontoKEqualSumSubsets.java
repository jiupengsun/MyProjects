package com.samy.leetcode.algorithm.medium;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {

  public static void main(String[] args) {
    PartitiontoKEqualSumSubsets pk = new PartitiontoKEqualSumSubsets();
    System.out.println(pk.canPartitionKSubsets(new int[]{2, 2, 10, 5, 2, 7, 2, 2, 13}, 3));
  }

  /**
   * @param nums
   * @param k
   * @return
   */
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if (sum % k != 0)
      return false;
    sum /= k;
    Arrays.sort(nums);
    if (nums[nums.length - 1] > sum)
      return false;
    boolean[] visit = new boolean[nums.length];
    for (int i = nums.length - 1; i >= 0; --i) {
      if (!visit[i] && !helper(nums, visit, i, sum) || !visit[i]) {
        return false;
      }
    }
    return true;
  }

  private boolean helper(int[] nums, boolean[] visit, int pos, int target) {
    if (target == 0)
      return true;
    for (int i = pos; i >= 0; --i) {
      if (visit[i] || nums[i] > target)
        continue;
      visit[i] = true;
      if (helper(nums, visit, i - 1, target - nums[i]))
        return true;
      visit[i] = false;
    }
    return false;
  }
}
