package com.samy.company.Linkedin;

import java.util.*;

abstract class MonitorSystem {

  MonitorSystem(int hours) {
  }

  abstract void log(String exception, long timestamp);

  abstract List<String> top(int number);
}

/**
 * assume we frequently call log methods
 * but barely call top
 * so we provide a O(1) log and O(N + mlogm) top,
 * where n is the number of total logs
 * m is the number of distint logs
 */
class Monitor extends MonitorSystem {

  Map<String, Integer> map;
  Queue<Node> que;
  long intervalByMs;
  Monitor(int hours) {
    super(hours);
    intervalByMs = hours * 24 * 60 * 3600 * 1000;
  }

  @Override
  void log(String exception, long timestamp) {
    map.put(exception, map.getOrDefault(exception, 0) + 1);
    que.add(new Node(exception, timestamp));
  }

  @Override
  List<String> top(int number) {
    long start = System.currentTimeMillis() - intervalByMs;
    while (!que.isEmpty() && que.peek().timestamp <= start) {
      Node n = que.poll();
      Integer count = map.get(n.message);
      if (--count == 0)
        map.remove(n.message);
      else
        map.put(n.message, count);
    }
    // sort
    List<Map.Entry<String, Integer>> l = new ArrayList<>(map.entrySet());
    l.sort((o1, o2) -> o2.getValue() - o1.getValue());
    List<String> list = new ArrayList<>(500);
    for (int i = 0, j = Math.min(500, l.size()); i < j; ++i)
      list.add(l.get(i).getKey());
    return list;
  }

  class Node {
    String message;
    long timestamp;

    Node(String s, long t) {
      message = s;
      timestamp = t;
    }
  }
}

/**
 * follower up on first problem, the system usage still keeps
 * high frequent log and low frequent top operation
 * if the request doesn't need to be too precise recorded,
 * let's say, we only need to focus on minutes level precision
 * then 24 hours is 24*60=860
 * we can use a fixed size array, each array contains a set that
 * contains message and its count
 */
class Monitor2 extends MonitorSystem {
  Map<Integer, Map<String, Integer>> map;
  Map<String, Integer> sumMap;
  int[] minuteArray;
  int maxMinutes;

  Monitor2(int hours) {
    super(hours);
    maxMinutes = hours * 60;
    map = new HashMap<>();
    minuteArray = new int[maxMinutes];
  }

  /**
   * O(1)
   *
   * @param exception
   * @param timestamp
   */
  @Override
  void log(String exception, long timestamp) {
    // million seconds to minutes
    int minutes = (int) (timestamp / 3600000);
    int index = minutes % maxMinutes;
    if (minuteArray[index] == minutes) {
      // same timestamp
      Map<String, Integer> ele = map.get(exception);
      ele.put(exception, ele.getOrDefault(ele, 0) + 1);
    } else {
      // new timestamp
      map.remove(minuteArray[index]);
      minuteArray[index] = minutes;
      Map<String, Integer> ele = new HashMap<>();
      ele.put(exception, 1);
      map.put(minutes, ele);
    }
  }

  /**
   * O(N) where N is the number of distinct string in past 500
   *
   * @param number
   * @return
   */
  @Override
  List<String> top(int number) {
    int minutes = (int) (System.currentTimeMillis() / 3600000 - maxMinutes);
    Map<String, Integer> sumMap = new HashMap<>();
    for (int i : minuteArray) {
      if (i > minutes) {
        Map<String, Integer> ele = map.get(i);
        if (ele != null) {
          for (Map.Entry<String, Integer> m : ele.entrySet()) {
            sumMap.put(m.getKey(), sumMap.getOrDefault(m.getKey(), 0) + m.getValue());
          }
        }
      }
    }
    // use priorityQueue to save top k
    PriorityQueue<Map.Entry<String, Integer>> que = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

    List<Map.Entry<String, Integer>> l = new ArrayList<>(sumMap.entrySet());
    // if size of l is much larger than 500
    // than we can use heap sort, which is O(nlogk) where k equals 500
    l.sort((e1, e2) -> e2.getValue() - e1.getValue());
    List<String> list = new ArrayList<>(500);
    for (int i = 0, j = Math.min(500, l.size()); i < j; ++i) {
      list.add(l.get(i).getKey());
    }
    return list;
  }
}

