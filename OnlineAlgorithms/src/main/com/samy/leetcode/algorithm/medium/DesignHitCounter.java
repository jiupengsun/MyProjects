package com.samy.leetcode.algorithm.medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DesignHitCounter {
}


class HitCounter2 {
  Queue<Integer> que;
  int capacity;

  /**
   * Initialize your data structure here.
   */
  public HitCounter2(int c) {
    que = new LinkedList<>();
    capacity = c;
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    que.add(timestamp);
    int limit = Math.max(timestamp - capacity, 0);
    // remove head elements that smaller than limit
    while (que.peek() <= limit)
      que.poll();
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    return que.size();
  }
}

class HitCounter {
  TreeMap<Integer, Integer> map;
  int count = 0;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    map = new TreeMap<>();
  }

  public static void main(String[] args) {
    HitCounter hc = new HitCounter();
    hc.hit(2);
    hc.hit(3);
    hc.hit(4);
    hc.getHits(300);
    hc.getHits(301);
    hc.getHits(302);
    hc.getHits(303);
    hc.getHits(304);
    hc.hit(501);
    hc.getHits(600);
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    map.put(timestamp, ++count);
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    Integer c1 = map.get(timestamp);
    if (c1 == null) {
      Map.Entry<Integer, Integer> e = map.lowerEntry(timestamp);
      c1 = e == null ? 0 : e.getValue();
      map.put(timestamp, c1);
    }
    if (timestamp <= 300)
      return c1;
    Integer c2 = map.get(timestamp - 300);
    if (c2 == null) {
      Map.Entry<Integer, Integer> e = map.lowerEntry(timestamp - 300);
      c2 = e == null ? 0 : e.getValue();
      map.put(timestamp - 300, c2);
    }
    return c1 - c2;
  }
}
