package com.samy.leetcode.algorithm.easy;

public class CanPlaceFlowers {

  /**
   *
   * @param flowerbed
   * @param n
   * @return
   */
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int slots = 0;
    for(int i=0; i<flowerbed.length; i+=2) {
      if(flowerbed[i] == 0) {
        // available
        if((i==0 || flowerbed[i-1]==0) &&
             (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
          slots++;
          flowerbed[i] = 1;
        } else
          i--;
      }
    }
    return slots >= n;

  }
}
