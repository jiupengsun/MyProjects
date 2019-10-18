package com.samy.company.Airbnb;

import java.util.*;

public class Solution {

  /**
   * logs[i][0]: id
   * logs[i][1]: points
   *
   * @param logs
   * @return
   */
  public static List<List<Integer>> sort(int[] logs, int K) {

    // logs is sort by points
    int pages = logs.length % K == 0 ? logs.length / K : logs.length / K + 1;
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    for (int l : logs) {
      list.add(l);
    }

    while (!list.isEmpty() && result.size() < pages) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> tmpList = new ArrayList<>();
      int j = 0;
      for (int log : list) {
        // find unique list
        if (tmpList.size() == K)
          // has filled one page
          break;
        if (!map.containsKey(log)) {
          map.put(log, j);
          tmpList.add(log);
        }
        ++j;
      }

      if (!tmpList.isEmpty()) {
        result.add(tmpList);
        // remove
        for (int i = tmpList.size() - 1; i >= 0; --i) {
          list.remove((int) map.get(tmpList.get(i)));
        }
        if (tmpList.size() < K)
          break;
      }
    }

    while (result.size() < pages)
      result.add(new LinkedList<>());

    if (!list.isEmpty()) {
      // fill the remainder
      for (int i = 0; i < result.size() && !list.isEmpty(); ++i) {
        List<Integer> l = result.get(i);
        if (l.size() == K)
          continue;
        while (l.size() < K && !list.isEmpty()) {
          l.add(list.remove(0));
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = sort(new int[]{1, 1, 1, 2, 1, 3}, 1);
    for (List<Integer> l : list) {
      for (int i : l) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
