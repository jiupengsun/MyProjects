package com.samy.leetcode.algorithm.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * Created by samy on 11/9/16.
 */
public class WordLadder {

  /**
   * https://leetcode.com/problems/word-ladder/description/
   * @param beginWord
   * @param endWord
   * @param wordList
   * @return
   * bio-direction BFS
   */
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int path = 0;
    Set<String> dict = new HashSet<>(wordList);
    Set<String> leftVisit = new HashSet<>();
    Set<String> left = new HashSet<>();
    Set<String> rightVisit = new HashSet<>();
    Set<String> right = new HashSet<>();
    left.add(beginWord);
    leftVisit.add(beginWord);
    if(dict.contains(endWord)) {
      right.add(endWord);
      rightVisit.add(endWord);
    }
    // true means left, false means right
    boolean turn = true;
    while(!left.isEmpty() && !right.isEmpty()) {
      ++path;
      Set<String> from, to, visit;
      if(turn) {
        // check left
        from = left;
        to = right;
        visit = leftVisit;
      } else {
        from = right;
        to = left;
        visit = rightVisit;
      }
      for(String s: from) {
        if(to.contains(s))
          return path;
      }
      // find next path
      findPath(visit, from, dict);
      turn = !turn;
    }
    return 0;
  }

  private void findPath(Set<String> visit, Set<String> from, Set<String> dict) {
    HashSet<String> tmp = new HashSet<>(from);
    from.clear();
    for(String s: tmp) {
      char[] array = s.toCharArray();
      for(int i=0; i<array.length; ++i) {
        for(char c='a'; c<='z'; ++c) {
          if(c == array[i])
            continue;
          char t = array[i];
          array[i] = c;
          String n = new String(array);
          if(dict.contains(n) && visit.add(n)) {
            from.add(n);
          }
          array[i] = t;
        }
      }
    }
  }
}
