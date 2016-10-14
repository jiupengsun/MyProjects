package com.samy.leetcode.algorithm.hard;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 * Created by samy on 10/14/16.
 */
public class ShortestPalindrome {

  public static String shortestPalindrome(String s) {
    int l=s.length();
    int i=l-1, j, k=0;
    for(; i>=0; --i) {
      if(s.charAt(i) != s.charAt(0))
        continue;
      for(j=i-1, k=1; j>=0; --j, ++k) {
        if(s.charAt(j) == s.charAt(k))
          continue;
        else
          break;
      }
      if (j == -1) {
        // find
        StringBuilder sb = new StringBuilder(s.substring(k));
        return sb.reverse() + s;
      }
    }
    return k==l ? s : new StringBuilder(s.substring(k+1)).reverse() + s;
  }

  public static String shortestPalindrome2(String s) {
    int l=s.length(), k=0, next=l;
    char[] array = s.toCharArray();
    for (int i=l-1, j; i>=0;) {
      if (array[i] != array[0]) {
        --i;
        continue;
      }
      // find i
      for (j=i-1, k=1; j>-1; --j, ++k) {
        if (next==l && array[j] == array[0]) {
          // set next pointer
          next = j;
        }
        if (array[j] == array[k])
          continue;
        else
          break;
      }
      if (j < 0) {
        // find
        StringBuilder sb = new StringBuilder();
        for (j=l-1; j>=k; --j)
          sb.append(array[j]);
        sb.append(s);
        return sb.toString();
      }
      if (next < l) {
        i = next;
        next = l;
      } else
        i = j-1;
    }

    if (k == l)
      return s;
    else {
      StringBuilder sb = new StringBuilder();
      for (int j=l-1; j>k; --j)
        sb.append(array[j]);
      sb.append(s);
      return sb.toString();
    }
  }

  public static void main(String[] args) {
  }
}
