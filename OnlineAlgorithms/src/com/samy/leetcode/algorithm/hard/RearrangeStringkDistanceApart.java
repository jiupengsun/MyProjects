package com.samy.leetcode.algorithm.hard;

import java.util.*;

public class RearrangeStringkDistanceApart {

  /**
   * https://leetcode.com/problems/rearrange-string-k-distance-apart/description/
   * @param s
   * @param k
   * @return
   * @reference: https://discuss.leetcode.com/topic/48109/java-7-version-of-priorityqueue-o-nlogn-with-comments-and-explanations
   */
  public String rearrangeString(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c: s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> que = new PriorityQueue<>(
      new Comparator<Map.Entry<Character, Integer>>(){
        @Override
        public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
          if(m1.getValue() != m2.getValue())
            return m2.getValue() - m1.getValue();
          return m1.getKey() - m2.getKey();
        }
      });
    que.addAll(map.entrySet());

    Queue<Map.Entry<Character, Integer>> replaceQue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    while(!que.isEmpty()) {
      Map.Entry<Character, Integer> e = que.poll();
      sb.append(e.getKey());
      e.setValue(e.getValue() - 1);
      replaceQue.add(e);

      if(replaceQue.size() < k)
        continue;

      Map.Entry<Character, Integer> old = replaceQue.poll();
      if(old.getValue() > 0)
        que.add(old);
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }

  public static void main(String[] args) {
    RearrangeStringkDistanceApart rs = new RearrangeStringkDistanceApart();
    System.out.println(rs.rearrangeString("aabbcc", 3));
  }
}
