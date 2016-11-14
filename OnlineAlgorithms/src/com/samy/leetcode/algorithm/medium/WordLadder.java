package com.samy.leetcode.algorithm.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * Created by samy on 11/9/16.
 */
public class WordLadder {

  private final char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
      'p','q','r','s','t','u','v','w','x','y','z'};

  public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    Set<String> visited1 = new HashSet<>();
    Set<String> visited2 = new HashSet<>();
    Set<String> layer1 = new HashSet<>();
    Set<String> layer2 = new HashSet<>();
    layer1.add(beginWord);
    layer2.add(endWord);
    int depth = 0;
    while(layer1.size()>0 && layer2.size()>0) {
      // start from begin
      Iterator<String> ita = layer1.iterator();
      // clear the formal layer
      layer1 = new HashSet<>();
      while(ita.hasNext()) {
        String word = ita.next();
        if(visited2.contains(word)) {
          // meet in middle
          return depth;
        }
        // add into visited set
        visited1.add(word);
        // add new layer
        Iterator<String> it = getNext(word, wordList).iterator();
        while(it.hasNext()) {
          String w = it.next();
          if(!visited1.contains(w))
            // if not visited yet
            // add to next layer
            layer1.add(w);
        }
      }
      ++depth;
      // not found from the left side
      // then search in the right side
      ita = layer2.iterator();
      layer2 = new HashSet<>();
      while(ita.hasNext()) {
        String word = ita.next();
        if(visited1.contains(word)) {
          return depth;
        }
        // add into visited set
        visited2.add(word);
        // add new layer
        Iterator<String> it = getNext(word, wordList).iterator();
        while(it.hasNext()) {
          String w = it.next();
          if(!visited2.contains(w))
            layer2.add(w);
        }
      }
      ++depth;
    }
    return depth;
  }


  /**
   * find adjacent word
   * @param word
   * @return
   */
  private Set<String> getNext(String word, Set<String> dict) {
    Set<String> set = new HashSet<>();
    char[] letter = word.toCharArray();
    for(int i=0; i<letter.length; ++i) {
      char tmp = letter[i];
      for(char c : letters) {
        if(c == tmp)
          continue;
        letter[i] = c;
        String nw = new String(letter);
        if(dict.contains(nw))
          set.add(nw);
      }
      letter[i] = tmp;
    }
    return set;
  }

  public static void main(String[] args) {
    Set<String> dict = new HashSet<>();
    dict.add("ted");
    dict.add("tex");
    dict.add("red");
    dict.add("tax");
    dict.add("tad");
    dict.add("den");
    dict.add("rex");
    dict.add("pee");
    String beginWord = "red";
    String endWord = "tax";
    WordLadder wl = new WordLadder();
    System.out.println(wl.ladderLength(beginWord, endWord, dict));
  }
}
