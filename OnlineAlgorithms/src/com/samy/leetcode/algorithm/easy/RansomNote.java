package com.samy.leetcode.algorithm.easy;

/**
 * Created by samy on 9/18/16.
 */
public class RansomNote {

  /**
   *
   * https://leetcode.com/problems/ransom-note/
   * @param ransomNote
   * @param magazine
   * @return
   */
  public boolean canConstruct(String ransomNote, String magazine) {

    int[] letters = new int[26];
    for (int i=0, l=magazine.length(); i<l; ++i)
      letters[magazine.charAt(i) - 'a']++;

    for (int i=0, l=ransomNote.length(); i<l; ++i)
      letters[ransomNote.charAt(i) - 'a']--;

    for (int l: letters)
      if (l < 0)
        return false;
    return true;
  }
}
