package com.samy.leetcode.algorithm.hard;

import com.sun.tools.javac.util.Assert;


/**
 * <a href="https://leetcode.com/problems/design-skiplist/">Design Skiplist</a>
 * <a href="https://www.geeksforgeeks.org/skip-list/">GeeksforGeeks skip list I</a>
 * <a href="https://www.geeksforgeeks.org/skip-list-set-2-insertion/">GeeksforGeeks skip list II</a>
 * <a href="https://www.geeksforgeeks.org/skip-list-set-3-searching-deletion/">GeeksforGeeks skip list III</a>
 */
public class DesignSkiplist {
  public static void main(String[] args) {
    Skiplist skiplist = new Skiplist();

    skiplist.add(1);
    skiplist.add(2);
    skiplist.add(3);
    Assert.check(!skiplist.search(0));   // return false.
    skiplist.add(4);
    Assert.check(skiplist.search(1));   // return true.
    Assert.check(!skiplist.erase(0));    // return false, 0 is not in skiplist.
    Assert.check(skiplist.erase(1));    // return true
    Assert.check(!skiplist.search(1));   // return false, 1 has already been erased.
  }
}

class Skiplist {
  private static final float FRACTION = 0.5f;
  private static final int ESTIMATED_MAX_NUM_ELEMENT = 20000;
  private static final int MAX_LEVEL = (int) (Math.log(ESTIMATED_MAX_NUM_ELEMENT) / Math.log(1 / FRACTION));

  private static class Node {
    int _value;
    int _count;
    Node[] _next;

    Node(int v, int level) {
      _value = v;
      _count = 1;
      _next = new Node[level];
    }
  }

  private Node _header;

  public Skiplist() {
    _header = new Node(-1, MAX_LEVEL);
  }

  public boolean search(int target) {
    Node cur = _header;
    for (int level = MAX_LEVEL-1; level > -1; level--) {
      while(cur._next[level] != null && cur._next[level]._value < target) {
        cur = cur._next[level];
      }
    }
    // down to the bottom level and forward to the next
    cur = cur._next[0];
    return cur != null && cur._value == target;
  }

  public void add(int num) {
    Node[] levelNodes = new Node[MAX_LEVEL];
    Node cur = _header;
    for (int level = MAX_LEVEL-1; level > -1; level--) {
      while(cur._next[level] != null && cur._next[level]._value < num) {
        cur = cur._next[level];
      }
      levelNodes[level] = cur;
    }
    cur = cur._next[0];
    if (cur != null && cur._value == num) {
      cur._count++;
    } else {
      // cur is null or cur.value is greater than num
      int newLevel = randomLevel();
      Node newNode = new Node(num, newLevel);
      // update
      for (int level = newLevel-1; level>-1; level--) {
        newNode._next[level] = levelNodes[level]._next[level];
        levelNodes[level]._next[level] = newNode;
      }
    }
  }

  public boolean erase(int num) {
    Node[] levelNodes = new Node[MAX_LEVEL];
    Node cur = _header;
    for (int level = MAX_LEVEL-1; level > -1; level--) {
      while(cur._next[level] != null && cur._next[level]._value < num) {
        cur = cur._next[level];
      }
      levelNodes[level] = cur;
    }
    cur = cur._next[0];
    if (cur == null || cur._value > num) {
      // doesn't exist in the list, do nothing
      return false;
    } else if ((--cur._count) == 0) {
      // find and only one value
      for (int level = cur._next.length-1; level > -1; level--) {
        levelNodes[level]._next[level] = cur._next[level];
      }
    }
    return true;
  }

  private int randomLevel() {
    int level = 1;
    while (Math.random() < FRACTION && level < MAX_LEVEL)
      level++;
    return level;
  }
}
