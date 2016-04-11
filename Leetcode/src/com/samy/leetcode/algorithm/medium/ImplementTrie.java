package com.samy.leetcode.algorithm.medium;

public class ImplementTrie {
	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");

	/**
	 * 
	 * @param args
	 * Apr 11, 2016
	 * @author Jiupeng
	 * @description 14 test cases, 16ms beats 85.64%
	 * @reference 
	 * @interpretation
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie = new Trie();
		trie.insert("something");
		System.out.println(trie.search("some"));
		System.out.println(trie.search("something"));
		System.out.println(trie.search("key"));
		System.out.println(trie.startsWith("ana"));
		System.out.println(trie.startsWith("some"));

		Trie trie2 = new Trie();
		trie2.insert("abc");
		System.out.println(trie2.search("abc"));
		System.out.println(trie2.search("ab"));
		trie2.insert("ab");
		System.out.println(trie2.search("ab"));
		trie2.insert("ab");
		System.out.println(trie2.search("ab"));
	}
}

class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
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
