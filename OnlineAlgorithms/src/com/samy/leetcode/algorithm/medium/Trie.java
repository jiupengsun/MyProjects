package com.samy.leetcode.algorithm.medium;

import java.util.Stack;


public class Trie {

	private TrieNode root;
  private boolean isEmpty;

	public Trie() {
		root = new TrieNode();
    isEmpty = false;
	}

	public boolean isEmpty() {
    return isEmpty;
  }
	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode father = root;
		for (int i = 0, l = word.length(); i < l; ++i) {
			char c = word.charAt(i);
			TrieNode child = father.branches[c - 'a'];
			if (child == null) {
				child = new TrieNode();
				father.branches[c - 'a'] = child;
			}
			father = child;
		}
		father.stop = true;
    isEmpty = false;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode father = root;
		for (int i = 0, l = word.length(); i < l; ++i) {
			char c = word.charAt(i);
			if (father.branches[c - 'a'] == null)
				return false;
			father = father.branches[c - 'a'];
		}
		return father.stop;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode father = root;
		for (int i = 0, l = prefix.length(); i < l; ++i) {
			char c = prefix.charAt(i);
			if (father.branches[c - 'a'] == null)
				return false;
			father = father.branches[c - 'a'];
		}
		return true;
	}

	/**
	 * delete a specific word
	 * @param word
	 */
	public void delete(String word) {
		Stack<TrieNode> stack = new Stack<>();
		TrieNode father = root;
    char[] array = word.toCharArray();
		for(char c : array) {
			if (father.branches[c - 'a'] == null)
				return;
			stack.push(father);
			father = father.branches[c - 'a'];
		}
		father.stop = false;

    // delete route that has no available children
    for(int i=array.length - 1; i>=0; --i) {
      father = stack.pop();
      if (isFreeNode(father.branches[array[i] - 'a']))
        // no branches, then delete the whole branch
        father.branches[array[i] - 'a'] = null;
    }

    isEmpty = isFreeNode(root);
	}

	private boolean isFreeNode(TrieNode node) {
    if (node == null)
      return true;
    for(TrieNode child : node.branches) {
      if (child != null)
        return false;
    }
    return true;
  }

}

class TrieNode {
	// Initialize your data structure here.
	private final static int CHILDREN_NUMBER = 26;
	boolean stop = false;
	TrieNode[] branches;

	public TrieNode() {
		branches = new TrieNode[TrieNode.CHILDREN_NUMBER];
	}
}
