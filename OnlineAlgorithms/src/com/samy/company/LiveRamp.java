package com.samy.company;

import com.samy.leetcode.algorithm.medium.Trie;

import java.util.*;

/**
 * Created by samy on 11/4/16.
 */
public class LiveRamp {

  /**
   * max subsequence which could be not continuous
   * use sort
   * @param n
   * @return
   */
  public static int max_subsequence(int[] n) {
    if (n == null || n.length == 0)
      return 0;
    Arrays.sort(n);
    int max = 1;
    for(int i=1, j=0, l=1; i<n.length; ++i) {
      if(n[i] - n[j] <= 1)
        ++l;
      else {
        max = Math.max(max, l);
        while(n[i] - n[j] > 1)
          ++j;
        l = i - j + 1;
      }
    }
    return max;
  }

  /**
   * using hashMap
   * @param n
   * @return
   */
  public static int max_subsequence2(int[] n) {
    if (n==null || n.length==0)
      return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : n) {
      Integer times = map.get(i);
      times = times == null ? 1 : times+1;
      map.put(i, times);
    }

    int max = 0;
    Iterator<Integer> it = map.keySet().iterator();
    while(it.hasNext()) {
      int i = it.next();
      Integer iplus = map.get(i+1);
      iplus = iplus == null ? 0 : iplus;
      max = Math.max(max, map.get(i) + iplus);
    }

    return max;
  }

  /**
   * count number of nodes that has distance d with capital
   * @param n a undirected map, if map[x] = x, means capital
   * @param distance distance with capital
   * @return
   */
  public static int countDistance(int[] n, int distance) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int capital = -1;
    // construct map
    for(int i=0; i<n.length; ++i) {
      if (n[i] == i)
        capital = i;
      List<Integer> edge = map.get(i);
      if (edge == null) {
        edge = new ArrayList<>();
      }
      edge.add(n[i]);
      map.put(i, edge);
    }

    Stack<Integer[]> stack = new Stack<>();
    boolean[] isvisited = new boolean[n.length];
    stack.push(new Integer[]{capital, distance});
    int count = 0;
    while(!stack.isEmpty()) {
      Integer[] node = stack.pop();
      if (!isvisited[node[0]]) {
        isvisited[node[0]] = true;
      }
      if (node[1] == 0) {
        ++count;
        continue;
      }
      else {
        List<Integer> edge = map.get(node[0]);
        if (edge != null) {
          for (int e : edge) {
            stack.push(new Integer[]{e, node[1] - 1});
          }
        }
      }
    }
    return count;
  }


  /**
   * given a dictionary and a N*N matrix with characters
   * find a bag of words that could be formed with a continuous characters
   * in dictionary
   * @param m
   * @param dict
   * @return
   */
  public static Set<String> wordSearch(char[][] m, Set<String> dict) {
    // build a trie tree
    Trie tree = new Trie();
    Iterator<String> it = dict.iterator();
    while(it.hasNext()) {
      tree.insert(it.next());
    }

    List<Character> list = new ArrayList<Character>();
    Set<String> words = new HashSet<>();
    for(int i=0; i<m.length; ++i) {
      for(int j=0; j<m[i].length; ++j) {
        // if this char is a start of a word
        if(tree.startsWith(String.valueOf(m[i][j]))) {
          Set<String> find = DFS_wordSearch(m, i, j, tree);
          for (String s : find) {
            // add into word bag
            words.add(s);
            // remove the used word, no need to
            // search them any more in future work
          }
          if (tree.isEmpty())
            break;
        }
      }
    }
    return words;
  }

  /**
   * using dfs to search word
   * @param m
   * @param i
   * @param j
   * @param tree
   * @return
   */
  private static Set<String> DFS_wordSearch(char[][] m, int i, int j, Trie tree) {
    // store trace
    Stack<Tuple> pos = new Stack<>();
    // store worda
    Set<String> wordSet = new HashSet<>();
    // store visited position
    Set<String> hasVisited = new HashSet<>();

    pos.push(new Tuple("", i, j));
    while(! pos.isEmpty()) {
      Tuple t = pos.pop();
      i=t.i;
      j=t.j;
      if(hasVisited.add(i + " " + j)) {
        String word = t.prefix + m[i][j];
        // hasn't visited this pos
        if (tree.startsWith(word)) {
          if (tree.search(word)) {
            // find a word
            wordSet.add(word);
            // trim the tree
            tree.delete(word);
            if (tree.isEmpty())
              break;
          }
          // go on search
          // find next pos
          if (j>0)
            pos.push(new Tuple(word, i, j-1));
          if (i>0)
            pos.push(new Tuple(word, i-1, j));
          if (j<m[0].length - 1)
            pos.push(new Tuple(word, i, j+1));
          if (i<m.length - 1)
            pos.push(new Tuple(word, i+1, j));
        }
      }
    }
    return wordSet;
  }

  private static class Tuple {
    String prefix;
    int i;
    int j;
    Tuple(String p, int m, int n) {
      prefix = p;
      i = m;
      j = n;
    }
  }

  private static void BFS_wordSearch(char[][] m, int i, int j, Set<String> visited,
                                     Trie tree, String prefix, Set<String> words) {
    String w = prefix + m[i][j];
    if (tree.search(w))
      words.add(w);
    // bfs
    if(j > 0) {
      if(visited.add(i + " " + (j-1)) && tree.startsWith(w))
        BFS_wordSearch(m, i, j-1, visited, tree, w, words);
    }
    if(i > 0) {
      if(visited.add((i-1) + " " + j) && tree.startsWith(w))
        BFS_wordSearch(m, i-1, j, visited, tree, w, words);
    }
    if(j < m[0].length - 1) {
      if(visited.add(i + " " + (j+1)) && tree.startsWith(w))
        BFS_wordSearch(m, i, j+1, visited, tree, w, words);
    }
    if(i < m.length - 1) {
      if(visited.add((i+1) + " " + j) && tree.startsWith(w))
        BFS_wordSearch(m, i+1, j, visited, tree, w, words);
    }
  }


  private static class TestCase {
    static void test_Max_subsequence() {
      int[] n = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
      assert LiveRamp.max_subsequence2(n) == 5;
    }

    static void test_wordSearch(){
      Set<String> dict = new HashSet<>();
      dict.add("word");
      dict.add("news");
      dict.add("newspaper");
      dict.add("apple");
      char[][] m = new char[][]{
          {'a','b','o','r','d','c','d','e'},
          {'n','e','w','s','f','g','l','e'},
          {'h','i','j','p','a','p','p','k'},
          {'l','m','n','o','p','e','r','s'},
          {'t','u','v','w','x','r','y','z'}
      };
      Set<String> find = wordSearch(m, dict);
      for(String s : dict) {
        assert find.contains(s);
      }
    }
  }

  public static void main(String[] args) {
    //TestCase.test_Max_subsequence();
    TestCase.test_wordSearch();
  }
}
