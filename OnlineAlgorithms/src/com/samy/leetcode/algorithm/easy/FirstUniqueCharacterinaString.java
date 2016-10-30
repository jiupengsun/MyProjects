package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 9/18/16.
 */
public class FirstUniqueCharacterinaString {

  /**
   * https://leetcode.com/problems/first-unique-character-in-a-string/
   * @param s
   * @return
   */
  public int firstUniqChar(String s) {
    int[] letters = new int[26];
    for (int i=0, l=s.length(); i<l; ++i)
      letters[s.charAt(i) - 'a']++;

    for (int i=0, l=s.length(); i<l; ++i)
      if (letters[s.charAt(i) - 'a'] == 1)
        return i;

    return -1;
  }
}
