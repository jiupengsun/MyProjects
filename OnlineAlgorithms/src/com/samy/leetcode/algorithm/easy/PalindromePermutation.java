package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/palindrome-permutation/
 * Created by samy on 11/19/16.
 */
public class PalindromePermutation {
  public boolean canPermutePalindrome(String s) {
    int[] letter = new int[256];
    for(char c : s.toCharArray())
      letter[c]++;
    int odd = 0;
    for(int i : letter)
      if((i&1) == 1) {
        ++odd;
        if(odd > 1)
          return false;
      }
    return true;
  }
}
