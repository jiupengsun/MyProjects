package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samy on 10/30/16.
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

  private class Block {
    Block(int key, int value){
      this.key = key;
      this.value = value;
    }
    int key;
    int value;
    Block prev;
    Block next;
  }

  private Block head;
  private Block tail;
  private int max_capacity;
  private int current_capacity;
  private Map<Integer, Block> cacheMap;

  public LRUCache(int capacity) {
    if (capacity > 0) {
      this.max_capacity = capacity;
      this.current_capacity = 0;
      cacheMap = new HashMap<>(capacity);
    }
  }

  public int get(int key) {
    Block node = cacheMap.get(key);
    if (node == null)
      return -1;
    updateNode(node);
    return node.value;
  }

  private Block getNode(int key) {
    Block b = head;
    while(b!=null && b.key!=key)
      b = b.next;
    // not found
    if(b != null) {
      // using LRU
      updateNode(b);
    }
    return b;
  }

  public void set(int key, int value) {
    Block node = cacheMap.get(key);
    if (node != null) {
      node.value = value;
      cacheMap.put(key, node);
      updateNode(node);
      return;
    }
    if (current_capacity < max_capacity) {
      this.current_capacity++;
      node = new Block(key, value);
      if (head == null) {
        // empty list
        head = node;
        tail = node;
      } else {
        head.prev = node;
        node.next = head;
        head = node;
      }
      cacheMap.put(key, node);
    } else if(current_capacity == max_capacity) {
      // reach the maximum size
      // then evict tail node
      cacheMap.remove(tail.key);
      tail.key = key;
      tail.value = value;
      cacheMap.put(key, tail);
      updateNode(tail);
    }

  }

  /**
   * when using a node, update it by inserting
   * it before the head, and update the head and tail
   * @param node
   */
  private void updateNode(Block node) {
    if(node == head)
      // no need to update
      return;
    if(node == tail && tail.prev != null) {
      // more than one node
      // update tail
      Block tt = tail.prev;
      tt.next = null;
      tail.prev = null;
      tail.next = head;
      head.prev = tail;
      head = tail;
      tail = tt;
      return;
    }
    // not head or tail
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = null;
    node.next = head;
    head.prev = node;
    head = node;
  }

}
