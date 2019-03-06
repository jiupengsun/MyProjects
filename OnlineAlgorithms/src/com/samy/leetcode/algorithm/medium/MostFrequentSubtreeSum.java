package com.samy.leetcode.algorithm.medium;

import com.samy.datastructure.TreeNode;
import java.util.*;

public class MostFrequentSubtreeSum {
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    if(root == null)
      return new int[]{};
    helper(root, map);
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
      @Override
      public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
        return m2.getValue() - m1.getValue();
      }
    });
    int[] r = new int[list.size()];
    int i = 0, last = 0;
    for(; i<r.length; ++i) {
      int v = list.get(i).getValue();
      if(i==0 || v==last)
        r[i] = list.get(i).getKey();
      else
        break;
      last = v;
    }
    return Arrays.copyOf(r, i);
  }

  private int helper(TreeNode root, Map<Integer, Integer> map) {
    if(root == null)
      return 0;
    int left = helper(root.left, map);
    int right = helper(root.right, map);
    int sum = left + right + root.val;
    int count = map.getOrDefault(sum, 0);
    map.put(sum, count + 1);
    return sum;
  }
}
