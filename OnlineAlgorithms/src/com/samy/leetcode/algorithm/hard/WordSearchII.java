package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class WordSearchII {

  /**
   *
   * @param board
   * @param words
   * @return
   */
  int[][] direct = new int[][]{
    {-1,0}, {0,-1}, {1,0}, {0,1}
  };

  class Trie {
    String word;
    Map<Character, Trie> leaf;
  }

  private void insert(String word, Trie root) {
    Trie tmp = root;
    for(char c: word.toCharArray()) {
      if(tmp.leaf == null) {
        tmp.leaf = new HashMap<>();
      }
      Trie t = tmp.leaf.get(c);
      if(t == null) {
        t = new Trie();
        tmp.leaf.put(c, t);
      }
      tmp = t;
    }
    tmp.word = word;
  }


  public List<String> findWords(char[][] board, String[] words) {
    Trie root = new Trie();
    // Trie tree
    for(String w: words)
      insert(w, root);
    if(root.leaf == null)
      return new ArrayList<>();
    Set<String> set = new HashSet<>();
    boolean[][] visit = new boolean[board.length][board[0].length];
    for(int i=0; i<board.length; ++i) {
      for(int j=0; j<board[0].length; ++j) {
        if(root.leaf.containsKey(board[i][j])) {
          DFS(board, visit, new int[]{i, j}, root.leaf.get(board[i][j]), set);
        }
      }
    }
    return new ArrayList<>(set);
  }

  private void DFS(char[][] board, boolean[][] visit, int[] pos, Trie root, Set<String> set) {
    visit[pos[0]][pos[1]] = true;
    if(root.word != null) {
      set.add(root.word);
    }
    // check four directions
    if(root.leaf != null) {
      for(int[] d: direct) {
        int i = Math.max(0, Math.min(pos[0]+d[0], board.length-1));
        int j = Math.max(0, Math.min(pos[1]+d[1], board[0].length-1));
        if(!visit[i][j] && root.leaf.containsKey(board[i][j])) {
          DFS(board, visit, new int[]{i, j}, root.leaf.get(board[i][j]), set);
        }
      }
    }
    visit[pos[0]][pos[1]] = false;
  }

  public static void main(String[] args) {
    char[][] board = new char[][]{
      {'o','a','a','n'},
      {'e','t','a','e'},
      {'i','h','k','r'},
      {'i','f','l','v'}
    };
    String[] words = new String[]{"oath","pea","eat","rain"};
    WordSearchII ws = new WordSearchII();
    ws.findWords(board, words);
  }
}
