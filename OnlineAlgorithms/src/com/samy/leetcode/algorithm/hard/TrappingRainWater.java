package com.samy.leetcode.algorithm.hard;

public class TrappingRainWater {

  /**
   * https://leetcode.com/problems/trapping-rain-water/description/
   *
   * @param height
   * @return
   */
  public int trap(int[] height) {
    int[] left = new int[height.length];
    int i, max = 0;
    for (i = 0; i < height.length; ++i) {
      left[i] = max;
      max = Math.max(height[i], max);
    }
    int count = 0;
    for (max = 0, i = height.length - 1; i >= 0; --i) {
      count += Math.max(0, Math.min(left[i], max) - height[i]);
      max = Math.max(height[i], max);
    }
    return count;
  }
}
