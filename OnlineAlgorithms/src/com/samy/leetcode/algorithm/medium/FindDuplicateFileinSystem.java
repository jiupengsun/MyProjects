package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class FindDuplicateFileinSystem {

  /**
   * https://leetcode.com/problems/find-duplicate-file-in-system/description/
   * @param paths
   * @return
   */
  public List<List<String>> findDuplicate(String[] paths) {
    Map<Integer, Map<String, List<String>>> map = new HashMap<>();
    for(String p: paths) {
      String[] arr = p.split(" ");
      for(int i=1; i<arr.length; ++i) {
        int pos = arr[i].indexOf("(");
        String name = arr[i].substring(0, pos);
        String content = arr[i].substring(pos+1, arr[i].length()-1);
        Map<String, List<String>> subMap = map.getOrDefault(content.length(), new HashMap<>());
        List<String> list = subMap.getOrDefault(content, new ArrayList<String>());
        // add path
        list.add(arr[0] + "/" + name);
        subMap.put(content, list);
        map.put(content.length(), subMap);
      }

    }

    List<List<String>> list = new LinkedList<>();
    for(Map<String, List<String>> m: map.values()) {
      for(List<String> l: m.values()) {
        if(l.size() > 1)
          list.add(l);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    // these two string have same hashcode
    System.out.println("FB".hashCode());
    System.out.println("Ea".hashCode());
  }
}
