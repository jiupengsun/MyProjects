package com.samy.leetcode.algorithm.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    int l = s.length();
    boolean[] dp = new boolean[l];
    for(int i=0; i<l; ++i) {
      for(int j=0; j<=i; ++j) {
        if((j == 0 || dp[j-1]) && dict.contains(s.substring(j, i+1))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[l - 1];
  }
}
