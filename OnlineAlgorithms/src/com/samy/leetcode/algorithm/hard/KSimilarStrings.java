package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/k-similar-strings/">K-Similar Strings</a>
 */
public class KSimilarStrings {
  public static void main(String[] args) {
    KSimilarStrings k = new KSimilarStrings();
    System.out.println(k.kSimilarity("abcbca", "ababcc"));
  }

  public int kSimilarity(String A, String B) {
    return prunedBFS(A, B);
  }

  /**
   * refer to: https://leetcode.com/problems/k-similar-strings/discuss/340772/Simple-Java-BFS-Solution
   */
  public int prunedBFS(String A, String B) {
    Queue<String> que = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    int count = 0;
    que.add(A);
    while (!que.isEmpty()) {
      int size = que.size();
      for (int s = 0; s < size; ++s) {
        String current = que.poll();
        if (current.equals(B)) return count;
        visited.add(current);
        int i = 0;
        while (current.charAt(i) == B.charAt(i)) i++;
        for (int j = i + 1; j < A.length(); ++j) {
          if (current.charAt(j) == B.charAt(i)) {
            // do swap
            String A_new = swap(current, i, j);
            if (!visited.contains(A_new)) que.add(A_new);
          }
        }
      }
      ++count;
    }
    return -1;
  }

  /**
   * Bidirectional BFS, O(b^(d/2))
   */
  @Deprecated
  public int BiBFS(String A, String B) {
    if (A.equals(B)) {
      return 0;
    }
    Queue<Node> leftQue = new LinkedList<>();
    Queue<Node> rightQue = new LinkedList<>();
    Map<String, Integer> leftVisit = new HashMap<>();
    Map<String, Integer> rightVisit = new HashMap<>();
    leftQue.add(new Node(A, 0));
    rightQue.add(new Node(B, 0));
    while (!leftQue.isEmpty() && !rightQue.isEmpty()) {
      Queue<Node> newQue = new LinkedList<>();
      // move a step from left
      Node leftNode = null;
      while (!leftQue.isEmpty()) {
        leftNode = leftQue.remove();
        leftVisit.put(leftNode.val, leftNode.step);
        for (String next : swapOne(leftNode.val)) {
          if (!leftVisit.containsKey(next)) {
            if (rightVisit.containsKey(next)) {
              return leftNode.step + rightVisit.get(next) + 1;
            }
            newQue.add(new Node(next, leftNode.step + 1));
          }
        }
      }
      leftQue = newQue;

      // move a step from right
      newQue = new LinkedList<>();
      while (!rightQue.isEmpty()) {
        Node rightNode = rightQue.remove();
        rightVisit.put(rightNode.val, rightNode.step);
        for (String next : swapOne(rightNode.val)) {
          if (!rightVisit.containsKey(next)) {
            if (leftVisit.containsKey(next)) {
              // find
              return rightNode.step + leftVisit.get(next) + 1;
            }
            newQue.add(new Node(next, rightNode.step + 1));
          }
        }
      }
      rightQue = newQue;
    }
    return -1;
  }

  /**
   * BFS, O(b^d)
   */
  @Deprecated
  private int BFS(String A, String B) {
    Queue<Node> que = new LinkedList<>();
    Map<String, Integer> visited = new HashMap<>();
    que.add(new Node(A, 0));
    while (!que.isEmpty()) {
      Node node = que.poll();
      visited.put(node.val, node.step);
      for (String next : swapOne(node.val)) {
        if (next.equals(B)) {
          // find
          return node.step + 1;
        }
        if (!visited.containsKey(next)) {
          que.add(new Node(next, node.step + 1));
        }
      }
    }
    return -1;
  }

  @Deprecated
  private List<String> swapOne(String val) {
    char[] carray = val.toCharArray();
    List<String> l = new ArrayList<>();
    for (int i = 0; i < carray.length - 1; ++i) {
      for (int j = i + 1; j < carray.length; ++j) {
        if (carray[i] != carray[j]) {
          swap(carray, i, j);
          l.add(String.valueOf(carray));
          swap(carray, i, j);
        }
      }
    }
    return l;
  }

  private void swap(char[] carray, int i, int j) {
    char c = carray[i];
    carray[i] = carray[j];
    carray[j] = c;
  }

  private String swap(String s, int i, int j) {
    char[] carray = s.toCharArray();
    char c = carray[i];
    carray[i] = carray[j];
    carray[j] = c;
    return String.valueOf(carray);
  }

  private class Node {
    String val;
    int step;

    Node(String v, int s) {
      val = v;
      step = s;
    }
  }
}
