package com.samy.leetcode.algorithm.medium;

public class MaximumProductSubarray {

  /**
   * https://leetcode.com/problems/maximum-product-subarray/description/
   * @param nums
   * @return
   */
  public int maxProduct(int[] nums) {
    // store the result that is the max we have found so far
    int r = nums[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
      // multiplied by a negative makes big number smaller, small number bigger
      // so we redefine the extremums by swapping them
      if (nums[i] < 0) {
        int tmp = imax;
        imax = imin;
        imin = tmp;
      }

      // max/min product for the current number is either the current number itself
      // or the max/min by the previous number times the current one
      imax = Math.max(nums[i], imax * nums[i]);
      imin = Math.min(nums[i], imin * nums[i]);

      // the newly computed max value is a candidate for our global result
      r = Math.max(r, imax);
    }
    return r;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, -5, -2, -4, 3};
    MaximumProductSubarray mps = new MaximumProductSubarray();
    System.out.println(mps.maxProduct(nums));
  }
}
