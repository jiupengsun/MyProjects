package com.samy.leetcode.algorithm.easy;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class FindSmallestLetterGreaterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    int i = 0, j = letters.length - 1, mid;
    while (i <= j) {
      mid = ((j - i) >> 1) + i;
      if (letters[mid] > target)
        j = mid - 1;
      else
        i = mid + 1;
    }
    return i == letters.length ? letters[0] : letters[i] > target ?
                                                letters[i] : letters[j];
  }
}
