package com.samy.leetcode.algorithm.hard;

/**
 * <a href="https://leetcode.com/problems/count-vowels-permutation/">Count Vowels Permutation</a>
 */
public class CountVowelsPermutation {
  public int countVowelPermutation(int n) {
    long a=1, e=1, i=1, o=1, u=1;
    int j = 1, mod = 1000000007;
    while (j < n) {
      long _a = e;
      long _e = a+i;
      long _i = a+e+o+u;
      long _o = i+u;
      long _u = a;
      a = _a % mod;
      e = _e % mod;
      i = _i % mod;
      o = _o % mod;
      u = _u % mod;
      j++;
    }
    return (int)((a+e+i+o+u) % mod);
  }
}
