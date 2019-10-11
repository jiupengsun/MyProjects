package com.samy.leetcode.algorithm.hard;

/**
 * {@see <a href="https://leetcode.com/problems/longest-chunked-palindrome-decomposition/">
 *   longest-chunked-palindrome-decomposition</a>
 *   }
 */
public class LongestChunkedPalindromeDecomposition {
  public int longestDecomposition(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    int i = 0, j = text.length() - 1;
    while (i < j) {
      if (isIdentical(text.substring(0, i+1), text.substring(j))) {
        return longestDecomposition(text.substring(i+1, j)) + 2;
      } else {
        i++;
        j--;
      }
    }
    return 1;
  }

  private boolean isIdentical(String ori, String com) {
    return ori.equals(com);
  }

  public static void main(String[] args) {
    LongestChunkedPalindromeDecomposition solution = new LongestChunkedPalindromeDecomposition();
    String test = "aaa";
    System.out.println(solution.longestDecomposition(test));
  }
}
