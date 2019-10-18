package com.samy.leetcode.algorithm.medium;

import java.util.List;

public class ReplaceWords {

  Trie tree;

  public String replaceWords(List<String> dict, String sentence) {
    tree = new Trie();
    for (String d : dict) {
      tree.insert(d);
    }
    StringBuilder sb = new StringBuilder();
    String[] s = sentence.split(" ");
    for (String tmp : s) {
      String r = tree.isStartsWith(tmp);
      sb.append(r == null ? tmp : r);
      sb.append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  /**
   * https://leetcode.com/problems/replace-words/description/
   */
  class Trie {

    Node root;

    Trie() {
      root = new Node();
    }

    void insert(String s) {
      Node tmp = root;
      for (char c : s.toCharArray()) {
        int p = c - 'a';
        if (tmp.children == null) {
          tmp.children = new Node[26];
        }
        if (tmp.children[p] == null)
          tmp.children[p] = new Node();
        tmp = tmp.children[p];
      }
      tmp.cur = s;
    }

    String isStartsWith(String s) {
      Node tmp = root;
      for (char c : s.toCharArray()) {
        int p = c - 'a';
        if (tmp == null)
          return null;
        if (tmp.cur != null)
          return tmp.cur;
        if (tmp.children == null)
          return null;
        tmp = tmp.children[p];
      }
      return null;
    }

    class Node {
      String cur;
      Node[] children;
    }
  }
}
