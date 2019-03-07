package com.samy.datastructure;


import java.util.Stack;

class TrieNode {
  boolean stop;
  TrieNode[] branches = new TrieNode[26];
}

public class Trie {
  private TrieNode root = new TrieNode();
  private boolean isEmpty = false;

  public Trie() {
  }

  public boolean isEmpty() {
    return this.isEmpty;
  }

  public void insert(String word) {
    TrieNode father = this.root;
    int i = 0;

    for(int l = word.length(); i < l; ++i) {
      char c = word.charAt(i);
      TrieNode child = father.branches[c - 97];
      if (child == null) {
        child = new TrieNode();
        father.branches[c - 97] = child;
      }

      father = child;
    }

    father.stop = true;
    this.isEmpty = false;
  }

  public boolean search(String word) {
    TrieNode father = this.root;
    int i = 0;

    for(int l = word.length(); i < l; ++i) {
      char c = word.charAt(i);
      if (father.branches[c - 97] == null) {
        return false;
      }

      father = father.branches[c - 97];
    }

    return father.stop;
  }

  public boolean startsWith(String prefix) {
    TrieNode father = this.root;
    int i = 0;

    for(int l = prefix.length(); i < l; ++i) {
      char c = prefix.charAt(i);
      if (father.branches[c - 97] == null) {
        return false;
      }

      father = father.branches[c - 97];
    }

    return true;
  }

  public void delete(String word) {
    Stack<TrieNode> stack = new Stack();
    TrieNode father = this.root;
    char[] array = word.toCharArray();
    char[] var5 = array;
    int var6 = array.length;

    for(int var7 = 0; var7 < var6; ++var7) {
      char c = var5[var7];
      if (father.branches[c - 97] == null) {
        return;
      }

      stack.push(father);
      father = father.branches[c - 97];
    }

    father.stop = false;

    for(int i = array.length - 1; i >= 0; --i) {
      father = (TrieNode)stack.pop();
      if (this.isFreeNode(father.branches[array[i] - 97])) {
        father.branches[array[i] - 97] = null;
      }
    }

    this.isEmpty = this.isFreeNode(this.root);
  }

  private boolean isFreeNode(TrieNode node) {
    if (node == null) {
      return true;
    } else {
      TrieNode[] var2 = node.branches;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
        TrieNode child = var2[var4];
        if (child != null) {
          return false;
        }
      }

      return true;
    }
  }
}