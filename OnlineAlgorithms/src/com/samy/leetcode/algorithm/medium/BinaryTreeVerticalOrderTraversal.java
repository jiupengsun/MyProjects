package com.samy.leetcode.algorithm.medium;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

  /**
   * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
   * @param root
   * @return
   */
  public List<List<Integer>> verticalOrder(TreeNode root) {
    Queue<Tuple> que = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    if(root != null)
      que.add(new Tuple(0, root));
    int min = 0, max = 0;
    while(!que.isEmpty()) {
      Tuple t = que.poll();
      List<Integer> list = map.getOrDefault(t.id, new ArrayList<>());
      list.add(t.node.val);
      map.put(t.id, list);
      if(t.node.left != null) {
        que.add(new Tuple(t.id - 1, t.node.left));
        min = Math.min(t.id-1, min);
      }
      if(t.node.right != null) {
        que.add(new Tuple(t.id + 1, t.node.right));
        max = Math.max(t.id + 1, max);
      }
    }
    List<List<Integer>> result = new ArrayList<>();
    if (!map.isEmpty())
      for(int i=min; i<=max; ++i)
        result.add(map.get(i));
    return result;
  }

  class Tuple {
    int id;
    TreeNode node;
    Tuple(int i, TreeNode n) {
      id = i;
      node = n;
    }
  }
}
