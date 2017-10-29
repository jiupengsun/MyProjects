package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

  /**
   * https://leetcode.com/problems/group-shifted-strings/description/
   * @param strings
   * @return
   */
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for(String s: strings) {
      StringBuilder sb = new StringBuilder("");
      for(int i=1, l=s.length(); i<l; ++i) {
        int diff = s.charAt(i) - s.charAt(i-1);
        if(diff < 0)
          diff += 26;
        sb.append(String.valueOf(diff) + " ");
      }
      String index = sb.toString();
      List<String> list = map.getOrDefault(index, new ArrayList<>());
      list.add(s);
      map.put(index, list);
    }
    List<List<String>> list = new ArrayList<>(map.values());
    return list;
  }
}
