package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samy on 10/30/16.
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
  int capacity;
  int currentSize;
  Map<Integer, Node> map;
  Node head, tail;
  public LRUCache(int capacity) {
    this.capacity = capacity;
    currentSize = 0;
    map = new HashMap<>(capacity);
    head = null;
    tail = null;
  }

  public int get(int key) {
    Node n = map.get(key);
    if (n == null)
      return -1;
    update(n);
    return n.value;
  }

  public void put(int key, int value) {
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
      n.next = head;
      head.prev = n;
      head = n;
      if (currentSize == capacity) {
        map.remove(tail.key);
        tail = tail.prev;
        tail.next = null;
      } else
        currentSize++;
    } else {
      n.value = value;
      update(n);
    }
  }

  private void update(Node n) {
    if (currentSize == 1 || head == n)
      return;

    n.prev.next = n.next;
    if (n.next != null)
      n.next.prev = n.prev;
    else
      tail = n.prev;
    n.prev = null;
    n.next = head;
    head.prev = n;
    head = n;
  }

  class Node {
    int key;
    int value;
    Node prev, next;

    Node(int k, int v) {
      key = k;
      value = v;
    }
  }
}
