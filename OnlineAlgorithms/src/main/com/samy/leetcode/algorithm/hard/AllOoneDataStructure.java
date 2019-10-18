package com.samy.leetcode.algorithm.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-oone-data-structure/description/
 */
public class AllOoneDataStructure {
}

class AllOne {
  Bucket head, tail;
  Map<Integer, Bucket> bkMap;
  Map<String, Bucket> keyMap;
  /**
   * Initialize your data structure here.
   */
  public AllOne() {
    bkMap = new HashMap<>();
    keyMap = new HashMap<>();
  }

  public static void main(String[] args) {
    AllOne ao = new AllOne();
    ao.inc("hello");
    ao.inc("world");
    ao.inc("leet");
    ao.inc("code");
    ao.inc("DS");
    ao.inc("leet");
    ao.inc("DS");
    ao.dec("leet");
    System.out.println(ao.getMaxKey());
  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    if (keyMap.containsKey(key)) {
      Bucket bk = keyMap.get(key);
      bk.keys.remove(key);
      int count = bk.count + 1;
      // put such key into new Bucket
      Bucket newBk = bkMap.get(count);
      if (newBk == null) {
        newBk = new Bucket(count);
        bkMap.put(count, newBk);
        insertBucketBefore(bk, newBk);
      }
      newBk.keys.add(key);
      if (bk.keys.isEmpty()) {
        // remove such bucket
        deleteBucket(bk);
      }
      keyMap.put(key, newBk);
    } else {
      // not exist
      Bucket bk = bkMap.get(1);
      if (bk == null) {
        bk = new Bucket(1);
        insertBucketAfter(tail, bk);
        bkMap.put(1, bk);
      }
      bk.keys.add(key);
      keyMap.put(key, bk);
    }
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    Bucket bk = keyMap.get(key);
    if (bk == null)
      return;
    if (bk.count == 1) {
      // remove key
      keyMap.remove(key);
    } else {
      int count = bk.count - 1;
      Bucket newBk = bkMap.get(count);
      if (newBk == null) {
        newBk = new Bucket(count);
        bkMap.put(count, newBk);
        insertBucketAfter(bk, newBk);
      }
      newBk.keys.add(key);
      keyMap.put(key, newBk);
    }
    bk.keys.remove(key);
    if (bk.keys.isEmpty())
      deleteBucket(bk);
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    return head == null ? "" : head.keys.iterator().next();
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    return tail == null ? "" : tail.keys.iterator().next();
  }

  private void insertBucketBefore(Bucket target, Bucket newBk) {
    Bucket prev = target.prev;
    if (prev != null)
      prev.next = newBk;
    else
      head = newBk;
    newBk.prev = prev;
    newBk.next = target;
    target.prev = newBk;
  }

  private void insertBucketAfter(Bucket target, Bucket newBk) {
    if (target == null) {
      // empty
      head = newBk;
      tail = newBk;
      return;
    }
    Bucket next = target.next;
    target.next = newBk;
    newBk.prev = target;
    newBk.next = next;
    if (next != null)
      next.prev = newBk;
    else
      tail = newBk;
  }

  private void deleteBucket(Bucket bk) {
    Bucket prev = bk.prev, next = bk.next;
    if (prev != null)
      prev.next = next;
    else
      head = next;
    if (next != null)
      next.prev = prev;
    else
      tail = prev;
    bkMap.remove(bk.count);
  }

  class Bucket {
    int count;
    Set<String> keys;
    Bucket prev, next;

    Bucket(int c) {
      count = c;
      keys = new HashSet<>();
    }
  }
}
