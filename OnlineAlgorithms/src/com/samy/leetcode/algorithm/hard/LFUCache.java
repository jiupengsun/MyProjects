package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/description/
 * <p>
 * right now this isn't an O(1) solution
 * could refer to https://discuss.leetcode.com/topic/69137/java-o-1-accept-solution-using-hashmap-doublelinkedlist-and-linkedhashset
 * which is an O(1) solution by using LinkedHashMap
 */
public class LFUCache {
  int capacity;
  int currentSize;
  Map<Integer, Node> map;
  Node head, tail;
  public LFUCache(int capacity) {
    this.capacity = capacity;
    currentSize = 0;
    map = new HashMap<>(capacity);
  }

  public int get(int key) {
    Node n = map.get(key);
    if (n == null)
      return -1;
    n.count++;
    compare(n);
    return n.value;
  }

  public void put(int key, int value) {
    if (capacity == 0)
      return;
    Node n = map.get(key);
    if (n == null) {
      n = new Node(key, value);
      map.put(key, n);
      if (head == null) {
        head = n;
        tail = n;
        currentSize++;
        return;
      }
      if (currentSize == capacity) {
        map.remove(tail.key);
        if (head == tail) {
          head = n;
          tail = n;
          return;
        }
        tail.prev.next = n;
        n.prev = tail.prev;
        tail = n;
      } else {
        currentSize++;
        tail.next = n;
        n.prev = tail;
        tail = n;
      }
    } else {
      n.count++;
      n.value = value;
    }
    compare(n);
  }

  private void compare(Node n) {
    if (head == n)
      return;
    Node tmp = n;
    while (tmp != null && tmp.count <= n.count)
      tmp = tmp.prev;
    if (tmp == null) {
      // n should be put on head
      n.prev.next = n.next;
      if (n.next != null) {
        n.next.prev = n.prev;
      } else
        tail = n.prev;
      n.next = head;
      head.prev = n;
      n.prev = null;
      head = n;
    } else {
      // n should be put after tmp
      if (tmp.next == n)
        return;
      n.prev.next = n.next;
      if (n.next != null) {
        n.next.prev = n.prev;
      } else
        tail = n.prev;
      n.prev = tmp;
      n.next = tmp.next;
      n.next.prev = n;
      tmp.next = n;
    }
  }

  class Node {
    int key;
    int value;
    int count;
    Node prev, next;

    Node(int k, int v) {
      key = k;
      value = v;
      count = 1;
    }
  }
}
