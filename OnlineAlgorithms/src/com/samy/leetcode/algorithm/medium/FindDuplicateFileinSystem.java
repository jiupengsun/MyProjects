package com.samy.leetcode.algorithm.medium;

import java.io.File;
import java.util.*;

public class FindDuplicateFileinSystem {

  public static void main(String[] args) {
    // these two string have same hashcode
    System.out.println("FB".hashCode());
    System.out.println("Ea".hashCode());
  }

  /**
   * https://leetcode.com/problems/find-duplicate-file-in-system/description/
   *
   * @param paths
   * @return
   */
  public List<List<String>> findDuplicate(String[] paths) {
    Map<Integer, Map<String, List<String>>> map = new HashMap<>();
    for (String p : paths) {
      String[] arr = p.split(" ");
      for (int i = 1; i < arr.length; ++i) {
        int pos = arr[i].indexOf("(");
        String name = arr[i].substring(0, pos);
        String content = arr[i].substring(pos + 1, arr[i].length() - 1);
        Map<String, List<String>> subMap = map.getOrDefault(content.length(), new HashMap<>());
        List<String> list = subMap.getOrDefault(content, new ArrayList<>());
        // add path
        list.add(arr[0] + "/" + name);
        subMap.put(content, list);
        map.put(content.length(), subMap);
      }

    }

    List<List<String>> list = new LinkedList<>();
    for (Map<String, List<String>> m : map.values()) {
      for (List<String> l : m.values()) {
        if (l.size() > 1)
          list.add(l);
      }
    }
    return list;
  }

  public List<List<String>> findDuplicate(String rootPath) {
    List<List<String>> result = new LinkedList<>();
    Map<Long, Map<Integer, List<String>>> map = new HashMap<>();
    BFS(rootPath, map);
    // put into list
    for (Map<Integer, List<String>> values : map.values()) {
      for (Map.Entry<Integer, List<String>> entry : values.entrySet()) {
        result.add(entry.getValue());
      }
    }
    return result;
  }

  private void BFS(String rootPath, Map<Long, Map<Integer, List<String>>> map) {
    Queue<File> que = new LinkedList<>();
    Set<String> visit = new HashSet<>();
    que.add(new File(rootPath));
    while (!que.isEmpty()) {
      File directory = que.poll();
      visit.add(directory.getAbsolutePath());
      File[] files = directory.listFiles();
      for (File f : files) {
        if (f.isDirectory() && !visit.contains(f.getAbsolutePath())) {
          que.add(f);
        } else {
          // f is file, then compare
          Map<Integer, List<String>> subMap = map.getOrDefault(f.length(), new HashMap<>());
        }
      }
    }
  }
}
