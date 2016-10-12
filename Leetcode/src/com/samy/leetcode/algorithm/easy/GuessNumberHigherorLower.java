package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * Created by samy on 10/11/16.
 */
public class GuessNumberHigherorLower {
  /* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

  private int num;

  public int newGame(int n) {
    //num = (int)(Math.random() * n);
    num = n;
    return num;
  }

  public int guessNumber(int n) {
    long i=1, j=n;
    int mid = 1;
    while(i <= j) {
      mid = (int)((i + j) >> 1);
      int g = guess(mid);
      if (g == 0)
        return mid;
      else if (g < 0)
        j = mid - 1;
      else
        i = mid + 1;
    }
    return mid;
  }

  private int guess(int n){
    return n < num ? 1 : (n > num ? -1 : 0);
  }

  public static void main(String[] args) {
    GuessNumberHigherorLower gn = new GuessNumberHigherorLower();
    int N = 2126753390;
    int n = gn.newGame(1702766719);
    System.out.println("n=" + n + ", guess=" + gn.guessNumber(N));
  }

}
