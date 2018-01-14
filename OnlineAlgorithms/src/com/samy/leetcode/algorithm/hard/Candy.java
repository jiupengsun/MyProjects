package com.samy.leetcode.algorithm.hard;

public class Candy {

  /**
   * https://leetcode.com/problems/candy/description/
   * @param ratings
   * @return
   * TLE
   */
  public int candy(int[] ratings) {
    if(ratings.length == 0)
      return 0;
    int[] dp = new int[ratings.length];
    int count = 1;
    dp[0] = 1;
    for(int i=1; i<ratings.length; ++i) {
      if(ratings[i] == ratings[i-1]) {
        dp[i] = 1;
      } else if(ratings[i] > ratings[i-1]){
        dp[i] = dp[i-1] + 1;
      } else {
        // dp[i] < dp[i-1]
        if(dp[i-1] > 1) {
          dp[i] = 1;
        } else {
          // dp[i-1]=1 && ratings[i]<ratings[i-1]
          // trace back to find ratings[k-1]<=ratings[k] || k==0
          dp[i] = 1;
          int k = i - 1;
          while(k>=0 && ratings[k]>ratings[k+1] && dp[k]<=dp[k+1]) {
            dp[k--]++;
            count++;
          }
        }
      }
      count += dp[i];
    }
    return count;
  }

  public int candy2(int[] ratings) {
    int[] nums = new int[ratings.length];
    int count = ratings.length;
    for(int i=1; i<ratings.length; ++i) {
      if(ratings[i] > ratings[i-1])
        nums[i] = nums[i-1] + 1;
    }
    count += nums[nums.length - 1];
    for(int i=nums.length-2; i>=0; --i) {
      int tmp = ratings[i]>ratings[i+1] ? nums[i+1]+1 : 0;
      nums[i] = Math.max(nums[i], tmp);
      count += nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(Integer.parseInt("+ 00123"));
  }
}
