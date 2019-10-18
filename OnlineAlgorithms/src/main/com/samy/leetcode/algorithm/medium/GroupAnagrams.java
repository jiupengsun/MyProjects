package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  /**
   * @param strs
   * @return Apr 8, 2016
   * @author Jiupeng
   * @description 100 test cases, 36ms beats 16.53%
   * @reference https://leetcode.com/problems/anagrams/
   * @interpretation
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      int[] letters = new int[26];
      for (Character c : s.toCharArray()) {
        letters[c - 'a']++;
      }
      StringBuilder sb = new StringBuilder("");
      for (int i : letters) {
        sb.append(i + ",");
      }
      String iden = sb.toString();
      List<String> list = map.getOrDefault(iden, new ArrayList<>());
      list.add(s);
      map.put(iden, list);
    }
    return new ArrayList<>(map.values());
  }

}
