package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/k-similar-strings/">K-Similar Strings</a>
 */
// TODO not done
public class KSimilarStrings {
  private class Node {
    String val;
    int step;

    Node(String v, int s) {
      val = v;
      step = s;
    }
  }

  public int kSimilarity(String A, String B) {
    if (A.equals(B)) {
      return 0;
    }
    Queue<Node> leftQue = new LinkedList<>();
    Queue<Node> rightQue = new LinkedList<>();
    Map<String, Integer> leftVisit = new HashMap<>();
    Map<String, Integer> rightVisit = new HashMap<>();
    leftQue.add(new Node(A, 0));
    rightQue.add(new Node(B, 0));
    while(!leftQue.isEmpty() && !rightQue.isEmpty()) {
      // move a step from left
      Node leftNode = leftQue.poll();
      leftVisit.put(leftNode.val, leftNode.step);
      if (rightVisit.containsKey(leftNode.val)) {
        // find
        return leftNode.step + rightVisit.get(leftNode.val);
      }
      List<String> list = swapOne(leftNode.val);
      for (String next : list) {
        if (!leftVisit.containsKey(next)) {
          leftQue.add(new Node(next, leftNode.step+1));
        }
      }
      // move a step from right
      Node rightNode = rightQue.poll();
      rightVisit.put(rightNode.val, rightNode.step);
      if (leftVisit.containsKey(rightNode.val)) {
        // find
        return rightNode.step + leftVisit.get(rightNode.val);
      }
      list = swapOne(rightNode.val);
      for (String next : list) {
        if (!rightVisit.containsKey(next)) {
          rightQue.add(new Node(next, rightNode.step+1));
        }
      }
    }
    return -1;
  }

  private List<String> swapOne(String val) {
    char[] carray = val.toCharArray();
    List<String> l = new ArrayList<>();
    for (int i=0; i<carray.length-1; ++i) {
      for (int j=i+1; j<carray.length; ++j) {
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

  public static void main(String[] args) {
    KSimilarStrings k = new KSimilarStrings();
    System.out.println(k.kSimilarity("abcbca", "ababcc"));
  }
}
