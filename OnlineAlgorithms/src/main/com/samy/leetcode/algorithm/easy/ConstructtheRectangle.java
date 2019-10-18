package com.samy.leetcode.algorithm.easy;

public class ConstructtheRectangle {
  public int[] constructRectangle(int area) {
    int w = (int) Math.sqrt(area);
    while ((area % w) != 0)
      w--;
    return new int[]{area / w, w};
  }
}
