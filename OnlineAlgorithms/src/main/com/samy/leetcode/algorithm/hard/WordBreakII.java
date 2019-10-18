package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class WordBreakII {

  public static void main(String[] args) {
    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    String[] dict = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
    List<String> wordDict = new ArrayList<>();
    for (String ss : dict)
      wordDict.add(ss);
    WordBreakII wb = new WordBreakII();
    wb.wordBreak2(s, wordDict);
  }

  /**
   * https://leetcode.com/problems/word-break-ii/description/
   *
   * @param s
   * @param wordDict
   * @return
   */
  public List<String> wordBreak(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length()];
    for (int j = 0, size = s.length(); j < size; ++j) {
      for (int i = 0; i <= j; ++i) {
        String tmp = s.substring(i, j + 1);
        if (dict.contains(tmp) && (i == 0 || dp[i - 1])) {
          dp[j] = true;
          break;
        }
      }
    }
    if (!dp[s.length() - 1])
      return new ArrayList<>();
    Map<Integer, List<String>> map = new HashMap<>();
    for (int j = 0, size = s.length(); j < size; ++j) {
      List<String> list = new ArrayList<>();
      for (int i = 0; i <= j; ++i) {
        String tmp = s.substring(i, j + 1);
        if (dict.contains(tmp)) {
          if (i == 0) {
            list.add(tmp);
          } else if (map.containsKey(i - 1)) {
            List<String> l = map.get(i - 1);
            for (String ss : l) {
              list.add(ss + " " + tmp);
            }
          }
        }
      }
      if (list.size() > 0)
        map.put(j, list);
    }
    return map.getOrDefault(s.length() - 1, new ArrayList<>());
  }

  /**
   * using DFS, and use Map to prune
   *
   * @param s
   * @param wordDict
   * @return
   */
  public List<String> wordBreak2(String s, List<String> wordDict) {
    if (s.equals(""))
      return new ArrayList<>();
    return DFS(s, 0, wordDict, new HashMap<Integer, List<String>>());
  }

  private List<String> DFS(String s, int offset, List<String> wordDict, HashMap<Integer, List<String>> map) {
    List<String> list = new ArrayList<>();
    if (map.containsKey(offset))
      return map.get(offset);
    for (String d : wordDict) {
      if (s.startsWith(d, offset)) {
        if (offset + d.length() == s.length())
          list.add(d);
        else {
          List<String> l = DFS(s, offset + d.length(), wordDict, map);
          for (String ss : l) {
            list.add(d + " " + ss);
          }
        }
      }
    }
    map.put(offset, list);
    return list;
  }
}
