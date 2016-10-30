package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/longest-palindrome/
 * Created by samy on 10/6/16.
 */
public class LongestPalindrome {

  /**
   * static the occurence of letters, and return the total sum of even letter and the longest odd letter
   * @param s
   * @return
   */
  public int longestPalindrome(String s) {
    // a~z and A~Z
    int[] letters = new int[52];
    for(int i=0, l=s.length(); i<l; ++i) {
      char c = s.charAt(i);
      if (c >= 'a' && c<='z')
        letters[c - 'a']++;
      else
        letters[c - 'A' + 26]++;
    }
    int sum = 0, odd = 0;
    for (int i : letters) {
      if (i > 0) {
        if ((i & 1) == 0)
          // even
          sum += i;
        else {
          // odd
          if (i > odd) {
            sum += Math.max(odd - 1, 0);
            odd = i;
          } else if (i > 1)
            sum += i - 1;
        }
      }
    }
    return sum + odd;
  }

}
