package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class SortCharactersByFrequency {

  /**
   * https://leetcode.com/problems/sort-characters-by-frequency/description/
   * @param s
   * @return
   */
  public String frequencySort(String s) {
    Map<Integer, Integer> map = new HashMap<>();
    for(char c: s.toCharArray()) {
      int n = map.getOrDefault(c, 0);
      map.put((int)c, n+1);
    }
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
      @Override
      public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
        return m2.getValue() - m1.getValue();
      }
    });
    StringBuilder sb = new StringBuilder();
    for(Map.Entry<Integer, Integer> m: list) {
      int c = m.getKey(), n = m.getValue();
      while(n-- > 0)
        sb.append((char) c);
    }
    return sb.toString();
  }

  public String frequencySort2(String s) {
    int l = s.length();
    Map<Integer, List<Character>> map = new HashMap<>();
    int[] letters = new int[256];
    for(char c: s.toCharArray()) {
      letters[(int)c]++;
    }
    for(int i=0; i<256; ++i)
      if(letters[i] > 0) {
        List<Character> list = map.getOrDefault(letters[i], new ArrayList<>());
        list.add((char) i);
        map.put(letters[i], list);
      }

    StringBuilder sb = new StringBuilder();
    for(int j=l; j>0; --j) {
      List<Character> list = map.get(j);
      if(list != null) {
        for(Character c: list) {
          int tmp = j;
          while(tmp-- > 0) {
            sb.append(c);
          }
        }
        l -= list.size() * j;
        j = Math.min(j, l+1);
      }
    }
    return sb.toString();
  }
}
